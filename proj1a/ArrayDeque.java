public class ArrayDeque<T> {

    private int front;
    private int end;
    private T[] array;
    private int size;
    private double r;
    private static final int REFACTOR = 2;
    private static final double USAGEFACTOR = 0.25;

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

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity * REFACTOR];
        System.arraycopy(array,  front + 1, newArray, 1, array.length - front - 1);
        if (end != 0) {
            System.arraycopy(array, 0, newArray, array.length - front, end);
        }
        front = 0;
        end = array.length;
        array = newArray;
    }

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
            resize(array.length);
        }
    }

    public void addLast(T item) {
        array[end] = item;
        size += 1;

        if (end == array.length - 1) {
            end = 0;
        }
        else {
            end += 1;
        }
        if (front == end) {
            resize(array.length);
        }

    }

    public  boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void downsize() {
        T[] newArray = (T[]) new Object[size * REFACTOR];
        if (front <= end) {
            System.arraycopy(array, front + 1, newArray, 1, end - front - 1);
            end -= front;
            front = 0;
            array = newArray;
        }
        else {
            System.arraycopy(array,  front + 1, newArray, 1, array.length - front - 1);
            System.arraycopy(array, 0, newArray, array.length - front, end - 1);
            array = newArray;
            front = 0;
            end = size() + 1;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
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

        if (size >= 16) {
            r = size * 1.00 / array.length;
            if (r <= USAGEFACTOR) {
                downsize();
            }
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
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
        if (size >= 16) {
            r = size * 1.00 / array.length;
            if (r <= USAGEFACTOR) {
                downsize();
            }
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (front <= end) {
            return array[index + front + 1];
        }
        else {
            if ((front + 1 + index) > array.length - 1) {
                return array[index + front + 1 - array.length];
            }
            return array[index + front + 1];
        }
    }

    public void printDeque() {
        if (front <= end) {
            for (int i = front + 1; i < end; i += 1) {
                if (i == end - 1) {
                    System.out.print(array[i]);
                    continue;
                }
                System.out.print(array[i] + " ");
            }
        }
        else {
            for (int i = front + 1; i < array.length; i += 1) {
                if (i == array.length - 1) {
                    System.out.print(array[i]);
                    continue;
                }
                System.out.print(array[i] + " ");
            }
            for (int j = 0; j < end; j += 1) {
                System.out.print(" " + array[j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
       // System.out.println(arr.isEmpty());
        arr.addFirst(0);
        arr.printDeque();
        arr.removeLast();
        arr.printDeque();
    }
}
