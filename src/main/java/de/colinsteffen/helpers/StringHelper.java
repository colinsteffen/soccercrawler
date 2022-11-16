package de.colinsteffen.helpers;

public class StringHelper {
    private StringHelper() { }

    public static String removeEncoding(String s) {
        return s.replaceAll("[^\\x20-\\x7e]", "");
    }
}
