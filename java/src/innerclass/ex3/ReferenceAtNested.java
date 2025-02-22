package innerclass.ex3;

public class ReferenceAtNested {

    static class StaticNested {
        private int staticNestedInt = 0;
    }

    class Inner {
//        private static int staticInt = 10;
        private int innerValue = 10;
    }

    public void setValue(int value) {
        // 객체를 생성한 후 그 값을 참조하는 것은 가능하다.
        StaticNested staticNested = new StaticNested();
        staticNested.staticNestedInt = value;

        Inner inner = new Inner();
        inner.innerValue = value;
    }

}
