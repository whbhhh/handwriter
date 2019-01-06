/**
 * 队列
 */
public class MyQueue {
    private long[] a;
    //数组大小
    private int size;
    //实际存储量
    private int nItems;
    //头
    private int front;
    //尾
    private int rear;

    public MyQueue(int maxSize) {
        this.size = maxSize;
        a = new long[maxSize];
        nItems = 0;
        front = 0;
        rear = -1;
    }

    public void insert(long value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear = ++rear % size;
        a[rear] = value;
        nItems++;
    }

    public boolean isFull() {
        return nItems == size;
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        nItems--;
        front = front % size;
        return a[front++];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        int item = front;
        for (int i = 0; i < nItems; i++) {
            System.out.println(a[item++ % size] + " ");
        }
        System.out.println("");
    }

    public long peek() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        return a[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public int size() {
        return nItems;
    }
}
