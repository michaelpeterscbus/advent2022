package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Day3 {

    @SneakyThrows
    public int getPrioritySum(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day3/" + filename));
        String line;
        var sum = 0;
        while ((line = reader.readLine()) != null) {
            var firstHalf = line.substring(0, line.length() / 2);
            var secondHalf = line.substring(line.length() / 2);
            var dupe = '*';
            for (int i = 0; i < firstHalf.length(); i++) {
                if (secondHalf.contains(String.valueOf(firstHalf.charAt(i)))) {
                    dupe = firstHalf.charAt(i);
                    break;
                }
            }
            sum += getValueForCharacter(dupe);
        }
        return sum;
    }

    @SneakyThrows
    public int getPart2Sum(String filename) {
       String input = Files.readString(new File("src/test/resources/day3/" + filename).toPath());
       var sacks = input.split("\n");
       var group = new ArrayList<String>();
       var sum = 0;
        for (int i = 0; i < sacks.length; i++) {
            group.add(sacks[i]);
            if (group.size() == 3) {
                var dupe = '*';
                var charCounts = new HashMap<Character, Integer>();
                for (int j = 0; j < group.size(); j++) {
                    addCharacterCounts(group.get(j), charCounts);
                }
                for (var entry : charCounts.entrySet()) {
                    if (entry.getValue() == 3) {
                        dupe = entry.getKey();
                        break;
                    }
                }
                sum += getValueForCharacter(dupe);
                group = new ArrayList<>();
           }
       }
       return sum;
    }

    private void addCharacterCounts(String sack, HashMap<Character, Integer> charCounts) {
        var set = new HashSet<Character>();
        for (int j = 0; j < sack.length(); j++) {
            var currentChar = sack.charAt(j);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                charCounts.put(currentChar, charCounts.getOrDefault(currentChar, 0) + 1);
            }
        }
    }

    private int getValueForCharacter(char dupe) {
        int sum = 0;
        if (Character.isLowerCase(dupe)) {
            sum = (int) dupe -  96;
        } else {
            sum = (int) dupe -  38;
        }
        return sum;
    }
}
