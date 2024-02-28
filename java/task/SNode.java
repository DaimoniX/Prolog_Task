package dmx.prolog;

// Вузол однозв'язного списку
public class SNode<T> {
    public T data;
    public SNode<T> next;

    public SNode(T data) {
        this.data = data;
        this.next = null;
    }
}
