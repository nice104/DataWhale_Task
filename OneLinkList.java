package Datawhale.Q0226;

public class OneLinkList {
    public static void main(String[] args) {

        LinkList_1 list = new LinkList_1();
        list.insertFirst(22, 2.3);
        list.insertFirst(23, 2.5);
        list.insertFirst(25, 2.7);
        list.insertFirst(24, 2.1);
        list.insertFirst(26, 2.0);
        list.insertFirst(21, 2.2);

        list.displayList();

        while (!list.isEmpty()) {
            Node alink = list.deleteFirst();
            System.out.println("Delete ");
            alink.display();
            System.out.println();
        }
        list.displayList();
    }
}


class LinkList_1 {
    private Node first;

    public LinkList_1() {
        first = null;
    }

    /**
     * insert
     *
     * @param id
     * @param dd
     */
    public void insertFirst(int id, double dd) {
        Node nl = new Node(id, dd);    //创建新的链节点
        nl.next = first;
        first = nl;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first->last):");
        Node cu = first;
        while (cu != null) {
            cu.display();
            cu = cu.next;
        }
        System.out.println();
    }

    public Node find(int key) {
        Node cu = first;
        while (cu.a != key) {
            if (cu.next == null) {
                return null;
            } else {
                cu = cu.next;
            }
        }
        return cu;
    }

    public Node delete(int key) {
        Node cu = first;
        Node pre = first;
        while (cu.a != key) {
            if (cu.next == null) {
                return null; //找到结尾
            } else {
                pre = cu;
                cu = cu.next;
            }
        }

        if (cu == first) {
            first = first.next;
        } else {
            pre.next = cu.next;
        }
        return cu;
    }


}


class Node {
    public int a;
    public double b;
    public Node next;

    public Node(int id, double dd) {
        a = id;
        b = dd;
    }

    //链节点
    public void display() {
        System.out.println("{" + a + "," + b + "} ");
    }

}
