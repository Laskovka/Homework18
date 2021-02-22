package ua.com.alevel.slide23;

public class BuildJSON {
    private Car car;

    public BuildJSON(Car car) {
        this.car = car;
    }

    public String createBrand() {
        return " \"brand\": \"" + car.getBrand() + "\",\n";
    }

    public String createModel() {
        return " \"model\": \"" + car.getModel() + "\",\n";
    }

    public String createColors() {
        String colors = " \"colors\": [\n";
        for (int i = 0; i < car.getColors().length; i++) {
            if (i + 1 == car.getColors().length) {
                colors += "   \"" + car.getColors()[i] + "\"\n";
            } else {
                colors += "   \"" + car.getColors()[i] + "\",\n";
            }
        }
        colors += " ],\n";
        return colors;
    }

    public String createMaxSpeed() {
        String maxSpeed = " \"maxSpeed\": {\n";
        maxSpeed += "   \"unit\": \"" + car.getUnit() + "\",\n";
        maxSpeed += "   \"value\": " + car.getValue() + "\n";
        maxSpeed += " },\n";
        return maxSpeed;
    }

    public String createEngine() {
        String engine = " \"engine\": {\n";
        engine += "   \"volume\": " + car.getVolume() + ",\n";
        engine += "   \"rpm\": " + car.getRpm() + ",\n";
        engine += "   \"compressionRatio\": \"" + car.getCompressionRatio() + "\"\n";
        engine += " },\n";
        return engine;
    }

    public String createSeatingCapacity() {
        return " \"seatingCapacity\": " + car.getSeatingCapacity() + "\n";
    }
}
