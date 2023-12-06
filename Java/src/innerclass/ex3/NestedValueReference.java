package innerclass.ex3;

import innerclass.ex2.EventListener;

public class NestedValueReference {
    public int publicInt = 0;
    protected int protectInt = 0;
    int defaultInt = 0;
    private int privateInt = 0;
    static int staticInt = 0;

    static class StaticNested {
        public void setValue() {
            staticInt = 4;
        }
    }

    class Inner {
        public void setValue() {
            publicInt = 1;
            protectInt = 2;
            defaultInt = 3;
            privateInt = 4;
            staticInt = 5;
        }
    }

    public void setValue() {
        EventListener lister = new EventListener() {
            @Override
            public void onClick() {
                publicInt = -1;
                protectInt = -2;
                defaultInt = -3;
                privateInt = -4;
                staticInt = -5;
            }
        };
    }
}
