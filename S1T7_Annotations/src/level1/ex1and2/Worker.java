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

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double calculateSalary(int hoursWorked) {
        return hoursWorked * this.pricePerHour;
    }

}
