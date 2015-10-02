package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

    public static void main(final String... args) {
        final Random generator = new Random();
        final MergeSort merge = new MergeSort();
        final int[] array = new int[10];

        for (int i = 0, size = array.length; i < size; i++) {
            array[i] = generator.nextInt(100);
        }

        System.out.println(Arrays.toString(array));
        merge.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array) {
        int[] leftHalf = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] rightHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
        if (array.length > 1) {
            sort(leftHalf);
            sort(rightHalf);
            myMerge(leftHalf, rightHalf, array);
        }
    }

    private void myMerge(int[] leftArray, int[] rightArray, int[] array) {
        int pL = 0;
        int pR = 0;
        int index = 0;

        for (;;) {
            if (pR >= rightArray.length) {
                //copy the rest of leftArray into 'array'
                for (int i = pL; i < leftArray.length; i++) {
                    array[index] = leftArray[i];
                    index++;
                }
                break;
            }
            if (pL >= leftArray.length) {
                //copy the rest of rightArray into 'array'
                for (int i = pR; i < rightArray.length; i++) {
                    array[index] = rightArray[i];
                    index++;
                }
                break;
            }
            if (leftArray[pL] < rightArray[pR]) { //element pointed by pL is smaller
                array[index] = leftArray[pL];
                index++;
                pL++;
            } else {
                array[index] = rightArray[pR];
                index++;
                pR++;
            }
        }
    }
}