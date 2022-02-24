package com.anthony4834;

public class Main {


    public static void main(String[] args) {
        System.out.println(reverse("GenSpark"));
    }

    private static String reverse(String word) {
        return word.length() <= 1 ? word : reverse(word.substring(0, word.length() - 1), word.substring(word.length() - 1));
    }

    private static String reverse(String word, String wordReversed) {
        System.out.println(String.format("Word: %s\nReversed: %s", word, wordReversed));
        return word.length() == 0 ? wordReversed : reverse(word.substring(0, word.length() - 1), wordReversed + word.substring(word.length() - 1));
    }

}
