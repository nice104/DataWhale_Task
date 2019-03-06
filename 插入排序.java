package p08InsertSort.me;

public class IS {
    public static int[] InsertSort(int[] arr) {
        int in,out,min,size;
        size = arr.length;

        for (out = 1; out < size; out++) {
            min = arr[out];

//            while (in > 0 && arr[in -1] >= min) {
//                arr[in] = arr[in -1];
//                in --;
//            }

            for(in = out;in > 0 && arr[in-1] >= min; in --){
                arr[in] = arr[in -1];
            }
            arr[in] = min;
        }
        return arr;
    }
}

package p08InsertSort.me;

public class IS_test {
    public static void main(String[] args) {
        int[] a = new int[]{3,5,1,4,7,6};
        int[] arr = IS.InsertSort(a);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
