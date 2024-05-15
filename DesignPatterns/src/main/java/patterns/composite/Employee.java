package patterns.composite;

public class Employee extends OrganizationComponent {
    private String position;

    public Employee(String name, String position) {
        super(name);
        this.position = position;
    }

    @Override
    public void showDetails() {
        System.out.println(getName() + " (" + position + ")");
    }
}
