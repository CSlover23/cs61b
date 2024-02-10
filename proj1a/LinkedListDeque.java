public class LinkedListDeque<T> {
    private class IntNode { // USING T seems to make this line unable to use 'static'
        private IntNode prev;
        private T item;
        private IntNode next;

        public IntNode(IntNode prev, T item, IntNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private IntNode sentF;
    private IntNode sentB;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentF = new IntNode(null, null, null);
        sentB = new IntNode(sentF, null, null);
        sentF.next = sentB;
    }

//    public LinkedListDeque(LinkedListDeque other) {
////        if ((other == null) || (other.sentF.next == other.sentB)) {
////            new LinkedListDeque();
////        }
////        else {
////            this = new LinkedListDeque<>();
//        size = 0;
//        sentF = new IntNode(null, null, null);
//        sentB = new IntNode(sentF, null, null);
//        sentF.next = sentB;
//        if (other.sentF.next != other.sentB) {
//            IntNode ptr  = sentF;
//            while (other.sentF.next.next != null) {
//                ptr.next = new IntNode(ptr,
//                     (T) other.sentF.next.item, null);
//                ptr = ptr.next;
//                other.sentF = other.sentF.next;
//                size += 1;
//            }
//            ptr.next = sentB;
//            sentB.prev = ptr;
//        }
//    }

    public void addFirst(T item) {
        size += 1;
        sentF.next = new IntNode(sentF, item, sentF.next);
        sentF.next.prev = sentF;
        sentF.next.next.prev = sentF.next;
    }

    public void addLast(T item) {
        size += 1;
        sentB.prev.next = new IntNode(sentB.prev, item, sentB);
        sentB.prev = sentB.prev.next;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        size -= 1;
        T item = sentF.next.item;
        sentF.next = sentF.next.next;
        sentF.next.prev = sentF;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size -= 1;
        T item = sentB.prev.item;
        sentB.prev = sentB.prev.prev;
        sentB.prev.next = sentB;
        return item;
    }

    public boolean isEmpty() {
        return size == 0; // EXCELLENT CODE EXPRESSION!!!
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentF.next;
        for (int i = 0; i < size() - 1; i += 1) { //JAVA can use ++
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
        System.out.println();
    }

    public T get(int index) {
        if ((index < 0) || (index > size - 1)) {
            return null;
        }

        IntNode p = sentF.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }

    private IntNode getRecurhelper(IntNode p, int index) {
        if (index == 0) {
            return p;
        }
        return getRecurhelper(p.next, index - 1);
    }
    public T getRecursive(int index) {
        if ((index < 0) || (index > size - 1)) {
            return null;
        }

        IntNode p = sentF.next;
        p = getRecurhelper(p, index);
        return p.item;
    }
}

