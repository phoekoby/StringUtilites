package ru.vsu.cs.string.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private StringUtils() {
    }
    public static int indexOf(String string, char c, int start) {
        if (string.length() == 0 || !contains(string, c) || start < 0 || start >= string.getBytes().length) {
            return -1;
        }
        byte[] bytes = string.getBytes();
        for (int i = start; i < bytes.length; i++) {
            if (bytes[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(String string, String findingString) {
        if (string.length() == 0 || findingString.length() == 0 || string.length() < findingString.length()) {
            return -1;
        }
        return unsafeIndexOf(string, findingString, 0);
    }

    public static int indexOf(String string, char c) {
        return indexOf(string,c,0);
    }

    public static int indexOf(String string, String findingString, int start) {
        if (string.length() == 0 || findingString.length() == 0 || string.length() < findingString.length()) {
            return -1;
        }
        if (start < 0 || start > string.length()) {
            return -1;
        }
        return unsafeIndexOf(string, findingString, start);
    }

    private static int unsafeIndexOf(String string, String findingString, int start) {
        byte[] value = string.getBytes();
        byte[] str = findingString.getBytes();
        byte first = str[0];
        int max = (value.length - str.length);
        for (int i = start; i <= max; i++) {

            if (value[i] != first) {
                while (++i <= max && value[i] != first);
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + str.length - 1;
                for (int k = 1; j < end && value[j] == str[k]; j++, k++) ;
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean contains(String string, char c) {
        for (byte ch : string.getBytes()) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(String string, String findingString) {
        return indexOf(string, findingString) != -1;
    }

    public static boolean equals(String String1, String String2) {
        if (String1.length() != String2.length()) {
            return false;
        }
        byte[] firstStringBytes = String1.getBytes();
        byte[] secondStringBytes = String2.getBytes();
        for (int i = 0; i < firstStringBytes.length; i++) {
            if (secondStringBytes[i] != firstStringBytes[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String String1, String String2) {
        if (String1.length() != String2.length()) {
            return false;
        }
        byte[] firstStringBytes = String1.getBytes();
        byte[] secondStringBytes = String2.getBytes();
        for (int i = 0; i < firstStringBytes.length; i++) {
            if (Character.toLowerCase(secondStringBytes[i]) != Character.toLowerCase(firstStringBytes[i])) {
                return false;
            }
        }
        return true;
    }

    public static String concatenate(String... strings) {
        if (strings.length <= 1) {
            return strings[0];
        }
        List<Byte> bytes = new ArrayList<>();
        for (String str : strings) {
            byte[] strBytes = str.getBytes();
            for (byte c : strBytes) {
                bytes.add(c);
            }
        }
        byte[] result = new byte[bytes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = bytes.get(i);
        }
        return new String(result);
    }

    public static String join(String regex, String... strings) {
        if (strings.length <= 1) {
            return strings[0];
        }
        List<String> stringsToConcatenate = new ArrayList<>();
        for(int i = 0; i < strings.length-1;i++){
            stringsToConcatenate.add(strings[i]);
            stringsToConcatenate.add(regex);
        }
        stringsToConcatenate.add(strings[strings.length-1]);
        String[] result = new String[stringsToConcatenate.size()];
        return concatenate(stringsToConcatenate.toArray(result));
    }

    public static String[] split(String String, String regex) {
        List<String> strings = new ArrayList<>();
        byte[] bytes = String.getBytes();
        int start = 0;
        int end;
        while (true) {
            end = indexOf(String, regex, start);
            if (end != -1) {
                strings.add(new String(Arrays.copyOfRange(bytes, start, end)));
                start = end + regex.length();
            } else {
                strings.add(new String(Arrays.copyOfRange(bytes, start, bytes.length)));
                break;
            }
        }
        if (strings.get(strings.size() - 1).equals("")) {
            strings.remove(strings.size() - 1);
        }
        String[] result = new String[strings.size()];
        return strings.toArray(result);
    }
}
