package patterns.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<TextMemento> savedStates = new ArrayList<>();

    public void addMemento(TextMemento memento) {
        savedStates.add(memento);
    }

    public TextMemento getMemento(int index) {
        return savedStates.get(index);
    }
}
