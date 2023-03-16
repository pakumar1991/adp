package com.exercise.service;

import java.io.IOException;
import java.util.Map;

public interface CountWordsI {
    Map<String,Integer> countWordsUsingFilePath(String filePath) throws IOException;
    Map<String,Integer> displayCountOfWords(Map<String,Integer> wordCount, boolean ascending);
}
