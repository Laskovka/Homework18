package ua.com.alevel.slide23;

public class Car {
    String brand;
    String model;
    String[] colors;
    String unit;
    Integer value;
    Double volume;
    Integer rpm;
    String compressionRatio;
    Integer seatingCapacity;

    public Car(String brand, String model, String[] colors, String unit, Integer value, Double volume, Integer rpm, String compressionRatio, Integer seatingCapacity) {
        this.brand = brand;
        this.model = model;
        this.colors = colors;
        this.unit = unit;
        this.value = value;
        this.volume = volume;
        this.rpm = rpm;
        this.compressionRatio = compressionRatio;
        this.seatingCapacity = seatingCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String[] getColors() {
        return colors;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getValue() {
        return value;
    }

    public Double getVolume() {
        return volume;
    }

    public Integer getRpm() {
        return rpm;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }
}
