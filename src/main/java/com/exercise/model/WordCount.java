package com.exercise.model;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private Map<String,Integer> wordAndCountMap;

    public WordCount() {
        this.wordAndCountMap = new HashMap<>();
    }
    public Map<String, Integer> getWordAndCountMap() {
        return wordAndCountMap;
    }

    public void countWordAndAddToMap(String line){
        var wordsArray = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for (var word: wordsArray){
            wordAndCountMap.put(word,wordAndCountMap.getOrDefault(word,0)+1);
        }
    }
}
