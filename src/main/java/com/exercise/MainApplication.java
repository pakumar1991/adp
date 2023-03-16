package com.exercise;

import com.exercise.service.CountWordsI;
import com.exercise.service.CountWordsSvc;
import com.exercise.util.WordCountUtility;
import java.io.IOException;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {

        Map<String,String> argumentMap = WordCountUtility.validateArguments(args);
        if(argumentMap.isEmpty()){
            return;
        }
        try{
            WordCountUtility.validateFilePath(args[1]);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        CountWordsI countWordsSvc = new CountWordsSvc();
        try{
            Map<String,Integer> mapWordCount = countWordsSvc.countWordsUsingFilePath(argumentMap.get(WordCountUtility.FILE_PATH));
            boolean isAscendingOrder = WordCountUtility.isAscendingOrder(argumentMap.get(WordCountUtility.ORDER));
            countWordsSvc.displayCountOfWords(mapWordCount,isAscendingOrder);
        } catch (IOException e) {
            System.err.println("ERROR: error encountered while processing reading the file");
            System.err.println(e.getMessage());
            return;
        }
    }
}