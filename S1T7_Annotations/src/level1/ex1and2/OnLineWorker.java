package level1.ex1and2;

public class OnLineWorker extends Worker {
    private final double INTERNET_RATE = 72.1;

    public OnLineWorker(String firstName, String lastName, double pricePerHour) {
        super(firstName, lastName, pricePerHour);
    }
    @Override
    public double calculateSalary(int hoursWorked) {
        return (super.calculateSalary(hoursWorked)) + INTERNET_RATE;
    }

    @Deprecated
    public double wrongCalculation(int hours) {
        return hours * getPricePerHour();
    }

}
