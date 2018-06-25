package com.limelight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Generate a unique number
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        try {
            Path pwd = Paths.get("").toAbsolutePath();
            List<String> lines= Files.lines(Paths.get("C:\\Vivek\\workspace\\Limelight\\src\\main\\resources\\transform1.txt"))
                    .map(line -> line.split("")) // Stream<String[]>
                    .flatMap(Arrays::stream) // Stream<String>
                    .distinct() // Stream<String>
                    .collect(Collectors.toList());

         //   lines.forEach(str -> System.out.println(str));
            transformMapping(";","H");
            shiftArray(getKeyBoardTwoDArray(),10);
            Map<String,String> rowFlipperdMap = getTransformHorizontalShiftMap();
            System.out.println(rowFlipperdMap);
            Map<String,String> colFlipperdMap = getTransformVerticalShiftMap();
            System.out.println(colFlipperdMap);

            Map<String,String> shiftedMap = getTransformShiftMapByNumber(10);
            System.out.println(shiftedMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[][] getKeyBoardTwoDArray(){ return new String[][]{
                {"1","2","3","4","5","6","7","8","9","0"},
                {"q","w","e","r","t","y","u","i","o","p"},
                {"a","s","d","f","g","h","j","k","l",";"},
                {"z","x","c","v","b","n","m",",",".","/"}
        };
    }


    private static String[][] reverseKeyBoardRows(String [][] array)
    {
        String[][] reversedArray = new String[array.length][array[0].length];
        for (int i = 0 ; i < array.length ; i++) {       // for each row...
            String[] reversed = new String[reversedArray[i].length];   // ... create a temporary array that will hold the reversed inner one ...
            for(int j = 0 ; j < array[i].length ; j++) { // ... and for each column ...
                reversed[reversed.length - 1 - j] = array[i][j]; // ... insert the current element at the mirrored position of our temporary array
            }
            reversedArray[i] = reversed; // finally use the reversed array as new row.
        }
        return reversedArray;
    }

    private static String[][] reverseKeyBoardCols(String[][] array) {
        String[][] reversedArray = new String[array.length][array[0].length];
        for(int i = 0; i < (reversedArray.length / 2); i++) {
            String[] temp = array[i];
            reversedArray[i] = array[array.length - i - 1];
            reversedArray[reversedArray.length - i - 1] = temp;
        }
        return reversedArray;
    }

    private static String[][] shiftArray1(String[][] array, int shift) {
        String[][] shiftLeftArray = new String[array.length][array[0].length];
        String[][] shiftRightArray = new String[array.length][array[0].length];

        shift = shift%(shiftLeftArray.length*shiftLeftArray[0].length);
        for (int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < array[i].length ; j++) {
                shiftLeftArray[i][j]=array[(i+((j+shift)/array[i].length))%array.length][(j+shift)%array[i].length];
            }
        }

        for (int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < array[i].length ; j++) {
                shiftRightArray[(i+((j+shift)/array[i].length))%array.length][(j+shift)%array[i].length]=array[i][j];
            }
        }

        System.out.println("Original keyboard");
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n\nLeft Shift keyboard by "+shift);
        for (int i = 0 ; i < shiftLeftArray.length ; i++) {
            for (int j = 0; j < shiftLeftArray[i].length; j++) {
                System.out.print(shiftLeftArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n\nRight Shift keyboard by "+shift);
        for (int i = 0 ; i < shiftRightArray.length ; i++) {
            for (int j = 0; j < shiftRightArray[i].length; j++) {
                System.out.print(shiftRightArray[i][j] + " ");
            }
            System.out.println();
        }

        return shiftLeftArray;
    }

    private static String[][] shiftArray(String[][] array, int shift) {
        String[][] shiftArray = new String[array.length][array[0].length];
        int shiftArrayLength= shiftArray.length*shiftArray[0].length;
        if(shift <0){
            shift = (-1*shift)%shiftArrayLength;
            for (int i = 0 ; i < array.length ; i++) {
                for(int j = 0 ; j < array[i].length ; j++) {
                    shiftArray[i][j]=array[(i+((j+shift)/array[i].length))%array.length][(j+shift)%array[i].length];
                }
            }
        }else{
            shift = shift%shiftArrayLength;
            for (int i = 0 ; i < array.length ; i++) {
                for(int j = 0 ; j < array[i].length ; j++) {
                    shiftArray[(i+((j+shift)/array[i].length))%array.length][(j+shift)%array[i].length]=array[i][j];
                }
            }
        }

        return shiftArray;
    }


    private static Map<String, String> generateMap(String[][] source, String[][] target){
        Map<String, String> map= new HashMap<>();
        for (int i = 0 ; i < source.length ; i++) {
            for(int j = 0 ; j < source[i].length ; j++) {
                map.put(source[i][j],target[i][j]);
            }
        }
        return map;
    }



    public static Map<String, String> getTransformHorizontalShiftMap() {
        String[][] originalKeyBoardArray=getKeyBoardTwoDArray();
        String[][] horizonalFlippedKeyBoardArray=reverseKeyBoardRows(originalKeyBoardArray);
        System.out.println(horizonalFlippedKeyBoardArray);
        return generateMap(originalKeyBoardArray,horizonalFlippedKeyBoardArray);
    }
    public static Map<String, String> getTransformVerticalShiftMap() {
        String[][] originalKeyBoardArray=getKeyBoardTwoDArray();
        String[][] verticalFlippedKeyBoardArray=reverseKeyBoardCols(originalKeyBoardArray);
        System.out.println(verticalFlippedKeyBoardArray);
        return generateMap(originalKeyBoardArray,verticalFlippedKeyBoardArray);
    }

    public static Map<String, String> getTransformShiftMapByNumber(int shifts) {
        String[][] originalKeyBoardArray=getKeyBoardTwoDArray();
        String[][] shifteddKeyBoardArray=shiftArray(originalKeyBoardArray, shifts);
        System.out.println(shifteddKeyBoardArray);
        return generateMap(originalKeyBoardArray,shifteddKeyBoardArray);
    }

    public static String transformMapping(String input, String operationType){
        boolean contains = containsElement(getKeyBoardTwoDArray(),input);

        if(contains) {
            switch (operationType) {
                case "H":
                break;
                case "V":
                break;
            }
        }else{
            return input;
        }
        return null;
    }


    private static boolean containsElement(String[][] array, String element){
        boolean flag=false;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j]==element){
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }

}
