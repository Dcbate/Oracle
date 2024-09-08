package leetcode.validpalindrome;

public class ValidPalindrome {


    public static boolean isPalindrome(String s){

        s = s.replaceAll(" ","");
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();

        char[] array = s.toCharArray();

        boolean even = array.length%2 == 0;
        int oddLength = (array.length/2);
        int evenLength = (array.length/2);

        if(even){
            for(int i =0;i<evenLength;i++){
                char left =array[i];
                char right = array[array.length-1-i];
                if(left != right){
                    return false;
                }}
        }else{
            for(int i =0;i<oddLength;i++){
                char left =array[i];
                char right = array[array.length-1-i];
                if(left != right){
                    return false;
                }}

        }

        return true;

    };


    public static void main(String[] args) {
        isPalindrome("Was it a car oor a cat I saw?");
    }

}
