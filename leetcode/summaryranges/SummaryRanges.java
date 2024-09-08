package leetcode.summaryranges;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> answer = new ArrayList<>();

        if (nums.length ==0){
            return answer;
        }

        String range = nums[0] + " -> ";

        boolean reset = true;

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length) {
                if (!reset) {
                    range = range + "" + nums[i];
                    answer.add(range);
                    break;
                } else {
                    answer.add("" + nums[i]);
                    break;

                }
            }
            if (nums[i] + 1 == nums[i + 1]) {
                System.out.println("is next");
                reset = false;
            } else {
                if (reset) {
                    answer.add("" + nums[i]);
                    range = nums[i + 1] + " -> ";
                    reset = true;
                } else {
                    range = range + "" + nums[i];
                    answer.add(range);
                    range = nums[i + 1] + " -> ";
                    reset = true;
                }
            }
        }

        return answer;

    }
}
