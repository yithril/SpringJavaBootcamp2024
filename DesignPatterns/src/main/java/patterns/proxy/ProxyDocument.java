package patterns.proxy;

public class ProxyDocument implements Document {
    private String filename;
    private RealDocument realDocument;

    public ProxyDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayContent() {
        if (realDocument == null) {
            realDocument = new RealDocument(filename);
        }
        realDocument.displayContent();
    }
}