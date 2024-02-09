public class ArrayDeque<T> {

    private int front;
    private int end;
    private T[] array;
    private int size;
    private static final double REFACTOR = 0.25;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        front = 0;
        end = 1;
        size = 0;
    }

//    public ArrayDeque(ArrayDeque other) {
//        array = (T[]) new Object[other.array.length];
//        System.arraycopy(other.array, 0, array, 0, end);
//        if (other.front >= other.end) {
//            System.arraycopy(other.array, front + 1, array, front + 1, other.array.length - front - 1);
//        }
//    }

    public void addFirst(T item) {
        array[front] = item;
        size += 1;

        if (front == 0) {
            front = array.length - 1;
        }
        else {
            front -= 1;
        }

        if (front == end) {
            resize(array.length + 1);
        }
    }

    public void addLast(T item) {
        array[end] = item;
        size += 1;

        if ((end == array.length - 1) || (end + 1 == front)) {
            resize(array.length + 1);
            return;
        }
        end += 1;
    }

    public  boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int start = front + 1;
        if (front == array.length - 1) {
            start = 0;
        }
        for (int i = start; i < end - 1; i += 1) {
            System.out.print(array[i] + " ");
        }

        System.out.print(array[end - 1]);
        if (front >= end) {
            for (int j = front + 1; j < array.length; j += 1) {
                System.out.print(" " + array[j]);
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        
        size -= 1;
        T item;
        if (front == array.length - 1) {
            item = array[0];
            array[0] = null;
            front = 0;
        }
        else {
            item = array[front + 1];
            array[front + 1] = null;
            front += 1;
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size -= 1;
        T item;
        if (end == 0) {
            item = array[array.length - 1];
            array[array.length - 1] = null;
            end = array.length - 1;
        }
        else {
            item = array[end - 1];
            array[end - 1] = null;
            end -= 1;
        }
        return item;

    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, end);
        if (end <= front) {
            System.arraycopy(array, front + 1, newArray, front + 1 + capacity - array.length, array.length - front - 1);
            front += capacity - array.length;
        }
        array = newArray;
    }

    public T get(int index) {
        if (index < 0 || (index >= array.length)) {
            System.out.print("Beyond range!");
            return null;
        }
        if (index > end - 1 && (index < front + 1) && (front >= end)) {
            System.out.print("Beyond range!");
            return null;
        }
        return array[index];
    }

}
