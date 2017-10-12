package veeva.Inheritance;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class ValidateInheritance
{
    public static void main(String args[])
    {
        Dog dog = new Dog();

        Animal animal = (Dog) dog;

        animal.print();
        animal.print2();
    }
}

class Animal
{

    public void print()
    {
        System.out.println("I am an ANimal");
    }

    public static void print2()
    {
        System.out.println("I am a static animal");
    }
}

class Dog extends Animal
{

    @Override public void print()
    {
        System.out.println("I am an DOG");
    }

    public static void print2()
    {
        System.out.println("I am a static DOG");
    }
}