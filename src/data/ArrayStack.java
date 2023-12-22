package data;

public class ArrayStack implements Stack<String> {

    private String[] items;
    private int capacity;
    private int count;

    public ArrayStack(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    @Override
    public boolean push(String item) {
        // 空间不足添加失败
        if (count == capacity) return false;

        items[count] = item;
        count++;
        return true;
    }

    @Override
    public String pop() {
        if (count == 0) return null;
        count--;
        return items[count];
    }

    @Override
    public String peek() {
        if (count == 0) return null;
        return items[count - 1];
    }

}
