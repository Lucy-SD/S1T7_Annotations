package level2and3;

import level1.ex1and2.Worker;

public class Main {
    public static void main(String[] args) {

        AnnotationProcessor processor = new AnnotationProcessor();

        Person person = new Person("Bob Dyl", 44, "bobdyl@mail.com");
        Product product = new Product("SmartPhone", 567.73, 25);
        Worker worker = new Worker("Jane", "Lane", 12.5);


        System.out.println("""
                
                === Nivel 2 -> creación de anotaciones @JsonSerializable personalizadas ===
                === Nivel 3 -> uso de reflexión para leerlas en tiempo de ejecución (RUNTIME) ===""");

        try{
            System.out.println("\n-Procesando objetos con anotación:\n");
            processor.processJsonSerializable(person);
            processor.processJsonSerializable(product);

            System.out.println("\n-Procesando objeto sin anotación:\n");
            processor.processJsonSerializable(worker);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
