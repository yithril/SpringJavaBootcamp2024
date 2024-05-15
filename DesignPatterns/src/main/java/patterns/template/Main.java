package patterns.template;

public class Main {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor();
        System.out.println("Processing CSV data:");
        csvProcessor.process();

        DataProcessor xmlProcessor = new XMLProcessor();
        System.out.println("\nProcessing XML data:");
        xmlProcessor.process();
    }
}