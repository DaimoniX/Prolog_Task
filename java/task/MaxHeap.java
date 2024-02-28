package dmx.prolog;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class MaxHeap {
    // Масив для зберігання значень
    private final int[] heap;

    // Конструктор
    public MaxHeap(int size) {
        heap = new int[size];
    }

    public static void main(String[] args) {
        final var heap = new MaxHeap(10);
        for (var el : new Integer[]{64, 34, 25, 12, 22, 11, 90})
            heap.insert(el);
        System.out.println("Heap: " + Arrays.toString(heap.getHeap()));
        while (heap.getMax() != 0)
            System.out.println("Max: " + heap.extractMax() + " Heap: " + Arrays.toString(heap.getHeap()));
    }

    public void insert(int value) {
        // Якщо корінь порожній, вставляємо значення
        if (heap[0] == 0) {
            heap[0] = value;
            return;
        }

        // Знаходимо перший вільний елемент
        int i = 0;
        while (heap[i] != 0) {
            i++;
        }

        heap[i] = value;
        int parent = (i - 1) / 2;
        // Відновлюємо властивості купи
        while (i > 0 && heap[i] > heap[parent]) {
            // Переставляємо значення
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    // Отримуємо максимальне значення (корінь)
    public int getMax() {
        return heap[0];
    }

    // Метод для вилучення максимального значення
    public int extractMax() {
        int max = heap[0];
        // Знаходимо останній елемент
        int i = 0;
        while (heap[i] != 0) {
            i++;
        }

        // Замінюємо корінь на останній елемент
        heap[0] = heap[i - 1];
        // Прибираємо останній елемент
        heap[i - 1] = 0;
        i = 0;

        // Відновлюємо властивості купи
        while (i < heap.length) {
            // Отримуємо лівого та правого нащадка
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            // Якщо лівий та правий нащадок існують
            if (left < heap.length && right < heap.length) {
                // Якщо корінь менший за лівого або правого нащадка
                if (heap[i] < heap[left] || heap[i] < heap[right]) {
                    // Переставляємо корінь з більшим нащадком
                    if (heap[left] > heap[right]) {
                        int temp = heap[i];
                        heap[i] = heap[left];
                        heap[left] = temp;
                        i = left;
                    } else {
                        int temp = heap[i];
                        heap[i] = heap[right];
                        heap[right] = temp;
                        i = right;
                    }
                } else {
                    break;
                }
            } else if (left < heap.length) {
                // Якщо лівий нащадок існує
                if (heap[i] < heap[left]) {
                    // Переставляємо корінь з лівим нащадком
                    int temp = heap[i];
                    heap[i] = heap[left];
                    heap[left] = temp;
                    i = left;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        // Повертаємо максимальне значення
        return max;
    }
}
