package practise;

import java.util.HashMap;
import java.util.Map;
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

    /// 1. 两数之和
    /// 时间复杂度 O(n)
    /// 空间复杂度 O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { 1 };
    }

    /// 283. 移动零
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] > nums[left]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    /// 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (total >= 0) {
            if (p1 == -1) {
                nums1[total--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[total--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[total--] = nums1[p1--];
            } else {
                nums1[total--] = nums2[p2--];
            }
        }
    }

}
