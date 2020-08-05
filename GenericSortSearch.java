public class GenericSortSearch {
    
    public static void main(String []args) {
        B arr = {2,7,3,8,4};
        selectionSort(arr);
        B target = 7;
        B x = binarySearch(arr, 0, arr.length, target);
        
        if(x == arr.length) {
            System.out.println(target + "not found");
        } else {
            System.out.println(target + " found at index " + x);
        }
    }
    
    public static void selectionSort(B array) {
        int minIndex; // index of smallest item in each pass
        int pass, j, n = array.length;
        int temp;
        
        // sort array[0]..array[n-2] and array[n-1] is in place
        for (pass = 0; pass < n-1; pass++) {
            // scan from index pass; set minIndex to pass
            minIndex = pass;
            // j scans the sublist array[pass+1]...array[n-1]
            for (j = pass + 1; j < n; j++) {
                // update minIndex if smaller element found
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
                
            }
            
            // place smallest item in array[pass]
            if(minIndex != pass) {
                temp = array[pass];
                array[pass] = array[minIndex];
                array[minIndex] = temp;
            }
            
        }
    }
    
    public static <B extends Comparable<B>> B binarySearch(int[] arr, B first, B last, int target) {
        int mid; //index of the midpoint
        int midvalue; // object that is assigned arr[mid]
        int origLast = last; // save original value of last
        
        while (first < last) {
            // test for non-empty sublist
            mid = (first + last)/2;
            midvalue = arr[mid];
            
            if(target == midvalue) {
                return mid; // have a match
            } else if (target < midvalue) {
                last = mid; // search lower sublist. Reset last
            } else {
                first = mid+1; // search upper sublist. Reset first
            }
            
        }
        return origLast; // target not found
    }
}