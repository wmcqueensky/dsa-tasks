package org.example;

public class Main {

    //My correct solution: O(n^2) not very efficient
    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        char letter = str.charAt(0);
        int counter = 0;
        StringBuilder compressed = new StringBuilder();

        for (int i=0; i<str.length(); i++) {
            if (i-1 >= 0) {
                if (str.charAt(i-1) == str.charAt(i)) {
                    continue;
                }
            }

            for (int j=i+1; j<str.length(); j++) {
                counter++;
                if (str.charAt(i) != str.charAt(j)) {
                    compressed.append(letter).append(counter);
                    counter = 0;
                    letter = str.charAt(j);
                    break;
                }
            }
        }

        compressed.append(letter).append(counter+1);

        if (compressed.length() >= str.length()) {
            return str;
        }

        return compressed.toString();
    }


    //solution from the book O(p + k^2), it's slow because it does not use StringBuilder
    //concatenation takes O(n^2) time without StringBuilder
    public static String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
     }

     //Second solution from the book, faster because it uses StringBuilder for the concatenation
    //Time complexity is O(n)
    public static String compressBetter(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    //The best solution with making sure that we do not compress
    // if the compression count is greater than the length of the original str
    String compressBest(String str) {
        int finalLenght = countCompression(str);
        if (str.length() >= finalLenght) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}