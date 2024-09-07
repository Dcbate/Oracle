package leetcode.movezeros;

import java.util.Arrays;
import java.util.HashSet;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }




    public static void main(String[] args) {
        moveZeroes(new int[]{0,0,1,0,4});
    }
}
