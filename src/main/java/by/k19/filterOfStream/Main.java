package by.k19.filterOfStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            int next, prev = System.in.read();
            while(prev != -1) {
                next = System.in.read();
                if (prev == 13 || next == 10)
                    prev = next;
                else {
                    System.out.write(prev);
                    prev = next;
                }
            }
            if (prev != -1) {
                System.out.write(prev);
            }
        } catch (IOException ignored) {
        } finally {
            System.out.flush();
        }
    }
}
