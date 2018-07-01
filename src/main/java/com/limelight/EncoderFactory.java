package com.limelight;

public class EncoderFactory {

    public static Transformation getTransformationType(String transforamtionType){
        if(transforamtionType.isEmpty()) return null;

        if(transforamtionType.equals(Keyboard.HORIZONTAL_FLIP)){
                return new HorizontalMirrorTransformation();
         }else if(transforamtionType.equals(Keyboard.VERTICAL_FLIP)){
            return new VerticalMirrorTransformation();
         }else if(transforamtionType.matches("-?[1-9]\\d*|0")){
                ShiftTransformation shiftTransformation =  new ShiftTransformation();
                shiftTransformation.setShift(Integer.parseInt(transforamtionType));
                return  shiftTransformation;
         }
       return null;
    }
}
