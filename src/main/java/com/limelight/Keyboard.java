package com.limelight;

import java.util.HashMap;
import java.util.Map;

public class Keyboard {

    public static char[][] getOriginalKeyBoard(){ return new char[][]{
            {'1','2','3','4','5','6','7','8','9','0'},
            {'q','w','e','r','t','y','u','i','o','p'},
            {'a','s','d','f','g','h','j','k','l',';'},
            {'z','x','c','v','b','n','m',',','.','/'}
    };
    }

    public static final String HORIZONTAL_FLIP="H";
    public static final String VERTICAL_FLIP="V";

    public static Map<Character, Character> generateMap(char[][] source, char[][] target){
        Map<Character, Character> map= new HashMap<>();
        for (int i = 0 ; i < source.length ; i++) {
            for(int j = 0 ; j < source[i].length ; j++) {
                map.put(source[i][j],target[i][j]);
            }
        }
        return map;
    }
}
