package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "Mr John Smith IQ      ";
        System.out.println("\"" + changeWhitespace(str, 16) + "\"");
    }

    public static String changeWhitespace(String str, int trueLength) {
        int whitespaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str.charAt(i) == ' ') {
                whitespaceCount += 1;
            }
        }

        char[] chars = str.toCharArray();
        int index = trueLength + 2 * whitespaceCount;
        if (trueLength < chars.length) chars[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index = index - 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }

        return String.valueOf(chars);
    }
}