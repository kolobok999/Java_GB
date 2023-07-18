package Homeworks.Homework_6;

public class Notebook {
    private String brand;
    private String modelName;
    private String color;
    private int hardDiskSize;
    private String cpuModel;
    private int ramMemory;
    private String operatingSystem;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(int hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public int getRamMemory() {
        return ramMemory;
    }

    public void setRamMemory(int ramMemory) {
        this.ramMemory = ramMemory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Notebook() {
    }

    public Notebook(String brand, String modelName, String color, int hardDiskSize, String cpuModel, int ramMemory, String operatingSystem) {
        this.brand = brand;
        this.modelName = modelName;
        this.color = color;
        this.hardDiskSize = hardDiskSize;
        this.cpuModel = cpuModel;
        this.ramMemory = ramMemory;
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s\n" +
                "model name: %s\n" +
                "color: %s\n" +
                "Hard disk size: %d\n" +
                "CPU model: %s\n" +
                "RAM memory: %d\n" +
                "Operating system: %s\n",
                brand, modelName, color, hardDiskSize, cpuModel, ramMemory, operatingSystem);

    }
}