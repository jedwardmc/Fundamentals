import java.util.*;

public class SortingAlgorithm{
    
    public static void main(String []args){
        int[] numElements = new int[1000];
        
        Random rnd = new Random(2017);
        for(int i=0;i<1000;i++)
        {
            numElements[i] = rnd.nextInt();
        }
        
        
        long startTime = System.currentTimeMillis();
        
        bubbleSort(numElements);
        
        quickSort(numElements, 0, 999);
        
        insertionSort(numElements);
        
        mergeSort(numElements, 0, 999);
        
        selectionSort(numElements);
        
        long endTime = System.currentTimeMillis();
        
        long runningTime = endTime - startTime;
        
        System.out.println("Running time " + runningTime + " ms");
        
        

        
    }
    
    public static void bubbleSort(int[] array) {
        int j;
        boolean flag = true;
        int temp;
        
        while(flag) {
            flag = false;
            
            for(j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    
    public static void insertionSort(int[] array) {
        int i, j, n = array.length;
        int target;
        
        // place array[i] into the sublist array[0]...
        // so it is in the correct position
        
        for (i = 1; i < n; i++) {
            // index j scans down list from array[i]
            // correct position to locate target
            j = i;
            // assigns it to array[j]
            target = array[j];
            // locate insertion point by scanning downward as long as target < array[j-1]
            // and we have not encountered the beginning of the list
            
            while(j > 0 && target < array[j -1]) {
                // shift elements up to make room for insertion
                array[j] = array[j-1];
                j--;
            }
        }
        
    }
    
    private static void quickSort(int[] array, int fromIndex, int toIndex) {
        int i = fromIndex;
        int j = toIndex;
        
        int pivot = array[fromIndex + (toIndex - fromIndex) / 2];
        
        while(i <= j) {
            while (array[i] < pivot) { i++; }
            while (array[j] > pivot) { j--; }
            
            if(i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // move index to next position on both sides
                i++;
                j--;
            }
        }
        if(fromIndex < j) {
            quickSort(array, fromIndex, j);
        }
        
        if(i < toIndex) {
            quickSort(array, i, toIndex);
        }
        
        
    }
    
    private static void mergeSort(int[] array, int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
            // sort the left side of the array
            mergeSort(array, fromIndex, middleIndex);
            // sort the right side of the array
            mergeSort(array, middleIndex + 1, toIndex);
            // merge both sides
            mergeSides(array, fromIndex, middleIndex, toIndex);
        }

    }
    
    private static void mergeSides(int[] array, int fromIndex, int middleIndex, int toIndex) {
        int[] tmp = new int[array.length];
        
        for (int i = fromIndex; i <= toIndex; i++) {
            tmp[i] = array[i];
        }
        
        int i = fromIndex;
        int j = middleIndex + 1;
        int k = fromIndex;
        
        while (i <= middleIndex && j <= toIndex) {
            if (tmp[i] <= tmp[j]) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[j];
                j++;
            }
            k++;
        }
        
        while (i <= middleIndex) {
            array[k] = tmp[i];
            k++;
            i++;
            
        }
        
    }
    
    public static void selectionSort(int[] array) {
        int minIndex; // index of smallest item in each pass
        int pass, j, n = array.length;
        int temp;
        
        for (pass = 0; pass < n-1; pass++) {
            // scan from index pass; set minIndex to pass
            minIndex = pass;
            // j scans the sublist array[pass + 1]...array[n-1]
            
            for(j = pass+1; j < n; j++) {
                // update minIndex if smaller element found
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
        
        // place smallest item in array[pass]
        
        if (minIndex != pass) {
            temp = array[pass];
            array[pass] = array[minIndex];
            array[minIndex] = temp;
        }
        
    }
    
}
}

