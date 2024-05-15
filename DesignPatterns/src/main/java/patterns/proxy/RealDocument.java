package patterns.proxy;

public class RealDocument implements Document {
    private String filename;

    public RealDocument(String filename) {
        this.filename = filename;
        loadDocument();
    }

    private void loadDocument() {
        System.out.println("Loading document: " + filename);
    }

    @Override
    public void displayContent() {
        System.out.println("Displaying content of: " + filename);
    }
}
