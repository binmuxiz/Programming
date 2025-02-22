package innerclass.ex1;

public class OuterOfStatic {
    static class StaticNested {
        private int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public static void staticMethod() {
            System.out.println("OuterOfStatic.StaticNested.staticMethod()");
        }
    }
}
