package dmx.prolog;

import java.util.Arrays;

public class Main {
    private static void bubbleSort(Integer[] arr) {
        // Записуємо довжину масиву в змінну n (для зручності)
        final var n = arr.length;

        for (int i = 0; i < n; i++)
            // Проходимося по масиву зліва направо, переставляючи елементи, якщо вони стоять в неправильному порядку
            for (int j = 0; j < n - 1; j++)
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
    }

    private static int[] bubbleAddressSort(Integer[] arr) {
        final var n = arr.length;
        final var addr = createAddressArray(n);
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                // Переставляємо адреси елементів, якщо вони стоять в неправильному порядку
                if (arr[addr[j]] > arr[addr[j + 1]])
                    swap(addr, j, j + 1);
        return addr;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        final var array = createArray();
        bubbleSort(array);

        System.out.println("Non-address sort array: ");
        for (int el : array) System.out.println(el);

        final var array2 = createArray();
        final var addr = bubbleAddressSort(array2);

        System.out.println("Address sort array: ");
        for (int j : addr) System.out.println(array2[j]);

        System.out.println("Non-address sort array: " + Arrays.toString(array));
        System.out.println("Address sort array: " + Arrays.toString(array2));
    }

    private static Integer[] createArray() {
        return new Integer[]{64, 34, 25, 12, 22, 11, 90};
    }

    private static int[] createAddressArray(int n) {
        final var addr = new int[n];
        for (int i = 0; i < n; i++) addr[i] = i;
        return addr;
    }
}
