package polymorphism.ex4;

public class InterfaceAnimalMain {
    public static void main(String[] args) {
//        InterfaceAnimal interfaceAnimal = new InterfaceAnimal();  //  InterfaceAnimal' is abstract; cannot be instantiated


        InterfaceAnimal dog = new Dog();
        InterfaceAnimal cat = new Cat();

        dog.move();
        cat.move();
        dog.sound();
        cat.sound();
    }
}
