package p06BubbleSort.p01ArrayBub;

package p06BubbleSort.p01ArrayBub;

public class D02Bubble_test {
    public static void main(String[] args) {
        int max = 100;
        D01Bubble arr = new D01Bubble(max);

        arr.insert(13);
        arr.insert(17);
        arr.insert(15);
        arr.insert(14);
        arr.insert(18);
        arr.insert(12);
        arr.insert(19);
        arr.insert(11);

        arr.display();  //未排序前的状态
        System.out.println("----------------");

        arr.BubSort();
        arr.display();
    }
}


public class D01Bubble {
    private long[] a;
    private int nElems;
    public D01Bubble(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long v) {
        a[nElems] = v;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //冒泡排序
    public void BubSort() {
        int out,in;
        for (out = nElems-1; out >= 1; out--) {
            for (in = 0; in < out; in++ ) {
                if (a[in]>a[in+1] ) {
                    swap(in, in + 1);
                }
            }
        }
    }

    //交换方法
    public void swap(int one,int two) {
        long temp = a[one];      //容器
        a[one] = a[two];
        a[two] = temp;
    }
}
