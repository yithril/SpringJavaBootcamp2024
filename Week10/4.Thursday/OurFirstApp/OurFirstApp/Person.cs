namespace OurFirstApp;

public class Person
{
    //The equivalent of final is readonly
    public string Name { get; set; }
    public int Age { get; set; }
    public string Profession { get; set; }

    //Constructors
    public Person(string name, int age, string profession)
    {
        Name = name;
        Age = age;
        Profession = profession;
    }

    //Methods
    public void SayHello()
    {
        Console.WriteLine($"Hi my name is: {Name}");
    }
}
