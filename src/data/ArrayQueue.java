package data;

public class ArrayQueue implements Queue<String> {

    private String[] items;
    private int capacity;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
    }

    @Override
    public boolean enqueue(String item) {
        // if (tail == capacity) return false;
        if (tail == capacity) {
            // head为0代表没有元素出队列，队列是满的
            if (head == 0) return false;
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }

            // 搬移完成后更新head和tail
            tail -= head;
            head = 0;
        }
        
        items[tail] = item;
        tail++;
        return true;
    }

    @Override
    public String dequeue() {
        // 头下标 == 尾下表 代表列表为空
        if (head == tail) return null;
        String ret = items[head];
        head++;
        return ret;
    }

}
