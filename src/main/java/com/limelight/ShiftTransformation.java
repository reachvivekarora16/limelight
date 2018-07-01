package com.limelight;

import java.util.stream.IntStream;

public class ShiftTransformation implements Transformation {

    private int shift;

    @Override
    public char[][] transform(char[][] inKeyboard) {

        int rows= inKeyboard.length;
        int cols= inKeyboard[0].length;

        char[][] shiftArray = new char[rows][cols];

        int shiftArrayLength= rows*cols;
        if(shift <0){
            shift = (-1*shift)%shiftArrayLength;

            IntStream.range(0, rows)
                    .forEach(i -> IntStream.range(0, cols)
                            .forEach(j -> {
                                shiftArray[i][j]=inKeyboard[(i+((j+shift)/cols))%rows][(j+shift)%cols];
                            })
                    );

        }else{
            shift = shift%shiftArrayLength;

            IntStream.range(0, rows)
                    .forEach(i -> IntStream.range(0, cols)
                            .forEach(j -> {
                                shiftArray[(i+((j+shift)/cols))%rows][(j+shift)%cols]=inKeyboard[i][j];
                            })
                    );
        }

        return shiftArray;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

}
