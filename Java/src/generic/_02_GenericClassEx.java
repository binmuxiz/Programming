package generic;

public class _02_GenericClassEx<K, V> {
    private K key;
    private V value;

    void set(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }
}


class Main2 {
    public static void main(String[] args) {
        _02_GenericClassEx<String, Integer> example2 = new _02_GenericClassEx<>();

        example2.set("10", 10);

        System.out.println("key : " + example2.getKey());
        System.out.println("K type : " + example2.getKey().getClass().getName());

        System.out.println("value : " + example2.getValue());
        System.out.println("V type : " + example2.getValue().getClass().getName());

    }
}