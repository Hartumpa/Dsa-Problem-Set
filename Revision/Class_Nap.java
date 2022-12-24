package Revision;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Class_Nap {

    public static void main(String[] args) {
        // Set the start time for the nap
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 30);
        Date startTime = calendar.getTime();

        // Get the current time
        Date currentTime = new Date();

        // Calculate the difference between the start time and the current time
        long diff = currentTime.getTime() - startTime.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;

        // Increment the start time by the difference in minutes
        calendar.add(Calendar.MINUTE, (int) diffMinutes);

        // Find the next palindromic time
        while (true) {
            // Format the current time as a string in the format HH:mm
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String time = sdf.format(calendar.getTime());

            // Check if the time is a palindrome
            if (isPalindrome(time)) {
                // Print the palindromic time and exit the loop
                System.out.println("Next palindromic time: " + time);
                break;
            }

            // Increment the time by 1 minute
            calendar.add(Calendar.MINUTE, 1);
        }
    }

    public static boolean isPalindrome(String s) {
        // Check if the string is a palindrome by comparing the characters at
        // the start and end of the string and moving inward until the middle
        // of the string is reached
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}

