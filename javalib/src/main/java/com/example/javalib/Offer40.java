package com.example.javalib;

/**
 * 首先维护一个k的大顶堆，本题除了用堆排序外。
 * 还可以用快速选择排序，就是利用快排的思想。我们的目的是寻找最小的 k个数。假设经过一次快排操作，枢纽元素位于下标 m，也就是说，
 * 左侧的数组有m个元素，是原数组中最小的m个数。那么就会有三种情况：
 * 若 k =m，我们就找到了最小的 k 个数，就是左侧的数组；
 * 若 k<m，则最小的k个数一定都在左侧数组中，我们只需要对左侧数组递归地快排即可；
 * 若 k>m，则左侧数组中的m个数都属于最小的k个数，我们还需要在右侧数组中寻找最小的 k-m个数，对右侧数组递归地快排即可。
 */
class Offer40 {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3};
        int[] result = new Offer40().getLeastNumbers(arr, 4);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
        }
        buildHeap(heap, arr, k);
        return heap;
    }

    private void buildHeap(int[] heap, int[] arr, int k) {
        for (int i = (heap.length - 2) / 2; i >= 0; i--) {
            adjustHeap(heap, i, heap.length);
        }

        for (int i = k; i < arr.length; i++) {
            if (heap[0] >= arr[i]) {
                heap[0] = arr[i];
                adjustHeap(heap, 0, heap.length);
            }
        }
    }

    private void adjustHeap(int[] heap, int parent, int length) {
        int tmp = heap[parent];
        int child = parent * 2 + 1;
        while (child < length) {
            if (child + 1 < length && heap[child + 1] > heap[child]) {
                child++;
            }
            if (tmp > heap[child]) {
                break;
            }
            heap[parent] = heap[child];
            parent = child;
            child = 2 * child + 1;
        }
        heap[parent] = tmp;
    }

}
