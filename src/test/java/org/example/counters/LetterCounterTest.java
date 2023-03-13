package org.example.counters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LetterCounterTest {

    @InjectMocks
    LetterCounter letterCounter;

    @Test
    public void countLettersInString_shouldReturnCorrectNumber_withOneOccurrence() {
        long actual = letterCounter.countLettersInString('a', "Static word");
        long expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countLettersInString_shouldReturnCorrectNumber_withMultipleOccurrences() {
        long actual = letterCounter.countLettersInString('a', "Static apple");
        long expected = 2;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countLettersInString_shouldReturnZero_withNoOccurrences() {
        long actual = letterCounter.countLettersInString('a', "No occurrences");
        long expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void countLettersInString_shouldReturnZero_withStringIsEmpty() {
        long actual = letterCounter.countLettersInString('a', "");
        long expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
}

