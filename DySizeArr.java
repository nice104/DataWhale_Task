package Datawhale.Q0226;


/**
 * 实现动态扩容,即调用方法可以给数组扩容
 */
public class DySizeArr {
    static int[] array = new int[20];

    public static void main(String[] args) {

        array = addSize(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            System.out.println(array[i]);
        }
    }

    public static int[] addSize(int[] array) {
        int[] newArray = new int[array.length * 2];
        //将array数组从0位置至array.length位置，复制到newArray数组0位置到array.length位置。
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}


