package by.k19.checkSum;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckSumTask {
    public static void main(String[] args) throws IOException {
        byte[] array = {0x33, 0x45, 0x01};
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array)) {
            System.out.println(checkSumOfStream(byteArrayInputStream));
        }
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int currentByte;
        int sum = 0;
        while((currentByte = inputStream.read()) != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ currentByte;
        }
        return sum;
    }
}
