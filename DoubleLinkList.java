package Datawhale.Q0226;

public class DoubleLinkList {
    public static void main(String[] args) {
        DLL d = new DLL();
        d.insertFirst(11);
        d.insertFirst(15);
        d.insertFirst(13);
        d.disFor();
        System.out.println("----------------");
        d.insertLast(24);
        d.insertLast(21);
        d.insertLast(22);
        d.disFor();
        d.disBack();
        System.out.println("----------------");

        d.insertAfter(21, 31);
        d.disBack();
    }
}


class DLL {
    private Link first;
    private Link last;

    public DLL() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //插第一个
    public void insertFirst(int a) {
        Link nl = new Link(a);
        if (isEmpty()) last = nl;
        else {
            //让first的前一个和当前的后一个打通
            first.previous = nl;
            nl.next = first;
            nl.previous = null;
        }
        first = nl;
    }

    //插入最后
    public void insertLast(int a) {
        Link l = new Link(a);
        if (isEmpty()) first = l;
        else {
            //要让last的后一个与当前的前一个打通
            last.next = l;
            l.previous = last;
            l.next = null;
        }
        last = l;
    }

    //删除第一个
    public Link deleteFirst() {
        Link t = first;
        if (isEmpty()) {
            System.out.println("no elem");
            return null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        return t;
    }

    //删除最后一个
    public Link deleteLast() {
        return null;
    }

    //插入指定的后面
    public void insertAfter(int key, int data) {
        if(isEmpty()){
            System.out.println("no elem");
            return;
        }
        Link cur = first;
        while (cur.data != key && cur != null) {
            cur = cur.next;
        }
        if(cur == null) {
            System.out.println("no such key : " + key );
            return;
        }
        System.out.println("cur.data : " + cur.data);
        Link nl = new Link(data);
        /*
        设定后一个元素与新元素的关系
         */
        //新的的next=当前的后一个
        nl.next = cur.next;
        //当前的后一个的前一个=新的
        cur.next.previous = nl;
        /*
        设定当前元素与新元素的关系
         */
        //当前的后一个=新的
        cur.next = nl;
        //新的前一个=当前
        nl.previous = cur;
    }

    //删除指定项
    public Link deleteKey(int key) {
        return null;
    }

    public void disFor() {
        System.out.print("forward : ");
        Link c = first;
        while (c != null) {
            c.displayLink();
            c = c.next;
        }
        System.out.println();
    }

    public void disBack() {
        System.out.print("Backward : ");
        Link c = last;
        while (c != null) {
            c.displayLink();
            c = c.previous;
        }
        System.out.println();
    }
}


class Link {
    public int data;
    public Link next;
    public Link previous;

    public Link(int dData) {
        this.data = dData;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
