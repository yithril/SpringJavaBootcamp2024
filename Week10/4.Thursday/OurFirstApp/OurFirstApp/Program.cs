//variables
using OurFirstApp;

string name = "Jonathan";
char letter = 'A';

int id = 10;
long something = 200;
double floatingNumber = 10.5;
float anotherFloatingNumber = 20.7f;

decimal useThisForMoney = 10.25m;

//user input
Console.WriteLine("What is your name good sir?");

string userInput = Console.ReadLine();

Console.WriteLine("Hi there " + userInput + "!");

//instead of printf
Console.WriteLine($"Hi there {userInput}");

//while loops are the same
int i = 10;
while(i < 0)
{
    i--;
}

//for loops are the same
for(int j = 0; j < 10; j++)
{

}

int[] intArray = new int[10];

//Java enhanced for loop equivalent
foreach(int number in intArray)
{

}

//Collections and Data Structures
List<string> fruits = new List<string>();

fruits.Add("Strawberries");
fruits.Add("Grapefruit");
fruits.Remove("Grapefruit");

//Hashmap are called Dictionaries
Dictionary<string, int> nameAgePair = new Dictionary<string, int>();

nameAgePair.Add("bob", 50);

Caveman caveman = new Caveman("Bob", 20, "Caveman", true);

await caveman.SaySomething();

Dog fido = new("Fido", "German Shepherd");