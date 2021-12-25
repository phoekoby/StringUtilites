package ru.vsu.cs.string;

import ru.vsu.cs.string.exceptions.StringException;
import ru.vsu.cs.string.utils.MyStringUtils;

import java.util.Arrays;

public class MyString implements CharSequence, Comparable<MyString> {
    private final char[] chars;

    public MyString() {
        chars = new char[0];
    }

    public MyString(char[] chars) {
        this.chars = Arrays.copyOf(chars, chars.length);
    }

    public MyString(String string) {
        byte[] bytes = string.getBytes();
        chars = new char[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            chars[i] = (char) bytes[i];
        }
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            throw new StringException("Illegal index");
        }
        return chars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start < 0 || start >= chars.length || end < 0 || end >= chars.length || end < start) {
            throw new StringException("Incorrect indexes");
        }
        char[] newChars = new char[end - start + 1];
        if (end + 1 - start >= 0) System.arraycopy(this.chars, start, newChars, 0, end + 1 - start);
        return new MyString(newChars);
    }

    @Override
    public boolean isEmpty() {
        return chars.length == 0;
    }

    @Override
    public int compareTo(MyString o) {
        int length = Math.min(o.length(), length());
        char[] oChars = o.getChars();

        for (int i = 0; i < length; i++) {
            if (oChars[i] < chars[i]) {
                return 1;
            } else if (oChars[i] > chars[i]) {
                return -1;
            }
        }
        if (o.length() == length()) {
            return 0;
        } else if (oChars.length > chars.length) {
            return -1;
        } else return -1;
    }

    public char[] getChars() {
        return Arrays.copyOf(chars, length());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public boolean equals(MyString myString) {
        return MyStringUtils.equals(this, myString);
    }

    public boolean equalsIgnoreCase(MyString myString) {
        return MyStringUtils.equalsIgnoreCase(this, myString);
    }

    public int indexOf(MyString findingString) {
        return MyStringUtils.indexOf(this, findingString, 0);
    }

    public int indexOf(char c) {
        return MyStringUtils.indexOf(this, c);
    }

    public int indexOf(char c, int start) {
        return MyStringUtils.indexOf(this, c, start);
    }

    public int indexOf(MyString findingString, int start) {
        return MyStringUtils.indexOf(this, findingString, start);
    }

    public boolean contains(char c) {
        return MyStringUtils.contains(this, c);
    }

    public boolean contains(MyString findingString) {
        return indexOf(findingString) != -1;
    }

    public MyString replace(char oldChar, char newChar) {
        if (oldChar != newChar) {
            while (contains(oldChar)) {
                chars[indexOf(oldChar)] = newChar;
            }
        }
        return this;
    }

    public MyString[] split(MyString regex) {
        return MyStringUtils.split(this, regex);
    }
}
