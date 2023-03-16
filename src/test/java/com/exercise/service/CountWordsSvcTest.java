package com.exercise.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsSvcTest {

    Map<String,Integer> wordCountMap = new HashMap<>();

    @BeforeEach
    void setUp() {
        wordCountMap.put("london",10);
        wordCountMap.put("paris",8);
        wordCountMap.put("tokyo",9);
        wordCountMap.put("delhi",5);
    }

    @Test
    void countWordsUsingFilePath_WhenPassedFileHasMultipleLines_ReturnTheWordCount() {
        String path = "/resources/input.txt";
        CountWordsSvc countWordsSvc = new CountWordsSvc();
        try{
            var actualResult = countWordsSvc.countWordsUsingFilePath(path);
            assertAll(() -> assertEquals(6,actualResult.get("london")),
                    () -> assertEquals(8,actualResult.get("paris")),
                    () -> assertEquals(7,actualResult.get("delhi")));
        } catch (IOException e) {

        }
    }

    @Test
    void countWordsUsingFilePath_WhenPassedFilePathIsWrong_ThrowIOException() {
        String path = "/WrongPath/input.txt";
        CountWordsSvc countWordsSvc = new CountWordsSvc();
        assertThrows(IOException.class,() -> countWordsSvc.countWordsUsingFilePath(path));

    }

    @Test
    void displayCountOfWords_WhenAscendingFlagIsPassedAsTrue_ReturnMapInAscendingOrder() {
        CountWordsSvc countWordsSvc = new CountWordsSvc();
        var actualResult = countWordsSvc.displayCountOfWords(wordCountMap,true);
        var listOfKeys = actualResult.entrySet()
                .stream().map(entry -> entry.getKey()).collect(Collectors.toList());
        assertAll(() -> assertEquals("delhi",listOfKeys.get(0)),
                () -> assertEquals("paris",listOfKeys.get(1)),
                () -> assertEquals("tokyo",listOfKeys.get(2)),
                () -> assertEquals("london",listOfKeys.get(3)));

    }

    @Test
    void displayCountOfWords_WhenAscendingFlagIsPassedAsFalse_ReturnMapInDescendingOrder() {
        CountWordsSvc countWordsSvc = new CountWordsSvc();
        var actualResult = countWordsSvc.displayCountOfWords(wordCountMap,false);
        var listOfKeys = actualResult.entrySet()
                .stream().map(entry -> entry.getKey()).collect(Collectors.toList());
        assertAll(() -> assertEquals("london",listOfKeys.get(0)),
                () -> assertEquals("tokyo",listOfKeys.get(1)),
                () -> assertEquals("paris",listOfKeys.get(2)),
                () -> assertEquals("delhi",listOfKeys.get(3)));

    }
}