class Solution {
    public int[] sortArray(int[] nums) {
        int beg = 0;
        int end = nums.length - 1;

        mergeSort (nums, beg, end);

        return nums;
    }

    public void mergeSort(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            partition(arr, beg, mid, end);
        }
    }


    public void partition (int[] arr, int beg, int mid, int end) {
        int[] temp = new int[arr.length];

        int i = beg;
        int j = mid + 1;
        int index = 0;

        while ((i <= mid) && (j <= end)) {
            if (arr[i] > arr[j]) {
                temp[index] = arr[j];
                j++;
            } else {
                temp[index]  = arr[i];
                i++;
            }
            index++;
        }

        while (i <= mid) {
            temp[index] = arr[i];
            i++;
            index++;
        }

        while (j <= end) {
            temp[index] = arr[j];
            j++;
            index++;
        }

        for (int k = 0; k < index; k++) {
            arr[beg + k] = temp[k];
        }
    }

}