package Datawhale.Q0228;

import java.io.Serializable;
import java.util.Arrays;

public class SequenceQueue<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int DEFAULT_SIZE = 10;
    private int capacity; // 保存数组的长度
    private Object[] elementData;// 定义一个数组用于保存顺序队列的元素
    private int fornt = 0;// 队列头
    private int rear = 0;// 队列尾

    // 无参数构造，以默认参数创建空顺序队列
    public SequenceQueue() {
        capacity = DEFAULT_SIZE;
        elementData = new Object[capacity];
    }

    // 有参构造，以一个初始化元素来创建顺序队列
    public SequenceQueue(T element) {
        this();// 调用午餐构造器
        elementData[0] = element;
        rear++;
    }

    // 有参构造，指定队列大小构造空顺序队列
    public SequenceQueue(int initSize) {
        elementData = new Object[initSize];
    }

    /**
     * 以指定长度的数组来创建顺序队列
     *
     * @param element  指定顺序队列中第一个元素
     * @param initSize 指定顺序队列底层数组的长度
     */
    public SequenceQueue(T element, int initSize) {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }

    /**
     * @return
     * @Title: size
     * @Description: 获取顺序队列大小
     */
    public int size() {
        return rear - fornt;
    }

    public void offer(T element) {
        ensureCapacity(rear + 1);
        elementData[rear++] = element;
    }

    /**
     * @param minCapacity
     * @Description: 确认数组的长度是否满足新元素的添加，不满足时扩充数组
     */
    public void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
                // 复制指定的数组，截取或用 null 填充（如有必要），以使副本具有指定的长度。
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
        }
    }

    /**
     * @return
     * @Description: 出队
     */

    public T poll() {
        if (isempty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        // 保留队列的fornt端的元素值
        T oldvalue = (T) elementData[fornt];
        // 释放队列的fornt端的元素
        elementData[fornt++] = null;
        return oldvalue;
    }

    /**
     * @return
     * @Description: 判断队列是否为空
     */
    private boolean isempty() {
        return fornt == rear;
    }

    /**
     * @return
     * @Description: 返回队列顶元素，但不删除队列顶元素
     */
    public T peek() {
        if (isempty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[fornt];
    }

    /**
     * @return
     * @Title: clear
     * @Description: 清空顺序队列
     */
    public void clear() {
        // 将指定的null值分配给指定数组指定范围中的每个元素
        Arrays.fill(elementData, null);
        fornt = 0;
        rear = 0;
    }

    public String toString() {
        if (isempty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (int i = fornt; i < rear; i++) {
                sb.append(elementData[i].toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        SequenceQueue<String> sq = new SequenceQueue<String>();
        sq.offer("1");
        sq.offer("2");
        sq.offer("3");
        System.out.println(sq.toString());
    }
}