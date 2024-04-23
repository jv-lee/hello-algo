package practise;

public class TowPointsFind {
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
}
