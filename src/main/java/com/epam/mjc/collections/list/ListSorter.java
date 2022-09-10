package com.epam.mjc.collections.list;

import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {
        ListComparator compare = new ListComparator();
        compare.quickSort(sourceList, 0, sourceList.size() - 1);
    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);

        if (Math.abs(aInt) > Math.abs(bInt))
            return 1;
        else if (aInt == bInt)
            return 0;
        else
            return -1;
    }

    void swap(List<String> arr, int i, int j)
    {
        String temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    int partition(List <String> arr, int low, int high)
    {

        // pivot
        String pivot = arr.get(high);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (compare(arr.get(j), pivot) < 0)
            {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    void quickSort(List <String> arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
