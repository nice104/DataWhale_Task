package p25递归实现归并排序.p02Me;

public class MS1 {
    private int[] arr;
    private int nElems;

    public MS1(int nElems) {
        this.arr = new int[nElems];
        this.nElems = 0;
    }

    public void dis() {
        System.out.print("Array : ");
        for (int i = 0 ; i < nElems; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void insert(int i) {
        arr[nElems++] = i;
    }

    public void MergeSorted(){
        int[] workSpace = new int[nElems];
        //将新建的数组传递进去,分治的作业是调整索引,对元素不操作,排序时才对元素操作
        recMerge(workSpace, 0, nElems-1);
    }

    private void recMerge(int[] ws,int low,int high) {
        if(low == high) return;
        else {
            //递归分治
            int mid = (low + high) / 2;
            recMerge(ws, low, mid);
            recMerge(ws, mid + 1, high);
            /*
            调用归并
            1,调用归并排序,注意这里传递后一半的前界
            2,归并时重新计算中界
             */
            merge(ws,low,mid+1,high);
        }

    }

    private void merge(int[] ws, int low, int preMid, int high) {
        int j = 0;
        int mid = preMid -1 ;

        //给本次归并的低界做标记,用于恢复到原数组
        int lowBound = low;
        int n = high - lowBound + 1; //每一个小单元的长度

        while ( low <= mid && preMid <= high) {
            if (arr[low] < arr[preMid]) ws[j++] = arr[low++];
            else ws[j++] = arr[preMid++];
        }

        while (low <= mid) ws[j++] = arr[low++];
        while (preMid <= high) ws[j++] = arr[preMid++];

        //lowBound是当前传进来的参数的低界初始值
        for (j = 0 ; j < n ; j ++) arr[lowBound + j] = ws[j];

    }


    public static void main(String args[]){
        MS1 m = new MS1(100);
        m.insert(13);
        m.insert(15);
        m.insert(14);
        m.insert(18);
        m.insert(16);
        m.dis();
        System.out.println("------------------");
        m.MergeSorted();
        m.dis();
    }
}
