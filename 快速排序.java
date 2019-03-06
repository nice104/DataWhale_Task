package p28快速排序_基数排序.exer;

import p28快速排序_基数排序.p02递归实现快排.ArrayIns2;

import java.util.Random;

public class QuikSort {
    private int[] arr;
    public int nElem;

    public QuikSort(int nElem) {
        this.arr = new int[nElem];
        this.nElem = 0;
    }

    public void insert(int val) {
        arr[nElem++] = val;
    }

    public void displayArr() {
        System.out.print("Array : ");
        for (int i = 0; i < nElem; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //递归获取
    public void qs() {
        rec(0, nElem - 1);
    }

    private void rec(int left, int right) {

        //序列长度
        int size = right - left + 1;

        //序列长度<10
        if (size < 10) insertS(left, right);
        else {
            //获取三项的中间元素
            int midVal = midOf3(left, right);
            //将当前的左右边界以中间划分值进行分组,获取新的划分界限的索引,见方法内
            int partition = partitionBy(left, right, midVal);
            rec(left, partition-1);
            rec(partition+1,right);

        }
    }

    private int partitionBy(int left, int right, int midVal) {
        //左边界并非最小值
        int leftBound = left;
        //因为midOf3已经将左中右排好序,所以最右必然比中界值大,这里右界定为right的前一位
        int rightBound = right - 1;
        while (true) {
            //找到比中界值大的左边的元素
            while (arr[++leftBound] < midVal) ;
            //找到比中界值小的右边的元素
            while ( arr[--rightBound] > midVal) ;
            //如果左右的索引位
            if (leftBound >= rightBound) break;
                //将找到的左右值调换,放到其应该的位置
            else swap(leftBound, rightBound);
        }

        //循环完后,leftBound=rightBound+1,这里leftBound在rightBound的右边
        System.out.println("leftBound++rightBound--" + leftBound + " : " +rightBound);
        System.out.println("leftBound1++rightBound1--" + arr[leftBound] + " : " +arr[rightBound]);

        //目的在于不总是让最后一个作为划分的依据,因为只是划分,不是排序,所以换个值不影响划分结果
        swap(leftBound, right-1);
        //交换后,将新的划分的值的索引返回
        return  leftBound;
    }

    private int midOf3(int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) swap(left, center);
        if (arr[left] > arr[right]) swap(left, right);
        if (arr[center] > arr[right]) swap(center, right);

        swap(center, right - 1);
        return arr[right - 1];    //right-1为三项中间值的索引位

    }

    public void swap(int dex1, int dex2) {
        int tmp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = tmp;
    }

    /*
    有问题
     */
    //插入排序
    private void insertS(int left, int right) {
        int in, out;
        for (out = left + 1; out <= right; out++) {
            int tmp = arr[out];
            in = out;
            while (in > left && arr[in-1] >= tmp) { //条件的前后顺序
                arr[in] = arr[in-1];
                in--;
            }
            arr[in] = tmp;
        }
    }

//    private void insertS(int left, int right) {
//        int in,out;
//        for (out = left + 1; out <= right; out ++) {
//            int temp = arr[out];
//            in = out;
//            while (in > left && arr[in -1] >= temp) {
//                arr[in] = arr[in - 1];
//                in--;
//            }
//            arr[in] = temp;
//        }
//    }

    public static void main(String args[]){
        int max = 16;
        QuikSort a = new QuikSort(max);
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            a.insert(r.nextInt(200));
        }
        a.displayArr();
        System.out.println("---------------");

        //分割点,特定值
        a.qs();
        a.displayArr();
    }
}
