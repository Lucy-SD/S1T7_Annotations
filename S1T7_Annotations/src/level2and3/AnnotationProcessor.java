package level2and3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class AnnotationProcessor {

    private static String createJsonFromObj(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for(int i = 0; i < fields.length; i++) {
            Field field = fields [i];

            field.setAccessible(true);

            try {
                Object value = field.get(obj);
                json.append("\"").append(field.getName()).append("\" : \"").append(value);

                if(i < fields.length - 1) {
                    json.append("\",\n");
                }
            } catch (IllegalAccessException e) {
                System.out.println("Error al acceder al campo: " + field.getName());
            }
        }
        json.append("\"\n}");
        return json.toString();
    }

    private static void writeJsonToFile(String json, String directory) {

        try (FileWriter writer = new FileWriter(directory)){

            writer.write(json);
            System.out.println("Archivo Json creado correctamente: " + directory
            + "\nContenido del archivo:\n" + json);

        } catch (IOException e) {
            System.out.println("Error: algo ha salido mal.");
        }

    }

    public static void processJsonSerializable(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("--- Procesando objeto de la clase: " + clazz.getSimpleName() + " ---");

        if(clazz.isAnnotationPresent(JsonSerializable.class)) {
            System.out.println("Anotación efectuada correctamente.");

            JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
            String directory = annotation.directory();

            System.out.println("La anotación se guardó correctamente en el directorio.");

            String json = createJsonFromObj(obj);
            writeJsonToFile(json, directory);
        } else {
            System.out.println("La clase " + clazz.getSimpleName() + " NO contiene anotaciones " +
                    "con @JsonSerializable.\nNo se puede generar un archivo JSon.");
        }

    }

}
