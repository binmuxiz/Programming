package generics.자바의정석.ch12_generics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("초록사과", 300));
        appleBox.add(new Apple("초록사과", 100));
        appleBox.add(new Apple("초록사과", 200));

        grapeBox.add(new Grape("청포도", 100));
        grapeBox.add(new Grape("청포도", 200));
        grapeBox.add(new Grape("청포도", 300));

        /**
         * 해당 메소드의 시그니처는 아래와 같다.
         * public static <T> void sort(List<T> list, Comparator<? super T> c)
         * 만약 Comparator 클래스의 제네릭 타입이 <? super T> 가 아니라 <T> 였으면 아래의 코드처럼
         * AppleComp, GrapeComp라는 Comparator를 구현하는 클래스를 각각 만들어야 한다.
         * AppleComp와 GrapeComp는 타입만 다를 뿐 완전히 같은 코드이다.
         * 코드의 중복도 문제이지만, 새로운 Fruit의 자손이 생길때마다 똑같은 코드를 반복해서 만들어야 한다.
         */
        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);

        /**
         * 위와 같은 문제를 해결하기 위해서는
         * 타입 매개변수에 하한 제한의 와일드 카드를 적용해야 한다.
         * sort 메소드는 그렇게 정의되어 있다.
         * 매개변수 타입이 Comparator<? super Apple>이라는 의미는 Comparator 타입의 매개변수로
         * Comparator<Fruit>, Comparator<Apple>, Comparator<Object> 중의 하나가 올 수 있다는 뜻이다.
         * 이래는 Comparator<? super Fruit>을 넣은 것이다.
         */
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println(appleBox);
        System.out.println(grapeBox);

    }
}

class Fruit {
    String name;
    int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class Apple extends Fruit {

    public Apple(String name, int weight) {
        super(name, weight);
    }
}

class Grape extends Fruit {

    public Grape(String name, int weight) {
        super(name, weight);
    }
}

class AppleComp implements Comparator<Apple> {

    @Override
    public int compare(Apple o1, Apple o2) {
        return o2.weight - o1.weight;
    }
}

class GrapeComp implements Comparator<Grape> {
    @Override
    public int compare(Grape o1, Grape o2) {
        return o2.weight - o1.weight;
    }
}

class FruitComp implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.weight - o2.weight;
    }
}



class FruitBox<T extends Fruit> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}