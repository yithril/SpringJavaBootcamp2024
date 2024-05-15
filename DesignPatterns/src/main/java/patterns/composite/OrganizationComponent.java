package patterns.composite;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract void showDetails();

    public String getName() {
        return name;
    }

    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Feature not available");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Feature not available");
    }
}
