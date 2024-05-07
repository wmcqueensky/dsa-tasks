package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1 = "AlaAa";
        String str2 = "AlaAa";

        System.out.println(checkPermutation(str1, str2));
        System.out.println(checkPermutationMoreOptimally(str1, str2));
        System.out.println(checkPermutationByCount(str1, str2));
    }

    //sorting two strings
    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) { return false; }

        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();

        Arrays.sort(str1Chars);
        Arrays.sort(str2Chars);

        for (int i = 0; i < str1.length(); i++) {
            if (str1Chars[i] != str2Chars[i]) { return false; }
        }

        return true;
    }

    //sorting two strings more optimal
    public static String sort(String str) {
        char[] strChars = str.toCharArray();
        //to not import java.util.Arrays for the whole project
        java.util.Arrays.sort(strChars);
        return new String(strChars);
    }

    public static boolean checkPermutationMoreOptimally(String str1, String str2) {
        if (str1.length() != str2.length()) { return false; }
        return sort(str1).equals(sort(str2));
    }

    //method with checking identical character counts
    public static boolean checkPermutationByCount(String str1, String str2) {
        if (str1.length() != str2.length()) { return false; }

        //we assume that we are working with ASCII
        int[] letters = new int[128];

        char[] str1Chars = str1.toCharArray();
        for (char c : str1Chars) {
            letters[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int c = (int) str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}