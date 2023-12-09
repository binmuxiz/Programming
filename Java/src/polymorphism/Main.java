package polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.getVal();

        Animal animal1 = new Animal();
        animal1.getVal();
    }
}

class Animal {
    public String val = "ani";

    public void getVal() {
        System.out.println("this.val = " + this.val);
    }
}

class Dog extends Animal{

    public String val = "dog";

    @Override
    public void getVal () {
        System.out.println("this.val = " + this.val + ", super.val = " + super.val);
    }
}

