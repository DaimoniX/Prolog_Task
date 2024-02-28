package dmx.prolog;

import java.util.Comparator;

// Однозв'язний список
public class SingleLinkedList<T> {
    private SNode<T> head;

    // Додавання елемента в кінець списку
    public void add(T data) {
        var newNode = new SNode<>(data);

        // Якщо список порожній, то новий елемент стає головним
        if (head == null) {
            head = newNode;
            return;
        }

        var current = head;
        // Якщо список не порожній, то знаходимо останній елемент
        while (current.next != null)
            current = current.next;

        // І додаємо новий елемент
        current.next = newNode;
    }

    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null)
            return;

        // Вказівники для сортування
        SNode<T> current = head;
        SNode<T> index;
        T temp;

        // Сортування бульбашкою для однозв'язного списку
        // Зовнішній цикл пройде по всім елементам списку
        while (current != null) {
            index = current.next;

            // Внутрішній цикл пройде по всім елементам, які знаходяться після поточного
            while (index != null) {
                // Якщо поточний елемент більший за наступний, то міняємо їх місцями
                if (comparator.compare(current.data, index.data) > 0) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }

                // Переходимо до наступного елемента у внутрішньому циклі
                index = index.next;
            }

            // Переходимо до наступного елемента у зовнішньому циклі
            current = current.next;
        }
    }

    // Перетворення списку в рядок для виведення на екран
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
        final var list = new SingleLinkedList<Integer>();
        for (var el : new Integer[]{64, 34, 25, 12, 22, 11, 90})
            list.add(el);

        System.out.println("Before sorting: " + list);

        list.sort(Comparator.naturalOrder());

        System.out.println("After sorting: " + list);
    }
}