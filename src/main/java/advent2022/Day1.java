package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {
    public int getMaxCalories(String filename) {
        var caloriesPerElf = getCalorieList(filename);
        return caloriesPerElf.stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }

    public int getTop3CalorieTotal(String filename) {
        var caloriesPerElf = getCalorieList(filename);
        var sortedCalories = caloriesPerElf.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed());
        return sortedCalories.limit(3).mapToInt(Integer::intValue).sum();
    }

    @SneakyThrows
    private List<Integer> getCalorieList(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day1/" + filename));
        String line;
        int index = 0;
        var caloriesPerElf = new ArrayList<Integer>();
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                index++;
            } else {
                if (index > caloriesPerElf.size() - 1) {
                    caloriesPerElf.add(Integer.parseInt(line));
                } else {
                    var total = caloriesPerElf.get(index);
                    total += Integer.parseInt(line);
                    caloriesPerElf.set(index, total);
                }
            }
        }
        return caloriesPerElf;
    }
}
