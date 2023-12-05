package extends1.ex1;

public class CarMain {

    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        Car car2 = new ElectricCar();
        car2.move();

        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        System.out.println(electricCar.brand);
    }
}
