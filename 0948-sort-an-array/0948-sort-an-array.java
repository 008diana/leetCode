class Solution {
    public int[] sortArray(int[] nums) {
        //selectionSort(nums);
        //bubbleSort(nums);
        //insertionSort(nums);

        //quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    //---------------------------------QuickSort------------------------------------------------
    /*

    public static void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pI = findAndInsertAtPArtition(nums, low, high);
            quickSort(nums, low, pI - 1);
            quickSort(nums, pI + 1, high);
        }
    }

    public static int findAndInsertAtPArtition(int[] nums, int low, int high){
        int piv = nums[low];
        int i = low;
        int j = high;
        while(i < j){
            while(nums[i] <= piv && i <= high - 1){
                i++;
            }
            while(nums[j] > piv && j >= low + 1){
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp2 = nums[low];
        nums[low] = nums[j];
        nums[j] = temp2;

        return j;
    }
    */


    //------------------------------------merge sort-------------------------------------------------
    public static void mergeSort(int[] nums, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] < nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            list.add(nums[left]);
            left++;
        }
        while(right <= high){
            list.add(nums[right]);
            right++;
        }
        for(int i = low; i <= high; i++){
            nums[i] = list.get(i - low);
        }
    }
}