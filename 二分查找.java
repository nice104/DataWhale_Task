package p03BinarySearch.p01;

/**
 * 1,二分查找的前提是有序数据
 */
public class D01OrderedArray {
    private long[] a;
    private int nElems;     //数据元素个数,最大索引

    //构造函数
    public D01OrderedArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    //查看大小,元素个数
    public int size() {
        return nElems;
    }

    //添加,线性查找添加
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value) break;     //找到value的应放置的索引位j
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];  //数据往后移,空出这个要插入的位置
        a[j] = value;
        nElems++;
    }

    //删除数据,
    public boolean del(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    //显示数据项
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    //二分查找,返回索引
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curInt;
        while (true) {
            curInt = (lowerBound + upperBound) / 2;
            if (a[curInt] == searchKey) {
                return curInt;
            } else if (lowerBound > upperBound)   //没有找到
            {
                return nElems;  //返回大于最大索引的数字
            } else {
                //继续查找
                if (a[curInt] < searchKey)  //往后找
                {
                    lowerBound = curInt + 1;    //改变最小索引
                } else //往前查
                {
                    upperBound = curInt - 1;
                }
            }
        }
    }
}

package p03BinarySearch.p01;

public class D01OrderedArray_test {
    public static void main(String[] args) {
        int maxSize = 100;
        D01OrderedArray arr = new D01OrderedArray(maxSize);

        arr.insert(88);
        arr.insert(12);
        arr.insert(23);
        arr.insert(32);
        arr.insert(42);
        arr.insert(52);
        arr.insert(25);
        arr.insert(78);
        arr.insert(98);
        arr.insert(65);

        int searchKey = 78;
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("找到了.." + searchKey);
        } else {
            System.out.println("没找到");
        }

        arr.display();

        arr.del(12);
        arr.del(32);
        arr.del(98);

        System.out.println("----------------------");
        arr.display();

    }
}
