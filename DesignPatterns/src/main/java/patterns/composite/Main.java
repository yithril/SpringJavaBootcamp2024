package patterns.composite;

public class Main {
    public static void main(String[] args) {
        OrganizationComponent emp1 = new Employee("Alice", "Developer");
        OrganizationComponent emp2 = new Employee("Bob", "Manager");
        OrganizationComponent emp3 = new Employee("Carol", "Analyst");

        Department engineering = new Department("Engineering");
        Department management = new Department("Management");

        engineering.add(emp1);
        engineering.add(emp3);
        management.add(emp2);

        Department company = new Department("TechCorp");
        company.add(engineering);
        company.add(management);

        company.showDetails();
    }
}
