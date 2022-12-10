package advent2022;

import lombok.SneakyThrows;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;

public class Day8 {

    @SneakyThrows
    public int getVisibleTrees(String filename) {
        var input = Files.readString(new File("src/test/resources/day8/" + filename).toPath());
        var rows = input.split("\n");
        var forest = new int[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length(); j++) {
                forest[i][j] = Integer.parseInt(String.valueOf(rows[i].charAt(j)));
            }
        }
        var total = 0;
        var map = new HashMap<Point, Boolean>();
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                var visited = new HashSet<Point>();
                var point = new Point(row, col);
                if (isVisible(forest, row, col, Integer.MAX_VALUE, visited)) {
                    map.put(point, true);
                    total++;
                }
                else {
                    System.out.println(row + " " + col);
                    map.put(point, false);
                }
            }
        }
        return total;
    }

    private boolean isVisible(int[][] forest, int row, int col, int prevTreeSize, HashSet<Point> visited) {
        if (!isInbounds(forest, row, col)) return true;

        var point = new Point(row, col);
        if (visited.contains(point)) return false;

        visited.add(point);
        var currentSize = forest[row][col];

        if (prevTreeSize <= currentSize) return false;

        var visibleFromBelow = isVisible(forest, row + 1, col, currentSize, visited);
        var visibleFromAbove=  isVisible(forest, row - 1, col, currentSize, visited);
        var visibleFromRight= isVisible(forest, row, col + 1, currentSize, visited);
        var visibleFromLeft = isVisible(forest, row, col - 1, currentSize, visited);

        return visibleFromAbove || visibleFromBelow || visibleFromLeft || visibleFromRight;
    }

    private boolean isInbounds(int[][] forest, int row, int col) {
        if (row < 0 || row >= forest.length) return false;
        if (col < 0 || col >= forest[0].length) return false;
        return true;
    }
}
