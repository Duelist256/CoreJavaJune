package day170811.classwork;

import java.util.Arrays;

public class SortExample {

    public static void main(String[] args) {
        int[] a = {10, 20, 0, 20, 12, -9, 100};

        int index = find(a, 8);

        System.out.println(index);
        System.out.println(find(a, 20));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static int find(int[] array, int e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }
}
