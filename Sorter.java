package proj3;

import java.util.ArrayList;

public class Sorter {
    //implements quicksort algorithm

    // use the UML class diagram and the quicksort lecture notes.
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        Student pivot = pList.get(pFromIdx); //choose the first element of the list to be the pivot
        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;
        while (leftIndex < rightIndex) { //keep partitioning until the indexes cross
            leftIndex++; //move leftIndex rightward until an element that is greater than or equal to the pivot is reached
            while (pList.get(leftIndex).compareTo(pivot) <= 0) {
                leftIndex++;
            }
            rightIndex--;
            //these increments/decrements may be accidentally doubled up,
            while (pList.get(rightIndex).compareTo(pivot) >= 0) { //Move rightIndex leftward until an element that is less than or equal to pivot is reached.
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            } //leftIndex < rightIndex Then: swap(list, leftIndex, rightIndex)
        }
        return rightIndex;
    }

    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx >= pToIdx) {
        } else {
            int partitionIndex = partition(pList, pFromIdx, pToIdx);
            quickSort(pList, pFromIdx, partitionIndex);
            quickSort(pList, partitionIndex + 1, pToIdx);
        }
    }

    public static void sort(ArrayList<Student> pList) {
        quickSort(pList, 0, pList.size() - 1); //public method to call quicksort to sort the list.
    }

    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
    }

}
