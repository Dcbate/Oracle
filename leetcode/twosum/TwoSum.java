package leetcode.twosum;
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


    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] ints = solution.twoSum(new int[]{3,3}, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}



