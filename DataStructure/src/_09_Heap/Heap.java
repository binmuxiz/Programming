package _09_Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PropertyResourceBundle;

public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private int size;
    private Object[] array;

    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public Heap(int initialCapacity) {
        this(initialCapacity, null);
    }

    public Heap(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public Heap(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.comparator = comparator;
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                            oldCapacity + 2:
                                            oldCapacity >> 1);

        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(newCapacity);
        }
        array = Arrays.copyOf(array, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    public void add(E value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int s = size + 1;
        if (s >= array.length) {
            grow(s + 1);
        }
        siftUp(s, value);
        size = s;
    }


    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        final E result = (E) array[1];
        final E target = (E) array[size];
        array[size] = null;
        size -= 1;

        if (size > 0) {
            siftDown(1, target);
        }

        return result;
    }

    private void siftUp(int idx, E value) {
        if (this.comparator != null) {
            siftUpComparator(idx, value, this.comparator);
        } else {
            siftUpComparable(idx, value);
        }
    }

    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
        while (idx > 1) {
            int parent = idx >>> 1;
            Object parentVal = array[parent];
            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = target;
    }

    private void siftUpComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx > 1) {
            int parent = idx >>> 1;
            Object parentVal = array[parent];
            if (comp.compareTo((E) parentVal) >= 0) {
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = target;
    }


    public void siftDown(int idx, E target) {
        if (this.comparator != null) {
            siftDownComparator(idx, target, this.comparator);
        } else {
            siftDownComparable(idx, target);
        }
    }

    public void siftDownComparator(int idx, E target, Comparator<? super E> comp) {
        int child;

        while ((child = idx << 1) <= size) {
            Object childVal = array[child];
            int right = child + 1;

            // right child가 left보다 작을 때
            if (right <= this.size && comp.compare((E) childVal, (E) array[right]) > 0) {
                childVal = array[child = right];
            }
            // target이 자식보다 작거나 같을 때 반복문 종료
            if (comp.compare(target, (E) childVal) <= 0) {
                break;
            }
            array[idx] = childVal;
            idx = child;
        }
        array[idx] = target;
    }

    public void siftDownComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;
        int child;

        while ((child = idx << 1) <= size) {
            Object childVal = array[child];
            int right = child + 1;

            if (right <= size && ((Comparable<? super E>) childVal).compareTo((E) array[right]) > 0) {
                childVal = array[child = right];
            }
            if (comp.compareTo((E) childVal) <= 0) {
                break;
            }
            array[idx] = childVal;
            idx = child;
        }
        array[idx] = target;
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (E) array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        for (int i = 1; i <= size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    //TODO clear()

    public Object[] toArray() {
        return Arrays.copyOf(array, size + 1);
    }
}
