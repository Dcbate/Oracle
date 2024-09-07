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


    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] ints = solution.twoSum(new int[]{3,3}, 6);
        int[] intWithMap = solution.twoSumWithMap(new int[]{3,3,34,324,23,423,43,4234,32,4325,45,3,5,6,7,6574563,67,8,76867865,634,6435,34,567,45,645,63,34,6564,64,634535,5,5,4,23675,23,4553523,4,5,2342344,23,5,4324234,5,5645,65,6,456,34,52345,3,45234,23,42,34}, 76);
        System.out.println(intWithMap[0]);
        System.out.println(intWithMap[1]);
    }

}



