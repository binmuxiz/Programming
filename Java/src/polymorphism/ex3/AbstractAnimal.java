package polymorphism.ex3;

public class AbstractAnimal {
    public static void main(String[] args) {
//        Animal animal = new Animal(); //Animal' is abstract; cannot be instantiated

        Animal dog = new Dog();
        Animal cat = new Cat();

        sound(dog);
        sound(cat);
        dog.move();
        cat.move();
    }

    public static void sound(Animal animal) {
        System.out.println("동물소리 시작");
        animal.sound();
        System.out.println("동물소리 종료");
    }
}
