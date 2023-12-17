package generics.자바의정석.ch12_generics.basic;

public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        appleBox.add(new Apple());
//        appleBox.add(new Grape());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));

        System.out.println(Juicer.makeJuice2(fruitBox));
//        System.out.println(Juicer.makeJuice2(appleBox)); // compile error! FruitBox<Apple>은 대입될 수 없음



    }
}

class Juice {
    String name;

    public Juice(String name) {
        this.name = name + "Juice";
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer {

    /**
     * Juicer 클래스는 지네릭 클래스가 아닌데다,
     * 지네릭 클래스라 해도 static 메소드에는 타입 매개변수 T를 사용할 수 없다.
     * 그래서 아예 지네릭스를 적용하지 않던가, 아래와 같이 특정 타입을 지정해주어야 한다.
     * 하지만 FruitBox<Apple> 객체는 makeJuice2의 매개 변수에 대입될 수 없다.
     */
    static Juice makeJuice2(FruitBox<Fruit> box) {
        String str = "";
        for (Fruit f : box.getList()) {
            str += f + " ";
        }
        return new Juice(str);
    }

    /**
     * 아래와 같이 오버로딩을 하면 컴파일 에러가 발생한다.
     * 지네릭 타입이 다른 것만으로는 오버로딩이 성립되지 않는다.
     * 지네릭 타입은 컴파일러가 컴파일 할 때만 사용하고 제거해버린다.
     * 이는 메소드 오버로딩이 아니라 "메소드 중복정의"이다.
     * 이를 위해 고안된 것이 "와일드 카드"이다.
     */
//    static Juice makeJuice2(FruitBox<Apple> box) {
//        String str = "";
//        for (Fruit f : box.getList()) {
//            str += f + " ";
//        }
//        return new Juice(str);
//    }


    /**
     *  와일드 카드를 사용한 지네릭
     *  와일드 카드 ?는 아따힌 타입도 가능하다는 의미이다.
     *  하지만 ?만으로는 Object와 다를 것이 없으므로,
     *  아래와 같이 'extends' 또는 'super'로 상한(upper bound)과 하한(lower bound)을 제한할 수 있다.
     *  <? extedns T> 와일드 카드의 상한 제한. T와 그 자손들만 가능
     *  <? super T> 와일드 카드의 하한 제한. T와 그 조상들만 가능
     *  <?> 제한 없음. 모든 타입이 가능. <? extends Object>와 동일
     */
    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String str = "";
        for (Fruit f : box.getList()) {
            str += f + " ";
        }
        return new Juice(str);
    }

    /**
     * 지네릭 메소드
     * makeJuice를 지네릭 메소드로 변환시켰다.
     * 지네릭 타입의 선언 위치는 반환 타입 바로 앞이다.
     * 지네릭 메소드에 정의된 타입변수는 지네릭 클래스에 정의된 타입변수와 전혀 별개의 것이다!!
     * 같은 문자를 사용해도 같은 것이 아니다!!
     * 지역변수를 선언한 것과 비슷하다고 생각하면 된다.
     * 이 타입 매개변수는 메소드 내에서만 지역적으로 사용될 것이므로 메소드가 static이건 아니건 상관 없다.
     */
    static <T extends Fruit> Juice makeJuice4(FruitBox<T> box) {
        String str = "";
        for (Fruit f : box.getList()) {
            str += f + " ";
        }
        return new Juice(str);
    }
}

