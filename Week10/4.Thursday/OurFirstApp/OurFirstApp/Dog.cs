namespace OurFirstApp;

public class Dog
{
    public string Name { get; set; }
    public string Breed { get; set; }

    //Short constructors
    public Dog(string name, string breed) => (Name, Breed) = (name, breed);

    //Short way to write methods
    public string Bark() => "Woof!";
}
