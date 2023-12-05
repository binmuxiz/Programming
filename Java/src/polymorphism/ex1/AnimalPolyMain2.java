package polymorphism.ex1;

public class AnimalPolyMain2 {
    public static void main(String[] args) {

        Animal[] animals = {new Dog(), new Cat(), new Caw()};

        for (Animal animal : animals) {
            sound(animal);
        }
    }

    private static void sound(Animal animal) {
        System.out.println("동물 소리 시작");
        animal.sound();
        System.out.println("동물 소리 끝");
    }
}
