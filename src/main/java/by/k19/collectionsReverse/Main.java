package by.k19.collectionsReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();
            if (line == null)
                return;
            List<String> list = new ArrayList<>();
            Collections.addAll(list, line.split(" "));
            List<String> temp = new ArrayList<>();
            for (String word : list) {
                try {
                    if (Integer.parseInt(word) % 2 != 0) {
                        temp.add(word);
                    }
                } catch (NumberFormatException ignored) {}
            }
            list.removeAll(temp);
            Collections.reverse(list);
            System.out.println(String.join(" ", list));
        } catch (IOException ignored) {}
    }
}
