package leetcode.plusone;

import java.util.*;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        
        int size = digits.length - 1;
        int trailingNines = 0;

        for (int i = size; i > -1; i--) {
            if (digits[i] == 9) {
                trailingNines = trailingNines + 1;
            } else {
                break;
            }
        }

        if (trailingNines != 0 && trailingNines != size + 1) {
            for (int i = 0; i < trailingNines; i++) {
                digits[size - i] = 0;
            }
            digits[size - trailingNines] = digits[size - trailingNines] + 1;
        } else if (trailingNines == size + 1) {
            digits = new int[size + 2];
            digits[0] = 1;

        } else {
            digits[size] = digits[size] + 1;
        }

        return digits;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 9, 9})));
    }
}
