package com.limelight;

import java.util.stream.IntStream;

public class VerticalMirrorTransformation implements Transformation {

    @Override
    public char[][] transform(char[][] inKeyboard) {
       char[][] outKeyboard = new char[inKeyboard.length][inKeyboard[0].length];
       IntStream.range(0, (outKeyboard.length / 2))
                .forEach(i ->{
                    char[] temp = inKeyboard[i];
                    outKeyboard[i] = inKeyboard[inKeyboard.length - i - 1];
                    outKeyboard[outKeyboard.length - i - 1] = temp;
                });

        return outKeyboard;
    }


}
