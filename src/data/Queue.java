package data;

public interface Queue<T> {
    boolean enqueue(T item);
    T dequeue();
}
