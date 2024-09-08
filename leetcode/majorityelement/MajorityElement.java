package leetcode.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
         int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            n = n / 2;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > n) {
                    return entry.getKey();
                }
            }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,4,3,4,3,3,3,3}));
    }
}
