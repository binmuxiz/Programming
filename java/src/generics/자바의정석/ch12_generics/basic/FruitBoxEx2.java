package generics.자바의정석.ch12_generics.basic;

import java.util.ArrayList;

public class FruitBoxEx2 {
    public static void main(String[] args) {
        Box<Fruit> box = new Box<>();
        box.add(new Fruit());
        box.add(new Apple());
        box.add(new Grape());

        System.out.println(box.get(0));
        System.out.println(box.get(1));
        System.out.println(box.get(2));

        System.out.println(box);

        Box box2 = new Box(); // Box<Object>와 같음
        box2.add(new Apple());
        box2.add(new Toy());
        System.out.println(box2);

        Box<Toy> toyBox = new Box<>();
        toyBox.add(new Toy());
        System.out.println(toyBox);

//        Toy toy = (Toy) box.get(0); // runtime error! (Apple cannot be cast to class Toy)

        /**
         * Restricted Generic Class
         * 제네릭 클래스의 타입 변수를 특정 타입으로 제한하고 싶은 경우
         */
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        System.out.println("fruitBox -> " + fruitBox);

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
//        appleBox.add(new Grape()); // compile error! Grape는 Apple의 자손이 아니다.
        System.out.println("appleBox -> " + appleBox);


//        Box<Toy> toyBox1 = new FruitBox<>(); // compile error! Box의 타입 매개변수는 Toy를 대입할 수 있어도 FruitBox는 불가능하다.
//        FruitBox<Grape> grapeFruitBox = new FruitBox<Apple>(); // compile error! 타입 불일치



    }
}

// Fruit의 자손 타입이면서 Eatable을 구현한 클래스만 타입 매개변수 T에 대입 가능하다.
class FruitBox<T extends Fruit & Eatable> extends Box<T>{

}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }
    ArrayList<T> getList() {
        return this.list;
    }
    @Override
    public String toString() {
        return list.toString();
    }
}

interface Eatable {}

class Fruit implements Eatable{
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