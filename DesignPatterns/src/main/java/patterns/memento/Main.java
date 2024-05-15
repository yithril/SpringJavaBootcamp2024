package patterns.memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.write("Hello, ");
        caretaker.addMemento(editor.save());

        editor.write("world! ");
        caretaker.addMemento(editor.save());

        editor.write("How are you?");
        editor.printContent();

        editor.restore(caretaker.getMemento(0));
        editor.printContent();
    }
}
