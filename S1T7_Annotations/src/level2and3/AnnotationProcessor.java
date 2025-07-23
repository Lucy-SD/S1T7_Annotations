package level2and3;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class AnnotationProcessor {

    private void validateJsonSerializable(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new IllegalArgumentException("La clase " + clazz.getSimpleName() + " NO contiene anotaciones " +
                    "con @JsonSerializable.\nNo se puede generar un archivo JSon.");
        }
    }

    private String getJsonSerializableDirectory(Class<?> clazz) {
        return clazz.getAnnotation(JsonSerializable.class).directory();
    }

    private void appendFieldToJson(StringBuilder json, Field field, Object obj, boolean isLastField) {

        try {
            Object value = field.get(obj);
            json.append("\t\"")
                    .append(field.getName())
                    .append("\" : \"")
                    .append(value)
                    .append("\"");

            if (!isLastField) {
                json.append(", ");
            }
            json.append("\n");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error al acceder al campo: " + field.getName(), e);
        }
    }

    private String convertObjectToJson(Object obj) {
        StringBuilder json = new StringBuilder("{\n");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            appendFieldToJson(json, field, obj, i == fields.length - 1);
        }
        json.append("}");
        return json.toString();
    }

    private void writeJsonToFile(String json, String filePath) {

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.write(json);
            System.out.println("Archivo JSON creado correctamente: <" + filePath
                    + ">.\nContenido del archivo:\n" + json);

        } catch (IOException e) {
            throw new RuntimeException("Error al escribir el archivo JSON: " + filePath, e);
        }
    }

    public void processJsonSerializable(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("--- Objeto de la clase: " + clazz.getSimpleName() + " ---");

        validateJsonSerializable(clazz);

        String directory = getJsonSerializableDirectory(clazz);
        String json = convertObjectToJson(obj);
        writeJsonToFile(json, directory);
    }
}
