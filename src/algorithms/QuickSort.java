package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static final int RIGHT = 1;
    public static final int LEFT = -1;

    private long start;
    private long end;
    private long executionTime;

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = sort.generateArrayOfIntegersUpTo(10);
        System.out.println(Arrays.toString(array));

        // TODO Not yet implemented

//        int[] sortedArray = sort.myQuickSort(array, 0, array.length - 1);
//
//        System.out.println(Arrays.toString(sortedArray));
//
//        sort.executionTime = sort.end - sort.start;
//        System.out.println("executionTime: " + sort.executionTime);
    }

    public  int[] myQuickSort(int[] array, int left, int right) {
        start = System.nanoTime();
        int lp = left;
        int rp = right;
        int pivot = lp;

        int pointer = RIGHT;

        int keyPivot = array[pivot];
        while (lp < rp) {
            switch(pointer) {
                case LEFT:
                    if (array[lp] < keyPivot) {
                        lp++;
                    } else {
                        array[rp] = array[lp];
                        rp--;
                        pointer = RIGHT;
                    }
                    break;
                case RIGHT:
                    if (array[rp] > keyPivot) {
                        rp--;
                    } else {
                        array[lp] = array[rp];
                        lp++;
                        pointer = LEFT;
                    }
                    break;
            }
        }
        array[lp] = keyPivot;
        if (lp - 1 > left) myQuickSort(array, left, lp - 1);
        if (rp + 1 < right) myQuickSort(array, rp + 1, right);
        end = System.nanoTime();
        return array;
    }

    public int[] generateArrayOfIntegersUpTo(final int length) {
        final Random randomGenerator = new Random();

        int[] res = new int[length];
        for (int i = 0; i < res.length; i++) {
            res[i] = randomGenerator.nextInt(length);
        }
        return res;
    }
}