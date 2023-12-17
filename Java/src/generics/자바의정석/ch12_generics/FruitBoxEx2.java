package generics.자바의정석.ch12_generics;

import java.util.ArrayList;

public class FruitBoxEx2 {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        System.out.println(fruitBox.get(0));
        System.out.println(fruitBox.get(1));
        System.out.println(fruitBox.get(2));

        System.out.println(fruitBox);

        Box box = new Box(); // Box<Object>와 같음
        box.add(new Apple());
        box.add(new Toy());
        System.out.println(box);

        Toy toy = (Toy) box.get(0); // runtime error! (Apple cannot be cast to class Toy)
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}


class Fruit {
    @Override
    public String toString() {
        return "Fruit";
    }

}


class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    @Override
    public String toString() {
        return "Grape";
    }
}

class Toy {
    @Override
    public String toString() {
        return "Toy";
    }
}