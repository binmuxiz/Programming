package polymorphism.ex6;

import java.util.ArrayList;
import java.util.List;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Chicken chicken = new Chicken();

        soundAnimal(dog);
        soundAnimal(bird);
        soundAnimal(chicken);

        flyAnimal(bird);
        flyAnimal(chicken);

        List list = new ArrayList();
    }

    private static void soundAnimal(AbstractAnimal animal) {
        animal.sound();
    }

    private static void flyAnimal(Fly fly) {
        fly.fly();
    }
}
