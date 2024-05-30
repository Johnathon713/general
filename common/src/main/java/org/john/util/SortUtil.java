package org.john.util;

import java.util.*;

/**
 * @author johnathon
 * 排序工具类
 * 生成新集合，不改变原集合
 */
public class SortUtil {

    /**
     * 冒泡排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> bubbleSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        for (int i = 0; i < list.size() - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    flag = false;
                }
            }
            if (flag) {
                return list;
            }
        }
        return list;
    }

    /**
     * 选择排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> selectSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        for (int i = 0; i < list.size() - 1; i++) {
            int flag = 0;
            for (int j = 1; j < list.size() - i; j++) {
                if (comparator.compare(list.get(flag), list.get(j)) < 0) {
                    flag = j;
                }
            }
            T temp = list.get(flag);
            list.set(flag, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
        return list;
    }

    /**
     * 插入排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> insertSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        for (int i = 1; i < list.size(); i++) {
            T temp = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(temp, list.get(j)) > 0) {
                    list.set(j + 1, temp);
                    break;
                } else {
                    list.set(j + 1, list.get(j));
                    if (j == 0) {
                        list.set(0, temp);
                        break;
                    }
                }
            }

        }
        return list;
    }

    /**
     * 希尔排序(交换法)
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> shellSortExchange(Collection<T> collection, Comparator<? super T> comparator) {
        T temp;
        List<T> list = new ArrayList<>(collection);
        for (int gap = list.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < list.size(); i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (comparator.compare(list.get(j), list.get(j + gap)) > 0) {
                        temp = list.get(j);
                        list.set(j, list.get(j + gap));
                        list.set(j + gap, temp);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 希尔排序(移动法)
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> shellSortMove(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        for (int gap = list.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < list.size(); i++) {
                T temp = list.get(i);
                int j = i;
                while (j - gap >= 0 && comparator.compare(temp, list.get(j - gap)) < 0) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }
                list.set(j, temp);
            }
        }
        return list;
    }

    /**
     * 快速排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> quickSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        quickSortItem(list, 0, list.size() - 1, comparator);
        return list;
    }

    /**
     * 快速排序的核心逻辑
     */
    private static <T> void quickSortItem(List<T> list, int startIndex, int endIndex, Comparator<? super T> comparator) {
        int leftIndex = startIndex, rightIndex = endIndex;
        T temp = list.get(leftIndex);
        boolean leftEmpty = true;
        while (leftIndex < rightIndex) {
            if (leftEmpty) {
                if (comparator.compare(list.get(rightIndex), temp) < 0) {
                    list.set(leftIndex, list.get(rightIndex));
                    leftIndex++;
                    leftEmpty = false;
                } else {
                    rightIndex--;
                }
            } else {
                if (comparator.compare(list.get(leftIndex), temp) > 0) {
                    list.set(rightIndex, list.get(leftIndex));
                    rightIndex--;
                    leftEmpty = true;
                } else {
                    leftIndex++;
                }
            }
        }
        list.set(leftIndex, temp);

        if (leftIndex - 1 > startIndex) {
            quickSortItem(list, startIndex, leftIndex - 1, comparator);
        }
        if (rightIndex + 1 < endIndex) {
            quickSortItem(list, rightIndex + 1, endIndex, comparator);
        }
    }

    /**
     * 归并排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> mergeSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        mergeSortItem(list, 0, list.size() - 1, comparator);
        return list;
    }

    /**
     * 归并排序的核心逻辑(拆分)
     */
    private static <T> void mergeSortItem(List<T> list, int startIndex, int endIndex, Comparator<? super T> comparator) {
        if (endIndex > startIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSortItem(list, startIndex, midIndex, comparator);
            mergeSortItem(list, midIndex + 1, endIndex, comparator);
            doMerge(list, startIndex, endIndex, comparator);
        }
    }

    /**
     * 归并排序的核心逻辑(合并)
     */
    private static <T> void doMerge(List<T> list, int startIndex, int endIndex, Comparator<? super T> comparator) {
        int cursor1 = startIndex, midIndex = (startIndex + endIndex) / 2, cursor2 = midIndex + 1;
        List<T> tempList = new ArrayList<>(endIndex - startIndex + 1);
        while (cursor1 <= midIndex && cursor2 <= endIndex) {
            if (comparator.compare(list.get(cursor1), list.get(cursor2)) <= 0) {
                tempList.add(list.get(cursor1));
                cursor1++;
            } else {
                tempList.add(list.get(cursor2));
                cursor2++;
            }
        }
        while (cursor1 <= midIndex) {
            tempList.add(list.get(cursor1));
            cursor1++;
        }
        while (cursor2 <= endIndex) {
            tempList.add(list.get(cursor2));
            cursor2++;
        }
        for (int i = 0; i < tempList.size(); i++) {
            list.set(startIndex + i, tempList.get(i));
        }
    }

