package test;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTest {

    /**
     * 方法一：暴力枚举
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法二：辅助哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHashTable(int[] nums, int target) {
        int size = nums.length;
        // 辅助哈希表，空间复杂度 O(n)
        Map<Integer, Integer> dic = new HashMap<>();
        // 单层循环，时间复杂度 O(n)
        for (int i = 0; i < size; i++) {
            if (dic.containsKey(target - nums[i])) {
                return new int[] { dic.get(target - nums[i]), i };
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }

    // 1 2 3 4 5 6 7 8 9 10
    // size = 10 target = 5
    // for 0 - not - 1 0
    // for 1 - (5 - 2 = 3) not - 2 1
    // for 2 - (5 - 3 = 2) not - 3 2 (命中) -> target 5 - nums[i 2](3) = 2 -> dic[2] = 1 , i = 2
    // for 3 - (5 - 4 = 1) not - 4 3
}
