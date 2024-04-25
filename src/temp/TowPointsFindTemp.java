package temp;

public class TowPointsFindTemp {
    public int guess(int num) {
        return -1;
    }

    public boolean isBadVersion(int version) {
        return false;
    }

    /// 704. 二分查找
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
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid])
        }
        return -1;
    }

    /// 154. 寻找旋转排序数组中的最小值 II
    public int findMin(int[] nums) {
        return -1;
    }

    /// 33. 搜索旋转排序数组
    public int search(int[] nums, int target) {
        return -1;
    }

    /// 81. 搜索旋转排序数组 II
    public int search(int[] nums, int target) {
        return -1;
    }

    /// 278. 第一个错误的版本
    /// The isBadVersion API is defined in the parent class VersionControl. boolean
    /// isBadVersion(int version);
    public int firstBadVersion(int n) {
        return -1;
    }

    /// LCR 069. 山脉数组的峰顶索引
    public int peakIndexInMountainArray(int[] arr) {
        return -1;
    }

    /// 1095. 山脉数组中查找目标值
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return -1;
    }

    /// 69. x 的平方根
    public int mySqrt(int x) {
        return -1;
    }

}
