package Chapter2.ElementarySorts_1;

/**
 * The simplest sorting algorithm. We start looking for the smallest element, put it in the first
 * place, then next, and so forth. We also exch() in place, and then start from the second element of
 * the array. 
 * 
 * This algorithm uses ~N^2/2 compares and N exchanges to arrange the array. The algorithm is independent of the 
 * order of the elements in the array.
 * 
 * It is however interesting that the number of array access is linear with this method.
 */
public class SelectionSort_2 {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = 0;
            for (int k = i; k < a.length; k++) {
                if (a[i].compareTo(a[k]) <= 0) j = k;
            }

            exch(a, i, j);
        }
    }
    
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
