package org.example;

public class Main {
    public static void main(String[] args) {
        String phrase = "Tact Coa";
        System.out.println(isPermutationOfPalindrome(phrase));
        System.out.println(isPermutationOfPalindrome2(phrase));
    }

    //Solution #1 O(N), N is the length of the string
    static boolean isPermutationOfPalindrome(String phrase) {
        int[] frequencyTable = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(frequencyTable);
    }

    /*Check that no more than one character has odd count*/
    static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /* Map each character to a number. a -> 0, b -> 1, c -> 2 etc.*/
    /* This is case in-sensitive. Non letter characters map to -1*/
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    static int[] buildCharFrequencyTable(String phrase) {
        int tableSize = Character.getNumericValue('z') - Character.getNumericValue('a') +1;
        int[] table = new int[tableSize];
        for (char c : phrase.toCharArray()) {
            int charNumber = getCharNumber(c);
            if (charNumber != -1) {
                table[charNumber]++;
            }
        }
        return table;
    }

    //Solution #2 alternate solution, might be slower
    static boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int tableSize = Character.getNumericValue('z') - Character.getNumericValue('a') +1;
        int[] table = new int[tableSize];

        for (char c : phrase.toCharArray()) {
            int charNumber = getCharNumber(c);
            if (charNumber != -1) {
                table[charNumber]++;
                if (table[charNumber] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    
}