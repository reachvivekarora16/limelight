package com.limelight;

import java.util.stream.IntStream;

public class HorizontalMirrorTransformation implements Transformation{


    @Override
    public char[][] transform(char[][] inKeyboard) {
        int rows= inKeyboard.length;
        int cols= inKeyboard[0].length;
        char[][] reversedArray = new char[rows][cols];

        IntStream.range(0, rows)
                .forEach(i -> {
                    char[] reversed = new char[reversedArray[i].length];   // ... create a temporary array that will hold the reversed inner one ...
                    IntStream.range(0, cols)
                        .forEach(j -> {
                            reversed[reversed.length - 1 - j] = inKeyboard[i][j]; // ... insert the current element at the mirrored position of our te
                        });
                    reversedArray[i] = reversed; // finally use the reversed array as new row.
                }
                );


        return reversedArray;
    }

}
