package ua.com.alevel.slide23;

import java.io.FileWriter;
import java.io.IOException;

public class CarImpl {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", new String[]{"Red", "Blue"},
                "km/h", 230, 3.5,
                5400, "11.8:1", 5);
        BuildJSON buildJSON = new BuildJSON(car);
        try (FileWriter fileWriter = new FileWriter("src/main/resources/car.json", false)) {
            fileWriter.write("{\n");
            fileWriter.write(buildJSON.createBrand());
            fileWriter.write(buildJSON.createModel());
            fileWriter.write(buildJSON.createColors());
            fileWriter.write(buildJSON.createMaxSpeed());
            fileWriter.write(buildJSON.createEngine());
            fileWriter.write(buildJSON.createSeatingCapacity());
            fileWriter.write("}");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
