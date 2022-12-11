package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Day10 {

    public int getSignalStrengthSum(String filename) {
        var queue = getQueue(filename);
        var total = 0;
        var x = 1;
        var wantedSignals = List.of(20,60,100,140,180,220);
        var size = queue.size();
        for (int i = 0; i < size; i++) {
            if (wantedSignals.contains(i)) {
                total += i * x;
            }
            x += queue.remove();
        }
        return total;
    }

    public void renderImage(String filename) {
        var queue = getQueue(filename);
        var image = new char[7][40];
        var x = 1;
        var size = queue.size();
        for (int i = 0; i < size; i++) {
            x += queue.remove();
            var row = i / 40 ;
            var col = i - (40 * row);
            if (col == x || col - 1 == x || col + 1 == x) {
                image[row][col] = '#';
            } else {
                image[row][col] = '.';
            }
        }
        for (int i = 0; i < image.length - 1; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }


    @SneakyThrows
    private LinkedList<Integer> getQueue(String filename) {
        var queue = new LinkedList<Integer>();
        queue.add(0);
        var reader = new BufferedReader(new FileReader("src/test/resources/day10/" + filename));
        String line;
        while ((line = reader.readLine()) != null) {
            var instruction = line.split(" ");
            if (instruction[0].equals("noop")) {
                queue.add(0);
            } else {
                queue.add(0);
                queue.add(Integer.parseInt(instruction[1]));
            }
        }
        return queue;
    }
}
