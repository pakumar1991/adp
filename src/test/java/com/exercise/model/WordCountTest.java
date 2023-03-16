package com.exercise.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    @Test
    void countWordAndAddToMap_WhenALineIsPassed_ReturnTheWordCount() {
        WordCount wordCount = new WordCount();
        wordCount.countWordAndAddToMap("london berlin paris london london paris");
        var actualResult = wordCount.getWordAndCountMap();
        assertAll(() -> assertEquals(3,actualResult.get("london")),
                () -> assertEquals(2,actualResult.get("paris")),
                () -> assertEquals(1,actualResult.get("berlin")));
    }
    @Test
    void countWordAndAddToMap_WhenEmptyLineIsPassed_ReturnEmptyMap(){
        WordCount wordCount = new WordCount();
        wordCount.countWordAndAddToMap(" ");
        var actualResult = wordCount.getWordAndCountMap();
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void countWordAndAddToMap_WhenMultipleLinesPassed_ReturnWordCountForAllLines(){
        WordCount wordCount = new WordCount();
        wordCount.countWordAndAddToMap("london berlin paris london london paris");
        wordCount.countWordAndAddToMap("germany france italy hungary london hungary");
        wordCount.countWordAndAddToMap("london berlin paris london london paris");
        wordCount.countWordAndAddToMap("london berlin paris germany france");
        var actualResult = wordCount.getWordAndCountMap();
        assertAll(() -> assertEquals(8,actualResult.get("london")),
                () -> assertEquals(2,actualResult.get("france")),
                () -> assertEquals(2,actualResult.get("germany")),
                () -> assertEquals(2,actualResult.get("hungary")),
                () -> assertEquals(1, actualResult.get("italy")),
                () -> assertEquals(5, actualResult.get("paris")));
    }

    @Test
    void countWordAndAddToMap_WhenALineWithSameWordAndMissedCases_ReturnWordCountForAllWordsIgnoringTheCase(){
        WordCount wordCount = new WordCount();
        wordCount.countWordAndAddToMap("london berlin PariS LONDON London pariS");
        var actualResult = wordCount.getWordAndCountMap();
        assertAll(() -> assertEquals(3,actualResult.get("london")),
                () -> assertEquals(2,actualResult.get("paris")),
                () -> assertEquals(1,actualResult.get("berlin")));
    }
    @Test
    void countWordAndAddToMap_WhenALineContainingPunctuations_ReturnWordCountIgnoringAllPunctuations(){
        WordCount wordCount = new WordCount();
        wordCount.countWordAndAddToMap("london. berli'n PariS, LONDON, London. pari'S");
        var actualResult = wordCount.getWordAndCountMap();
        assertAll(() -> assertEquals(3,actualResult.get("london")),
                () -> assertEquals(2,actualResult.get("paris")),
                () -> assertEquals(1,actualResult.get("berlin")));
    }
}