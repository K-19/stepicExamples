package by.k19.checkSum;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckSumTask {
    public static void main(String[] args) throws IOException {
        byte[] array = {3,45,6,6,76,5,-100,35,6,57,100,34,53,4,2,3,5};
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array)) {
            System.out.println(checkSumOfStream(byteArrayInputStream));
        }
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {

    }
}
