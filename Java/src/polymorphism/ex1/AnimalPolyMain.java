package polymorphism.ex1;

public class AnimalPolyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound(); // 메소드 오버라이딩을 했기 때문에 자식클래스의 오버라이딩 된 메소드를 호출한다.
        System.out.println("동물 소리 테스트 종료");
    }
}
