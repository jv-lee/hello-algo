package temp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import data.ListNode;

public class SortTemp {
    /// 912. 排序数组
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
        int randomIndex = left + new Random().nextInt(right - left) / 2;
        swap(nums, randomIndex, left);

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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{1};
    }

    /// 283. 移动零
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
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

    /// 153. 寻找旋转排序数组中的最小值
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    /// 154. 寻找旋转排序数组中的最小值 II
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == nums[right]) {
            right--;
        } else if (nums[mid] > nums[right]) {
            return findMin(nums, mid + 1, right);
        } else {
            return findMin(nums, left, mid);
        }

        return nums[left];
    }

    /// 26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] > nums[left]) {
                left++;
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            right++;
        }
        return ++left;
    }

    /// 80. 删除有序数组中的重复项 II
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int left = 2;
        int right = 2;
        while (right < n) {
            if (nums[right] > nums[left - 2]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
        return left;
    }

    /// 215. 数组中的第K个最大元素
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        sortArray(nums, 0, n - 1, temp);
        return nums[n - k];
    }

    public void sortArray(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sortArray(nums, left, mid, temp);
        sortArray(nums, mid + 1, right, temp);
        sortArrayAppend(nums, left, mid, right, temp);
    }

    public void sortArrayAppend(int[] nums, int left, int mid, int right, int[] temp) {
        int len = right - left + 1;
        for (int i = 0; i < len; i++) {
            temp[i] = nums[left + i];
        }

        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            if (i == mid - left + 1) {
                nums[left + k] = temp[j++];
            } else if (j == right - left + 1) {
                nums[left + k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[left + k] = temp[i++];
            } else {
                nums[left + k] = temp[j++];
            }
        }
    }

}