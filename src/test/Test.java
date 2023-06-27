package test;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void test() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] targetNums = towSum2(nums, 5);
        System.out.println(targetNums[0]);
        System.out.println(targetNums[1]);
    }

    public static int[] towSum1(int[] nums, int target) {
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

    public static int[] towSum2(int[] nums, int target) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
