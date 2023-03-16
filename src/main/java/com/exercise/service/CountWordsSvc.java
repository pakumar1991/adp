package com.exercise.service;

import com.exercise.model.WordCount;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountWordsSvc implements CountWordsI{
    public Map<String,Integer> countWordsUsingFilePath(String filePath) throws IOException {
        FileInputStream fileInputStream = null;
        Scanner scanner = null;
        WordCount wordCount = new WordCount();
        try{
            fileInputStream = new FileInputStream(filePath);
            scanner = new Scanner(fileInputStream, StandardCharsets.UTF_8);
            while(scanner.hasNext()){
                wordCount.countWordAndAddToMap(scanner.nextLine());
            }
            if(scanner.ioException() != null){
                throw scanner.ioException();
            }
        }
        finally {
            if(fileInputStream != null){
                fileInputStream.close();
            }
            if (scanner != null){
                scanner.close();
            }
        }
        return wordCount.getWordAndCountMap();
    }

    public Map<String,Integer> displayCountOfWords(Map<String,Integer> wordCount, boolean ascending){

        if(!wordCount.isEmpty()){
            return wordCount.entrySet()
                    .stream()
                    .sorted((o1, o2) -> {
                     if(ascending){
                         return o1.getValue() - o2.getValue();
                     }
                     else{
                         return o2.getValue() - o1.getValue();
                     }
                    }
                    )
                    .peek(entry -> System.out.println(entry.getKey()+":  " + entry.getValue()))
                    .collect(Collectors.toMap(
                            entry -> entry.getKey(),
                            entry -> entry.getValue(),(x,y) -> y, LinkedHashMap::new
                    ));
        }
        return wordCount;
    }
}
