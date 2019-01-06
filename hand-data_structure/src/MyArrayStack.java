/**
 * 数组实现的栈
 */
public class MyArrayStack {
    private long[] a;
    //数组大小
    private int size;
    //栈顶
    private int top;

    public MyArrayStack(int maxSize) {
        this.size = maxSize;
        this.a = new long[maxSize];
        //表示栈空
        this.top = -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(long value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        a[++top] = value;
    }

    /**
     * 返回栈顶内容但不删除
     *
     * @return
     */
    public long peek() {
        if (isEmpty()) {
            System.out.println("栈中无数据");
            return 0;
        }
        return a[top];
    }

    /**
     * 弹出栈顶内容并且删除
     *
     * @return
     */
    public long pop() {
        if (isEmpty()) {
            System.out.println("栈中无数据");
            return 0;
        }
        return a[top--];
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        MyArrayStack myArrayStack = new MyArrayStack(10);
        myArrayStack.push(9);
        myArrayStack.push(6);
        myArrayStack.push(5);
        myArrayStack.push(4);
        myArrayStack.display();
//        myArrayStack.peek();
    }
}
