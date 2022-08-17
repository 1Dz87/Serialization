import java.util.List;

public class Garage {

    private String address;

    private List<Car> cars;

    public Garage() {
    }

    public Garage(String address, List<Car> cars) {
        this.address = address;
        this.cars = cars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
