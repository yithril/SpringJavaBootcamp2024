package patterns.template;

public class XMLProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from XML file...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing XML data...");
    }
}
