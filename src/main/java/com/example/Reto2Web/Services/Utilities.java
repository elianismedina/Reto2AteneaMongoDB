package com.example.Reto2Web.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    /**
     *
     * @param pattern
     * @param candidate
     * @return
     */
    private static boolean validateRegex(String pattern, String candidate){
        Pattern pattern_obj = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern_obj.matcher(candidate);
        return matcher.find();
    }

    /**
     *
     * @param email
     * @return
     */
    public static boolean validateEmail(String email){
        String emailPattern = "[a-z][a-z.]*@(usa.edu.co|gmail.com)";
        return validateRegex(emailPattern, email);
    }

    /**
     *
     * @param word
     * @return
     */
    public static String toCapitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }

    /**
     *
     * @param month
     * @return
     */
    public static String checkMonthDigit(String month){
        return (month.length() == 1) ? "0"+month : month;
    }
}
