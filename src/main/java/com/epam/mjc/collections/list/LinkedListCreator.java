package com.epam.mjc.collections.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListCreator {
    public LinkedList<Integer> createLinkedList(List<Integer> sourceList) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int number : sourceList) {
            if (number % 2 == 0)
                nums.addLast(number);
            else
                nums.addFirst(number);
        }

        return nums;
    }
}
