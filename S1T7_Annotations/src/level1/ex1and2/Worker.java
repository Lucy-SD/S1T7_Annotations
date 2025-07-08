package level1.ex1and2;

public class Worker {
    private String firsName;
    private String lastName;
    private double pricePerHour;

    public Worker(String firsName, String lastName, double pricePerHour) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
    
    public double calculateSalary(int hoursWorked) {
        return hoursWorked * this.pricePerHour;
    }

}
