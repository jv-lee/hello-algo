package practise;

import java.util.Random;

public class Sort {

    /// 912. 排序数组
    /// 使用快速排序法
    /// 时间复杂度 平均 O(n*log n)
    /// 空间复杂度 O(logN)
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int povit = partition(nums, left, right);
            quickSort(nums, left, povit);
            quickSort(nums, povit + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int povit = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < povit) {
                le++;
            }

            while (le <= ge && nums[ge] > povit) {
                ge--;
            }

            if (le > ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        return ge;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
