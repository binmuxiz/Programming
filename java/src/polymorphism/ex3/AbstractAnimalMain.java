package polymorphism.ex3;

public class AbstractAnimalMain {
    public static void main(String[] args) {
//        Animal animal = new Animal(); //Animal' is abstract; cannot be instantiated

        AbstractAnimal dog = new Dog();
        AbstractAnimal cat = new Cat();

        sound(dog);
        sound(cat);
        dog.move();
        cat.move();
    }

    public static void sound(AbstractAnimal animal) {
        System.out.println("동물소리 시작");
        animal.sound();
        System.out.println("동물소리 종료");
    }
}
