package org.example;

import java.util.Arrays;

public class Main {

    //First Try - Wrong
   public boolean isOneChangeAway(String str1, String str2) {
       if (Math.abs(str1.length() - str2.length()) > 1) {
           return false;
       } else {
           char[] charArray1 = str1.toCharArray();
           char[] charArray2 = str2.toCharArray();
           Arrays.sort(charArray1);
           Arrays.sort(charArray2);

           int changeCounter = 0;

           if (Math.abs(str1.length() - str2.length()) > 0) {
               changeCounter++;
           }

           for (int i=0; i<str1.length(); i++) {
               int letterCount1 = 0;
               int letterCount2 = 0;

               for (int j = i + 1; j<str1.length(); j++) {
                   if (i == j) {
                       continue;
                   }

                   if (str1.charAt(i) == str1.charAt(j)) {
                       letterCount1++;
                   }
               }

               for (int k=0; k<str2.length(); k++) {
                   if (str1.charAt(i) == str1.charAt(k)) {
                       letterCount2++;
                   }
               }

               changeCounter += Math.abs(letterCount1 - letterCount2);

               if (changeCounter > 1) {
                   return false;
               }
           }
       }
       return true;
   }

   //First Correct Solution
   public boolean oneEditAway(String first, String second) {
       if (first.length() == second.length()) {
           return oneEditReplace(first, second);
       } else if (first.length() + 1 == second.length()) {
           return oneEditInsert(first, second);
       } else if (first.length() - 1 == second.length()) {
           return oneEditInsert(second, first);
       }
       return false;
   }
   boolean oneEditReplace(String s1, String s2) {
       boolean foundDiffrence = false;
       for (int i=0; i<s1.length(); i++) {
           if (s1.charAt(i) != s2.charAt(i)) {
               if (foundDiffrence) {
                   return false;
               }
               foundDiffrence = true;
           }
       }
       return true;
   }

   boolean oneEditInsert(String s1, String s2) {
       int index1 = 0;
       int index2 = 0;
       while (index2 < s2.length() && index1 < s1.length()) {
           if (s1.charAt(index1) != s2.charAt(index2)) {
               if (index1 != index2) {
                   return false;
               }
               index2++;
           } else {
               index1++;
               index2++;
           }
       }
       return true;
   }

   //First Correct Solution But Merged
   public boolean oneEditAwayMerged(String first, String second) {
       if (Math.abs(first.length() - second.length()) > 1) {
           return false;
       }

       String s1 = first.length() < second.length() ? first : second;
       String s2 = first.length() < second.length() ? second : first;

       int index1 = 0;
       int index2 = 0;
       boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                if (s1.length() != s2.length()) {
                    index2++;
                    continue;
                }
            }
            index1++;
            index2++;;
        }
        return true;
    }
}