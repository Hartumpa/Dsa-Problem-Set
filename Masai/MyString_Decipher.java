package Masai;

public class MyString_Decipher {
    public static void decode(String encoded) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int k=0;
        char c;
        while (i < encoded.length()) {
             c = encoded.charAt(k);
//            System.out.println(c);
            int count = 0;
            while (i < encoded.length() && Character.isDigit(encoded.charAt(i))) {
                k=i;
                count = count * 10 + (encoded.charAt(i) - '0');
                c=encoded.charAt(k+1);
                i++;
            }
            for (int j = 0; j < count; j++) {
                result.append(c);
//                System.out.println(result);
            }

            i++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str="aa3b2c1";
        decode(str);
    }
}
