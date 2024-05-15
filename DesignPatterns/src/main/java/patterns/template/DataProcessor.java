package patterns.template;

public abstract class DataProcessor {
    public final void process() {
        readData();
        processData();
        saveData();
    }
    protected abstract void readData();
    protected abstract void processData();
    protected void saveData() {
        System.out.println("Data has been saved.");
    }
}
