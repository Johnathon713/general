package org.john.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author johnathon
 */
public class FindUtil {

    public static List<Integer> binarySearch(int[] arr, int startIndex, int endIndex, int target) {
        System.out.println("hhh");
        int midIndex = startIndex + (endIndex - startIndex) * (target - arr[startIndex]) / (arr[endIndex] - arr[startIndex]);
        if (arr[midIndex] == target) {
            List<Integer> list = new ArrayList<>();
            int tmp = midIndex;
            while (tmp > 0 && arr[tmp - 1] == target) {
                tmp--;
            }
            while (tmp < arr.length && arr[tmp] == target) {
                list.add(tmp);
                tmp++;
            }
            return list;
        }
        if (endIndex < startIndex) {
            return new ArrayList<>();
        }
        if (arr[midIndex] < target) {
            return binarySearch(arr, midIndex + 1, endIndex, target);
        }
        if (arr[midIndex] > target) {
            return binarySearch(arr, startIndex, midIndex - 1, target);
        }
        return new ArrayList<>();
    }

    public static void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> i = binarySearch(arr, 0, arr.length - 1, 10);
        System.out.println(Arrays.toString(i.toArray()));
    }
}
