package patterns.memento;

public class TextEditor {
    private StringBuilder content;

    public TextEditor() {
        content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
    }

    public void printContent() {
        System.out.println(content.toString());
    }

    public TextMemento save() {
        return new TextMemento(content.toString());
    }

    public void restore(TextMemento memento) {
        content = new StringBuilder(memento.getState());
    }
}
