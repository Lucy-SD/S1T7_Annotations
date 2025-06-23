package level2and3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class AnnotationProcessor {

    public static void processJsonSerializable(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("--- Procesando objeto de la clase: " + clazz.getSimpleName() + " ---");

        if (clazz.isAnnotationPresent(JsonSerializable.class)) {
            System.out.println("La anotación se efectuó correctamente.");

            JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
            String directory = annotation.directory();

            System.out.println("Directorio destino de la anotación: " + directory);

            String json = createJsonFromObjet(obj);
            writeJsonToFile(json, directory, clazz.getSimpleName() + ".json");
        } else {
            System.out.println("La clase " + clazz.getSimpleName() + " NO tiene anotachiones" +
                    "con @JsonSerializable.\nNo se puede generar un archivo JSon.");
        }
    }


    private static String createJsonFromObjet(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> clazz = obj.getClass();

        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Se encontraron " + fields.length + " archivos utilizando reflexión.");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            field.setAccessible(true);

            try {
                Object value = field.get(obj);
                json.append(field.getName()).append(": ").append(value);

                if (i < fields.length - 1) {
                    json.append("; ");
                }

            } catch (IllegalAccessException e) {
                System.err.println("Error accessing field: " + field.getName());
            }
        }

        json.append("}");
        return json.toString();
    }

    private static void writeJsonToFile(String json, String directory, String fileName) {

        try {
            File dir = new File(directory);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (created) {
                    System.out.println("Directorio <" + directory + "> creado correctamente.");
                }
            }
            String fullPath = directory + fileName;
            FileWriter writer = new FileWriter(fullPath);
            writer.write(json);
            writer.close();

            System.out.println("Archivo JSon creado correctamente: " + fullPath);
            System.out.println("Contenido del archivo:\n" + json);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}


