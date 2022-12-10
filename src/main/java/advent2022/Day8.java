package advent2022;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

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
        for (int row = 0; row < forest.length; row++) {
            for (int col = 0; col < forest[0].length; col++) {
                if (isVisible(forest, row, col)) {
                    total++;
                }
            }
        }
        return total;
    }

    private boolean isVisible(int[][] forest, int row, int col) {
        var currentSize = forest[row][col];
        var visibleFromBelow = true;
        for (int i = row  + 1; i < forest.length; i++) {
            if (forest[i][col] >= currentSize) {
                visibleFromBelow = false;
                break;
            }
        }
        var visibleFromAbove=  true;
        for (int i = row - 1; i >= 0; i--) {
            if (forest[i][col] >= currentSize) {
                visibleFromAbove = false;
                break;
            }
        }
        var visibleFromRight = true;
        for (int i = col + 1; i < forest[0].length; i++) {
            if (forest[row][i] >= currentSize) {
                visibleFromRight = false;
                break;
            }
        }
        var visibleFromLeft = true;
        for (int i = col - 1; i >= 0; i--) {
            if (forest[row][i] >= currentSize) {
                visibleFromLeft = false;
                break;
            }
        }
        return visibleFromAbove || visibleFromBelow || visibleFromLeft || visibleFromRight;
    }
}
