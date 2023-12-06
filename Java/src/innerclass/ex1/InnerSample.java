package innerclass.ex1;

public class InnerSample {
    public static void main(String[] args) {
        InnerSample innerSample = new InnerSample();
        innerSample.makeInnerObject();
    }

    public void makeInnerObject() {
        OuterOfInner outerOfInner = new OuterOfInner();
        OuterOfInner.Inner inner = outerOfInner.new Inner();
        inner.setValue(3);
        System.out.println(inner.getValue());

    }
}