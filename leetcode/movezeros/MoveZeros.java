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

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store){
            if (n != 0) {
                return false;
            }
        }

        return true;
    }





    public static void main(String[] args) {
//        moveZeroes(new int[]{0,0,1,0,4});
        isAnagram("abjshd","bjshda");
    }
}
