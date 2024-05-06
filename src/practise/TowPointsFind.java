package practise;

public class TowPointsFind {
    public int guess(int num) {
        return -1;
    }

    public boolean isBadVersion(int version) {
        return false;
    }

    /// 704. 二分查找
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /// 374. 猜数字大小
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return guess(left) == 0 ? left : -1;
    }

    /// 35. 搜索插入位置
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /// 34. 在排序数组中查找元素的第一个和最后一个位置
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[] { -1, -1 };
        }

        int firstIndex = findFirstIndex(nums, target);
        if (firstIndex == -1) {
            return new int[] { -1, -1 };
        }
        int lastIndex = findLastIndex(nums, target);
        return new int[] { firstIndex, lastIndex };
    }

    public int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /// 153. 寻找旋转排序数组中的最小值
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /// 154. 寻找旋转排序数组中的最小值 II
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
