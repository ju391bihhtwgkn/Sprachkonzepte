import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import java.io.BufferedReader;
import java.util.LinkedList;

public final class Procedural {
    private Procedural() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Paths.get(args[0]);
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(Files.newBufferedReader(input), lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);
        
        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }


    private static void readLines(BufferedReader input, LinkedList<String> lines) throws IOException {
        String line;
        while((line = input.readLine()) != null) {
            lines.add(line);
        }
    }

    /*
    private static void removeEmptyLines(LinkedList<String> lines) {
        lines.removeIf(String::isEmpty);
    }
    */
    private static void removeEmptyLines(LinkedList<String> lines) {
        for (int i = 0; i < lines.size() - 1; i++){
            lines.remove("");
        }
    }


    /*
    private static void removeShortLines(LinkedList<String> lines) {
        lines.removeIf(s -> s.length() < MIN_LENGTH);
    }
    */

    private static void removeShortLines(LinkedList<String> lines) {
        var list = new LinkedList<String>();
        for (String line : lines) {
            if (line.length()<MIN_LENGTH) {
                list.add(line);
            }
        }
        for (String shortLine : list) {
            lines.remove(shortLine);
        }
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        int num = 0;
        for(String line: lines) {
            num += line.length();
        }

        return num;
    }
}