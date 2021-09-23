package by.k19.smallTasks.parseDoubleFromStream;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" ");
                for (String word : arr) {
                    try {
                        double digit = Double.parseDouble(word);
                        sum += digit;
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException ignored) {}
        System.out.printf("%.6f", sum);


//        ByteArrayOutputStream repository = new ByteArrayOutputStream();
//        InputStreamReader reader = new InputStreamReader(System.in);
//        int byteInt;
//        while((byteInt = reader.read()) != -1) {
//            char byteChar = (char)byteInt;
//            if (Character.isDigit(byteChar))
//                repository.write(byteInt);
//            if (byteChar == '.' !=) {
//
//            }
//        }
    }
}
