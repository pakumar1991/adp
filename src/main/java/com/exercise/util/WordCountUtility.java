package com.exercise.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class WordCountUtility {

    public static final String HELP_INSTRUCTIONS = "******* java -jar COMMAND HELP/GUIDE ********* \n java -jar adp-1.0.jar -filepath <absolute path-name> -order <asc>\n \n"+
            "<path-name>: It should be full file path from where the words will be read and counted.\n"+
"<asc> : The default ordering is descending, when this argument is passed, the result will be printed in ascending order. Allowed values are asc and dsc.Ignore the last two arguments if default ordering is preferred\n"+
            "NOTE: if there are any permission errors while running the adp jar, try navigating to folder where jar is located and then run the command. ";

    public static final String FILE_PATH = "-filepath";
    public static final String ORDER = "-order";
    public static final List<String> orderList = List.of("asc","dsc");
    public static final String DEFAULT_ORDERING = "dsc";
    public static final String ASC_ORDERING = "asc";

    public static void validateFilePath(String filePath) throws IOException {
        var file = new File(filePath);
        if(!file.exists()){
            throw new IOException("FILE NOT FOUND: Invalid file name passed");
        }
        var fileType = Files.probeContentType(file.toPath());
        if(fileType == null || !fileType.startsWith("text")){
            throw new IOException("INVALID FILE TYPE: expected a text file" );
        }
    }
    public static Map<String,String> validateArguments(String[] arguments){
        Map<String,String> argumentMap = new HashMap<>();
        if(arguments.length < 2 || arguments.length > 4){
            printHelpInstruction("ERROR: No argument or too many arguments passed");
            return argumentMap;
        }
        if(!arguments[0].equals(FILE_PATH)){
            printHelpInstruction("ERROR : FilePath not passed");
            return argumentMap;
        }
        argumentMap.put(FILE_PATH,arguments[1]);
        argumentMap.put(ORDER,getOrdering(arguments));
        return argumentMap;
    }

    private static void printHelpInstruction(String errorMessage){
        System.out.println(HELP_INSTRUCTIONS);
        System.err.println(errorMessage);
    }

    private static String getOrdering(String[] args){
        if(args.length == 4 && args[2].equals(ORDER) && orderList.contains(args[3])){
            return args[3];
        }
        return DEFAULT_ORDERING;
    }

    public static boolean isAscendingOrder(String order){
        if(order.equals(ASC_ORDERING)){
            return true;
        }
        return false;
    }
}
