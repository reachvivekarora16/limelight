package com.limelight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainApp {

    public static  void main(String args[]){

        try{
            List<String> transformList = Files.readAllLines(Paths.get("src\\main\\resources\\transform.txt"));
            List<String> tokenList = new ArrayList<>();
            transformList.forEach(str-> {
                        String[] strTokens = str.trim().split("\\s*,\\s*");
                        tokenList.addAll(Arrays.asList(strTokens));
                    }
            );
            BuildEncoder buildEncoder = new BuildEncoder(tokenList);

            Stream<String> stream = Files.lines(Paths.get("src\\main\\\\resources\\text.txt"));
            StringBuilder sb = new StringBuilder();
            stream.forEach(str-> {
                String returnedLine = buildEncoder.encode(str);
                sb.append(returnedLine);
                sb.append("\n");
            }
            );
            System.out.println(sb.toString());

        }catch (NoSuchFileException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
