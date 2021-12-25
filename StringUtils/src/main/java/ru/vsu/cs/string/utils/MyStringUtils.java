package ru.vsu.cs.string.utils;

import ru.vsu.cs.string.MyString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStringUtils {
    private MyStringUtils() {
    }

    public static int indexOf(MyString string, MyString findingString) {
        if (string.length() == 0 || findingString.length() == 0 || string.length() < findingString.length()) {
            return -1;
        }
        return unsafeIndexOf(string, findingString, 0);
    }

    public static int indexOf(MyString string, char c) {
        return indexOf(string,c,0);
    }

    public static int indexOf(MyString string, char c, int start) {
        if (string.length() == 0 || !contains(string, c) || start < 0 || start >= string.getChars().length) {
            return -1;
        }
        char[] chars = string.getChars();
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(MyString string, MyString findingString, int start) {
        if (string.length() == 0 || findingString.length() == 0 || string.length() < findingString.length()) {
            return -1;
        }
        if (start < 0 || start >= string.length()) {
            return -1;
        }
        return unsafeIndexOf(string, findingString, start);
    }

    private static int unsafeIndexOf(MyString string, MyString findingString, int start) {
        char[] value = string.getChars();
        char[] str = findingString.getChars();
        char first = str[0];
        int max = (value.length - str.length);
        for (int i = start; i <= max; i++) {

            if (value[i] != first) {
                while (++i <= max && value[i] != first) ;
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

    public static boolean contains(MyString string, char c) {
        for (char ch : string.getChars()) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(MyString string, MyString findingString) {
        return indexOf(string, findingString) != -1;
    }

    public static boolean equals(MyString myString1, MyString myString2) {
        if (myString1.length() != myString2.length()) {
            return false;
        }
        char[] firstStringChars = myString1.getChars();
        char[] secondStringChars = myString2.getChars();
        for (int i = 0; i < firstStringChars.length; i++) {
            if (secondStringChars[i] != firstStringChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(MyString myString1, MyString myString2) {
        if (myString1.length() != myString2.length()) {
            return false;
        }
        char[] firstStringChars = myString1.getChars();
        char[] secondStringChars = myString2.getChars();
        for (int i = 0; i < firstStringChars.length; i++) {
            if (Character.toLowerCase(secondStringChars[i]) != Character.toLowerCase(firstStringChars[i])) {
                return false;
            }
        }
        return true;
    }

    public static MyString replace(MyString myString, char oldChar, char newChar) {
        return myString.replace(oldChar,newChar);
    }
    public static MyString concatenate(MyString ... strings){
        if(strings.length<=1){
            return strings[0];
        }
        List<Character> chars = new ArrayList<>();
        for(MyString str: strings) {
            char[] strChars = str.getChars();
            for(char c: strChars){
                chars.add(c);
            }
        }
        char[] result = new char[chars.size()];
        for(int i =0; i < result.length;i++){
            result[i] = chars.get(i);
        }
        return new MyString(result);
    }
    public static MyString join(MyString regex, MyString ... strings){
        if(strings.length<=1){
            return strings[0];
        }
        List<MyString> stringsToConcatenate = new ArrayList<>();
        for(int i = 0; i < strings.length-1;i++){
            stringsToConcatenate.add(strings[i]);
            stringsToConcatenate.add(regex);
        }
        stringsToConcatenate.add(strings[strings.length-1]);
        MyString[] result = new MyString[stringsToConcatenate.size()];
        return concatenate(stringsToConcatenate.toArray(result));
    }

    public static MyString[] split(MyString myString, MyString regex){
        List<MyString> strings = new ArrayList<>();
        char[] chars = myString.getChars();
        int start = 0;
        int end;
        while (true){
            end = indexOf(myString,regex,start);
            if(end!=-1){
                strings.add(new MyString(Arrays.copyOfRange(chars,start,end)));
                start = end + regex.length();
            }else{
                strings.add(new MyString(Arrays.copyOfRange(chars,start,chars.length)));
                break;
            }
        }
        if(strings.get(strings.size()-1).equals(new MyString(""))){
            strings.remove(strings.size()-1);
        }
        MyString[] result = new MyString[strings.size()];
        return  strings.toArray(result);
    }

}
