package level1.ex1and2;

public class OnSiteWorker extends Worker {
    private static double gasoline = 111.11;

    public OnSiteWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }
    @Override
    public double calculateSalary(int hoursWorked) {
        return ((super.calculateSalary(hoursWorked)) + gasoline);
    }

    @Deprecated
    public double calculateWrongWay(int hours) {
        return hours * getPricePerHour() * 0.9;
    }

}
