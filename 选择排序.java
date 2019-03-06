package p07SelectionSort.me;

public class SelectSort {
    public static Comparable[] SSort(Comparable[] arr) {
        int size = arr.length;

        int in, out, min;
        for (out = 0; out < size; out++) {
            //给最小值一个索引位
            min = out;
            //获取min的实际索引位
            for (in = out + 1; in < size; in++) {
                if (arr[min].compareTo(arr[in]) > 0) min = in;
            }
            //交换位置
//            swap(arr[out], arr[min]);
            swap(arr, min, out);
        }

        return arr;
    }

    /*并没有调换数组中的索引位的对应值,只是无意义的调换位置*/
//    private static void swap(Comparable a, Comparable b) {
//        Comparable t;
//        t = a;
//        a = b;
//        b = t;
//    }
    private static void swap(Comparable[] arr, int a,int b) {

        Comparable t;
        t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

    }


}

package p07SelectionSort.me;

public class SelectSort_test {
    public static void main(String[] args) {
        //int[] a = new int[]{2,6,4,7,3,1,8};
        String[] a  = new String[]{"a","o","e","h","l","c","p"};
        Comparable[] sort = SelectSort.SSort(a);

        for (Comparable c : sort) {
            System.out.print(c + " ");

        }
    }

}
