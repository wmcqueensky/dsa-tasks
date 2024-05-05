package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "Ala";

        System.out.println(isUniqueWithDS(str));
        System.out.println(isUnique(str));
        System.out.println(isUniqueChars(str));
        System.out.println(isUniqueCharsWithBitVector(str));
    }

    //using string, time complexity O(n^2), space complexity O(n)
    public static boolean isUniqueWithDS(String str) {
        char[] letters = str.toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[i] == letters[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    //using string, time complexity O(n^2), space complexity O(1)
    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    //using boolean, time complexity O(n), space complexity O(1)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }

    //using bitwise operations, time complexity O(n), space complexity O(1),
    // it is assumed that only letters from a to z in lowercase are allowed
    public static boolean isUniqueCharsWithBitVector(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}