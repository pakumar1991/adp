package com.exercise.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordCountUtilityTest {

    @Test
    void validateFilePath_WhenPassedFileDoesNotExist_ThrowIOException() {
        String inValidFilePath = "/InvalidFile.txt";
        assertThrows(IOException.class,() -> WordCountUtility.validateFilePath(inValidFilePath));
    }

    @Test
    void validateFilePath_WhenPassedFileTypeIsNotSupported_ThrowIOException() {
        String inValidFileType = "/resources/InvalidFile.exe";
        assertThrows(IOException.class,() -> WordCountUtility.validateFilePath(inValidFileType));
    }

    @Test
    void validateArguments_WhenAllTheFOurArgumentsArePassed_ReturnArgumentsMap() {
        String filePath = "/resources/input.txt";
        String[] args = new String[4];
        args[0] = "-filepath";
        args[1] = filePath;
        args[2] = "-order";
        args[3] = "asc";
        var actualResult = WordCountUtility.validateArguments(args);
        assertAll(() -> assertEquals(filePath,actualResult.get("-filepath")),
                () -> assertEquals("asc",actualResult.get("-order")));
    }

    @Test
    void validateArguments_WhenNoArgumentIsPassed_ReturnEmptyArgumentsMap(){
        String[] args = new String[]{};
        var actualResult = WordCountUtility.validateArguments(args);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void validateArguments_WhenTooManyArgumentsArePassed_ReturnEmptyArgumentsMap(){
        String[] args = new String[]{"arg1","arg2","arg3","arg4","arg5"};
        var actualResult = WordCountUtility.validateArguments(args);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void validateArguments_WhenTheFirstArgumentIsNotFilePath_ReturnEmptyArgumentsMap(){
        String filePath = "/resources/input.txt";
        String[] args = new String[4];
        args[0] = "filepath";
        args[1] = filePath;
        args[2] = "-order";
        args[3] = "asc";
        var actualResult = WordCountUtility.validateArguments(args);
        assertTrue(actualResult.isEmpty());
    }

    @Test
    void isAscendingOrder_WhenArgumentIsPassedAsASC_ReturnTrue() {
        var actualResult = WordCountUtility.isAscendingOrder(WordCountUtility.ASC_ORDERING);
        assertTrue(actualResult);
    }

    @Test
    void isAscendingOrder_WhenArgumentIsPassedAsDSC_ReturnFalse() {
        var actualResult = WordCountUtility.isAscendingOrder(WordCountUtility.DEFAULT_ORDERING);
        assertFalse(actualResult);
    }
}