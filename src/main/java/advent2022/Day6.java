package advent2022;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;

public class Day6 {

    @SneakyThrows
    public int getFirstMarker(String filename, int distinctTarget) {
        var datastream = Files.readString(new File("src/test/resources/day6/" + filename).toPath());
        var charCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < distinctTarget; i++) {
            charCounts.put(datastream.charAt(i), charCounts.getOrDefault(datastream.charAt(i), 0) + 1);
        }

        for (int left = 0; left < datastream.length(); left++) {
            var right = left + distinctTarget;
            if (allCharsUnique(charCounts)) return right;
            charCounts.put(datastream.charAt(left), charCounts.get(datastream.charAt(left)) - 1);
            charCounts.put(datastream.charAt(right), charCounts.getOrDefault(datastream.charAt(right), 0) + 1);
        }
        return -1;
    }

    private boolean allCharsUnique(HashMap<Character, Integer> charCounts) {
        return charCounts.values().stream().filter(value -> value > 1).toList().size() == 0;
    }
}
