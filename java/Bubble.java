package dmx.prolog;

import java.util.Arrays;

public class Bubble {
    public static void bubbleSort(Integer[] arr) {
        // Записуємо довжину масиву в змінну n (для зручності)
        final var n = arr.length;

        for (int i = 0; i < n; i++)
            // Проходимося по масиву зліва направо
            for (int j = 0; j < n - 1; j++)
                // Переставляємо елементи, якщо вони стоять в неправильному порядку
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    // Метод для обміну елементів масиву
    private static void swap(Integer[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        var arr = new Integer[] { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}