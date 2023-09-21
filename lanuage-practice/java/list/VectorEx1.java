import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {

        System.out.println("===============init==============");
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        print(v);

        System.out.println("===============TrimToSize==============");
        v.trimToSize(); // 빈공간을 없앤다. size == capacity
        print(v);

        System.out.println("===============ensureCapacity==============");
        v.ensureCapacity(4);
        print(v);

        System.out.println("===============setSize==============");
        v.setSize(5);
        print(v);

        System.out.println("===============clear==============");
        v.clear();
        print(v);

    }   

    public static void print(Vector v) {
        
        System.out.println(v);
        System.out.println("size : " + v.size());
        System.out.println("capacity : " + v.capacity());
    }
}
