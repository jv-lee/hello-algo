package practise;

public class TowPointsFind {
    public int guess(int num) {
        return -1;
    }

    public boolean isBadVersion(int version) {
        return false;
    }

    class MountainArray {
        public int get(int index) {
            return -1;
        }

        public int length() {
            return -1;
        }
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

    /// 33. 搜索旋转排序数组
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int searchRotate(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /// 81. 搜索旋转排序数组 II
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public boolean searchRotate2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    /// 278. 第一个错误的版本
    /// 时间复杂度 O(logN)
    /// 空间复杂度 O(1)
    /// The isBadVersion API is defined in the parent class VersionControl. boolean
    /// isBadVersion(int version);
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /// LCR 069. 山脉数组的峰顶索引
    /// 时间复杂度O(logN)
    /// 空间复杂度O(1)
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /// 1095. 山脉数组中查找目标值
    /// 时间复杂度 O(LogN)
    /// 空间复杂度 O(1)
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int maxIndex = findMaxIndex(mountainArr);
        int left = 0;
        int right = maxIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        }

        left = maxIndex + 1;
        right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    public int findMaxIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
