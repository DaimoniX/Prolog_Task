package dmx.prolog;

import java.util.Comparator;

// Двозв'язний список
public class DoubleLinkedList<T> {
    private DNode<T> head;

    public void add(T data) {
        var newNode = new DNode<>(data);
        if (head == null) {
            head = newNode;
            return;
        }

        var current = head;
        while (current.next != null)
            current = current.next;
        
        // Аналогічно однозв'язному списку, але тепер потрібно додати посилання на попередній елемент
        current.next = newNode;
        newNode.prev = current;
    }

    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null)
            return;

        DNode<T> current = head;
        DNode<T> index;
        T temp;

        // Сортування бульбашкою для двозв'язного списку (аналогічно однозв'язному)
        while (current != null) {
            index = current.next;

            while (index != null) {
                if (comparator.compare(current.data, index.data) > 0) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        var current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        final var list = new DoubleLinkedList<Integer>();
        for (var el : new Integer[]{64, 34, 25, 12, 22, 11, 90})
            list.add(el);

        System.out.println("Before sorting: " + list);

        list.sort(Comparator.naturalOrder());

        System.out.println("After sorting: " + list);
    }
}
