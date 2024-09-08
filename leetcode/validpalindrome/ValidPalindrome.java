package leetcode.validpalindrome;

public class ValidPalindrome {


    public static boolean isPalindrome(String s){

        s = s.replaceAll(" ","");
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();

        char[] array = s.toCharArray();

        int length = array.length/2;


            for(int i =0;i<length;i++){
                char left =array[i];
                char right = array[array.length-1-i];
                if(left != right){
                    return false;
                }}

        return true;

    };


    public static void main(String[] args) {
        isPalindrome("tab a cat");
    }

}
