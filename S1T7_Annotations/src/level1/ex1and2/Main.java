package level1.ex1and2;

public class Main {
    public static void main(String[] args) {

        Worker generalWorker = new Worker("Pepi", "Montoto", 14.0);
        OnSiteWorker onSiteWorker = new OnSiteWorker("Jota", "Erre", 12.0);
        OnLineWorker onLineWorker = new OnLineWorker("Jana", "Lana", 16.5);
        int hoursWorked = 40;

        System.out.println("\n=== Nivel 1 - Ejercicio 1: @Override ===");

        System.out.println("Jornada de 40 horas -->\n   Sueldo Base: " + generalWorker.calculateSalary(hoursWorked)
        + "€.\n   Sueldo OnSite: " + onSiteWorker.calculateSalary(hoursWorked) + "€.\n   Sueldo OnLine: "
        + onLineWorker.calculateSalary(hoursWorked) + "€.");

        System.out.println("\n=== Nivel 1 - Ejercicio 2: @Deprecation ===");
        useDeprecatedMethods(onSiteWorker, onLineWorker);
    }

    @SuppressWarnings("deprecation")
    public static void useDeprecatedMethods(OnSiteWorker onSiteWorker, OnLineWorker onLineWorker) {
        System.out.println("Utilizando métodos obsoletos -->" +
                  "\n    Cálculo erróneo de sueldo onLine: " + onLineWorker.wrongCalculation(40)
                + "\n    Cálculo erróneo de sueldo presencial: " + onSiteWorker.calculateWrongWay(40));

    }
}