package patterns.proxy;

public class Main {
    public static void main(String[] args) {
        Document doc = new ProxyDocument("LargeDocument.pdf");

        System.out.println("Accessing document via proxy...");
        doc.displayContent();

        System.out.println("Accessing document again...");
        doc.displayContent();
    }
}
