package advent2022;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Day12 {

    public int getFewestSteps(String filename) {
        var heightmapWithMarkers = getHeightmapAndMarkers(filename);
        var heightmap = heightmapWithMarkers.heightmap;
        var start = heightmapWithMarkers.startingPoint;
        var end = heightmapWithMarkers.endingPoint;

        var queue = new LinkedList<PointWithDistance>();
        queue.add(new PointWithDistance(start, 0));
        var visited = new HashSet<Point>();
        while (!queue.isEmpty()) {
            var current = queue.remove();
            var currentChar = heightmap[current.point.x][current.point.y];
            if (current.point.equals(end)) return current.distance;

            visited.add(current.point);
            var nextPoints = List.of(
                    new Point(current.point.x + 1, current.point.y),
                    new Point(current.point.x - 1, current.point.y),
                    new Point(current.point.x, current.point.y + 1),
                    new Point(current.point.x, current.point.y - 1));

            for (var point : nextPoints) {
                if (isInbounds(point.x, point.y, heightmap)
                        && isAtMostOneStepHigher(currentChar, heightmap[point.x][point.y]) && !visited.contains(point)) {
                    queue.add(new PointWithDistance(point, current.distance + 1));
                }
            }

        }
        return 0;
    }

    @SneakyThrows
    private HeightmapWithMarkers getHeightmapAndMarkers(String filename) {
        var rows = Files.readString(new File("src/test/resources/day12/" + filename).toPath()).split("\n");
        var heightmap = new char[rows.length][rows[0].length()];
        Point startingPoint = null;
        Point endingPoint = null;
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length(); j++) {
                var currentChar =  rows[i].charAt(j);
                heightmap[i][j] = currentChar;

                if (currentChar == 'S') {
                    startingPoint = new Point(i,j);
                    heightmap[i][j] = 'a';
                }
                else if (currentChar == 'E') {
                    endingPoint = new Point(i,j);
                    heightmap[i][j] = 'z';
                }
            }
        }
        return new HeightmapWithMarkers(heightmap, startingPoint, endingPoint);
    }

    private boolean isInbounds(int row, int col, char[][] heightmap) {
        if (row < 0 || row >= heightmap.length) return false;
        if (col < 0 || col >= heightmap[0].length) return false;
        return true;
    }

    private boolean isAtMostOneStepHigher(char current, char next) {
        if (current == next) return true;
        if (current + 1 == next) return true;
        if (current > next) return true;
        return false;
    }

    class PointWithDistance {
        Point point;
        int distance;

        public PointWithDistance(Point point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    @AllArgsConstructor
    class HeightmapWithMarkers {
        char[][] heightmap;
        Point startingPoint;
        Point endingPoint;
    }
}