    /**
     * 基数排序
     *
     * @param collection 要排序的集合
     * @return 排序后的集合
     */
    public static List<Long> radixSort(Collection<Long> collection) {
        List<Long> list = new ArrayList<>(collection);
        if (list.isEmpty()) {
            return list;
        }
        List<Queue<Long>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayDeque<>(list.size() / 5));
        }
        long places = 1L;
        long max = list.getFirst();
        for (Long l : list) {
            if (l > max) {
                max = l;
            }
        }
        while (max > places) {
            long l1 = System.currentTimeMillis();
            for (Long l : list) {
                int tmp = (int) (l / places % 10L);
                buckets.get(tmp).add(l);
            }
            list = new ArrayList<>();
            for (Queue<Long> bucket : buckets) {
                while (bucket.peek() != null) {
                    list.add(bucket.poll());
                }
            }
            places *= 10L;
        }

        return list;
    }

    /**
     * 堆排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> heapSort(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        T temp;
        long count = 0;
        for (int lastNodeIndex = list.size() - 1; lastNodeIndex > 0; lastNodeIndex--) {
            count++;
            for (int cursor = (lastNodeIndex - 1) / 2; cursor >= 0; cursor--) {
                if (cursor * 2 < lastNodeIndex) {
                    int maxChildNodeIndex = cursor * 2 + 1;
                    if (maxChildNodeIndex < lastNodeIndex && comparator.compare(list.get(maxChildNodeIndex + 1), list.get(maxChildNodeIndex)) > 0) {
                        maxChildNodeIndex++;
                    }
                    if (comparator.compare(list.get(maxChildNodeIndex), list.get(cursor)) > 0) {
                        temp = list.get(maxChildNodeIndex);
                        list.set(maxChildNodeIndex, list.get(cursor));
                        list.set(cursor, temp);
                    }
                }
            }
            temp = list.getFirst();
            list.set(0, list.get(lastNodeIndex));
            list.set(lastNodeIndex, temp);
        }
        System.out.println("@@@" + count);
        return list;
    }

    /**
     * 堆排序
     *
     * @param collection 要排序的集合
     * @param comparator 比较器
     * @param <T>        泛型
     * @return 排序后的集合
     */
    public static <T> List<T> heapSort2(Collection<T> collection, Comparator<? super T> comparator) {
        List<T> list = new ArrayList<>(collection);
        for (int i = 0; i < list.size(); i++) {

        }
        return list;
    }

    private static <T> void adjustHeap(List<T> a, int index, Comparator<? super T> comparator) {

    }

    private static <T> void adjustHeap(List<T> list, int rootIndex, int lastNodeIndex, Comparator<? super T> comparator) {
        int maxChildNodeIndex = rootIndex * 2 + 1;
        if (maxChildNodeIndex + 1 <= lastNodeIndex && comparator.compare(list.get(maxChildNodeIndex + 1), list.get(maxChildNodeIndex)) > 0) {
            maxChildNodeIndex++;
        }
        if (comparator.compare(list.get(maxChildNodeIndex), list.get(rootIndex)) > 0) {
            T temp = list.get(maxChildNodeIndex);
            list.set(maxChildNodeIndex, list.get(rootIndex));
            list.set(rootIndex, temp);
            if (maxChildNodeIndex <= (lastNodeIndex - 1) / 2) {
                adjustHeap(list, maxChildNodeIndex, lastNodeIndex, comparator);
            }
        }
    }


    /**
     * 测试方法
     */
    public static void test() {
        List<Long> list = new ArrayList<>(8000000);
        for (int i = 0; i < 10000; i++) {
            list.add((long) (Math.random() * 1000000));
        }
        System.out.println(Arrays.toString(list.subList(0, 5).toArray()));
        long l = System.currentTimeMillis();
        List<Long> longs = heapSort(list, Comparator.comparingLong(Long::longValue));
//        List<Long> longs = CollUtil.sort(list, Comparator.comparingLong(Long::longValue));
//        List<Long> longs = radixSort(list);
        System.out.println(System.currentTimeMillis() - l + "ms");
        for (int i = 0; i < longs.size() - 1; i++) {
            if (longs.get(i) > longs.get(i + 1)) {
                System.out.println("错误!");
            }
        }
        System.out.println(Arrays.toString(longs.subList(0, 5).toArray()));
    }

}
