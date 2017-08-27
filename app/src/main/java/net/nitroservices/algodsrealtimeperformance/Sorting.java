package net.nitroservices.algodsrealtimeperformance;

/**
 * Created by rezan on 8/26/17.
 */

class Sorting {


    protected static void sortUsingBubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }



    /*
        Step 1 - If it is the first element, it is already sorted. return 1;
        Step 2 - Pick next element
        Step 3 - Compare with all elements in the sorted sub-list
        Step 4 - Shift all the elements in the sorted sub-list that is greater than the value to be sorted
        Step 5 - Insert the value
        Step 6 - Repeat until list is sorted
     */
    protected static void sortUsingInsertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            /*
                Move elements of arr[0..i-1], that are
                greater than key, to one position ahead
                of their current position.
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

}
