public class Longest_Palindromic {

    public static int startPoint, endPoint, max = Integer.MIN_VALUE;

    public static void checkString(String s, int start, int end) {    //code to reverse any string
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end) ){
            start--;
            end++;
        }
        if(max<end-start-1){
            startPoint=start+1;  // because after above loop start will be negative;
            endPoint=end;       //  because after above loop start will be of string length which is not included in substring function;
            max=end-start-1;
        }
//        return s.substring(startPoint,endPoint);
    }

    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {

            checkString(s, i, i); // for odd because we are talking it from centre abd checking till last and start
            checkString(s, i, i + 1); // for even  because it has two centre points

        }

        return s.substring(startPoint,endPoint);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
