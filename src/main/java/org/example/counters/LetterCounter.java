package org.example.counters;


public class LetterCounter {
    public long countLettersInString(char letter, String str) {

        long lettersInStringCount = str.chars().asLongStream().filter(ch -> ch == letter).count();
        return lettersInStringCount;
    }
}
