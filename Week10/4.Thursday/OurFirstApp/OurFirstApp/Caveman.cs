namespace OurFirstApp;

public class Caveman : Person
{
    public bool HasClub { get; set; }

    public Caveman(string name, int age, string profession, bool hasClub) : base(name, age, profession)
    {
        HasClub = hasClub;
    }

    public async Task<string> SaySomething()
    {
        return "Hi there";
    }
}
