package patterns.factory.abstractfactory;

public interface WidgetFactory {
    Button createButton();
    Checkbox createCheckbox();
}

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    public void render() { System.out.println("Render Windows Button"); }
}

class MacOSButton implements Button {
    public void render() { System.out.println("Render MacOS Button"); }
}

class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Render Windows Checkbox"); }
}

class MacOSCheckbox implements Checkbox {
    public void render() { System.out.println("Render MacOS Checkbox"); }
}

class WindowsFactory implements WidgetFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements WidgetFactory {
    public Button createButton() {
        return new MacOSButton();
    }
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}