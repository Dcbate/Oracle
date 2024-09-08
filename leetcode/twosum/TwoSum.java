package leetcode.twosum;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] array = new int[]{0, 0};

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    public int[] twoSumWithMap(int[] nums, int target) {

        int size = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i<size; i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i<size; i++){
            int needed = target - nums[i];
            if(map.containsKey(needed) && map.get(needed) != i){
                return new int[]{i,map.get(needed)};
            }
        }
        return new int[2];

    }

}



