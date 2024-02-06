public class LinkedListDeque<T> {

    public class IntNode { // USING T seems to make this line unable to use 'static'
        public IntNode prev;
        public T item;
        public IntNode next;

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
//        if ((other == null) || (other.sentF.next == other.sentB)) {
//            new LinkedListDeque();
//        }
//        else {
//            new LinkedListDeque();
//            IntNode ptr  = sentF.next;
//            while (other.sentF.next != null) {
//                ptr = other.sentF.next;
//                ptr = ptr.next;
//                other.sentF = other.sentF.next;
//            }
//            sentB.prev = other.sentF;
//        }
//    }

    public void addFirst(T item) {
        size += 1;
        sentF.next = new IntNode(sentF, item, sentF.next);
        if (size == 1) {
            sentB.prev = sentF.next;
        }
    }

    public void addLast(T item) {
        size += 1;
        sentB.prev.next = new IntNode(sentB.prev, item, sentB);
        sentB.prev = sentB.prev.next;
    }

    public boolean isEmpty() {
        return size == 0; // EXCELLENT CODE EXPRESSION!!!
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentF.next;
        for (int i = 0; i < size() - 1; i ++) { //JAVA can use ++
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
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

    public T get(int index) {
        if ((index < 0) || (index > size - 1)) {
            return null;
        }

        IntNode p = sentF.next;
        for (int i = 0; i < index; i ++) {
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
        if ((index < 0) || (index > size -1)) {
            return null;
        }

        IntNode p = sentF.next;
        p = getRecurhelper(p, index);
        return p.item;

    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(-5);
        L.addLast(8);
        L.addLast(2);
        L.addFirst(3);
//        System.out.println(L.sentF.item);
//        System.out.println(L.sentF.next.item);
//        System.out.println(L.sentF.next.next.item);
        //System.out.println(L.sentF.next.next.next.item);
        L.printDeque();
//        L.removeFirst();
//        L.printDeque();
//        L.removeLast();
//        L.printDeque();
//        System.out.println(L.getRecursive(1));
//        LinkedListDeque<Integer> Copy = new LinkedListDeque<>();
//        Copy = new LinkedListDeque<>(L);
//        Copy.printDeque();

    }




}
