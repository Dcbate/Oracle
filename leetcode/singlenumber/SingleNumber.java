package leetcode.singlenumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static int singleNumber(int[] nums) {


        Set<Integer> map = new HashSet<>();

        for (int num : nums) {
            if (map.contains(num)) {
                map.remove(num);
            } else {
                map.add(num);
            }
        }
        return map.stream().findFirst().get();
}

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,4,3,3,2,2,5,5}));
    }
}
