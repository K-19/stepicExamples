package by.k19.smallTasks;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SmallTestTask {
    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(in, StandardCharsets.UTF_8));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder builder = new StringBuilder();
        int byt;
        while((byt = reader.read()) != -1) {
            builder.append((char)byt);
        }
        return builder.toString().trim();
    }
}
