package advent2022;

import lombok.SneakyThrows;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Day9 {

    @SneakyThrows
    public int getTailMoves(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day9/" + filename));
        String line;
        var headPos = new Point(0,0);
        var tailPos = new Point(0,0);
        var tailVisited = new HashSet<Point>();
        tailVisited.add(tailPos);
        while ((line = reader.readLine()) != null) {
            var instructions = line.split(" ");
            var direction = instructions[0];
            var moveCount = Integer.parseInt(instructions[1]);
            for (int i = 0; i < moveCount; i++) {
                if (direction.equals("R")) {
                    headPos = new Point(headPos.x, headPos.y + 1);
                } else if (direction.equals("L")) {
                    headPos = new Point(headPos.x, headPos.y - 1);
                } else if (direction.equals("U")) {
                    headPos = new Point(headPos.x + 1, headPos.y);
                } else {
                    headPos = new Point(headPos.x - 1, headPos.y);
                }
                if (!tailAndHeadAreTouching(headPos, tailPos)) {
                    if (headPos.x - tailPos.x > 1 && headPos.y == tailPos.y) {
                        tailPos = new Point(tailPos.x + 1, tailPos.y);
                    } else if (headPos.x - tailPos.x < -1 && headPos.y == tailPos.y) {
                        tailPos = new Point(tailPos.x - 1, tailPos.y);
                    } else if (headPos.y - tailPos.y > 1 && headPos.x == tailPos.x) {
                        tailPos = new Point(tailPos.x, tailPos.y + 1);
                    } else if (headPos.y - tailPos.y < -1 && headPos.x == tailPos.x) {
                        tailPos = new Point(tailPos.x, tailPos.y - 1);
                    } else if (direction.equals("R")) {
                        if (tailPos.x > headPos.x) {
                            tailPos = new Point(tailPos.x - 1, tailPos.y + 1);
                        } else {
                            tailPos = new Point(tailPos.x + 1, tailPos.y + 1);
                        }
                    } else if (direction.equals("L")) {
                        if (tailPos.x > headPos.x) {
                            tailPos = new Point(tailPos.x - 1, tailPos.y - 1);
                        } else {
                            tailPos = new Point(tailPos.x + 1, tailPos.y - 1);
                        }
                    } else if (direction.equals("U")) {
                        if (tailPos.y > headPos.y) {
                            tailPos = new Point(tailPos.x + 1, tailPos.y - 1);
                        } else {
                            tailPos = new Point(tailPos.x + 1, tailPos.y + 1);
                        }
                    } else {
                        if (tailPos.y > headPos.y) {
                            tailPos = new Point(tailPos.x - 1, tailPos.y - 1);
                        } else {
                            tailPos = new Point(tailPos.x - 1, tailPos.y + 1);
                        }
                    }
                    tailVisited.add(tailPos);
                }
            }
        }
        return tailVisited.size();
    }

    public boolean tailAndHeadAreTouching(Point headPos, Point tailPos) {
        return (int) (Math.floor(headPos.distance(tailPos))) <= 1;
    }
}
