package com.limelight;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildEncoder {

    private List<Transformation> transformations;

    public BuildEncoder(List<String> transformationTypes){
        transformations = new ArrayList<>();
        for(String transformation : transformationTypes){
            Transformation t = EncoderFactory.getTransformationType(transformation);
            transformations.add(t);
        }
    }

    public String encode(String input){
        if(input.isEmpty()) return null;
        String inputLC = input.toLowerCase();
        char[][] originalKeyboard = Keyboard.getOriginalKeyBoard();
        char[][] transformedKeyboard = getTransformedKeyboard(originalKeyboard);
        Map<Character, Character> keyboardMap = Keyboard.generateMap(originalKeyboard,transformedKeyboard);
        char[] inputArr = inputLC.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : inputArr){
            if(keyboardMap.containsKey(ch)){
                sb.append(keyboardMap.get(ch));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public char[][] getTransformedKeyboard(char[][] inKeyboard){
        char[][] outKeyboard = inKeyboard;
        for(Transformation t : transformations){
            outKeyboard =  t.transform(outKeyboard);
        }
        return outKeyboard;
    }

}
