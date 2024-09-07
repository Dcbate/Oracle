package leetcode.validpalindrome;

public class ValidPalindrome {


    public static boolean isPalindrome(String s){

        char[] array = s.toCharArray();

        String answer= "";


        for (int i = 0; i<s.length(); i++){

            System.out.println(s.length());

            answer = array[i] + answer;

        }

        System.out.println(answer);



        return true;
    }


    public static void main(String[] args) {
        isPalindrome("hello");
    }

}
