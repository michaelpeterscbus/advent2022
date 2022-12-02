package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

public class Day2 {

    @SneakyThrows
    public int getPart1TotalScore(String filename) {
         var outcomeValues = Map.of(
                "ROCK vs SCISSORS", 0,
                "ROCK vs ROCK", 3,
                "ROCK vs PAPER", 6,
                "PAPER vs ROCK", 0,
                "PAPER vs PAPER", 3,
                "PAPER vs SCISSORS", 6,
                "SCISSORS vs PAPER", 0,
                "SCISSORS vs SCISSORS", 3,
                "SCISSORS vs ROCK", 6
        );

        var shapeDecoder = Map.of(
                'A', "ROCK",
                'B', "PAPER",
                'C', "SCISSORS",
                'X', "ROCK",
                'Y', "PAPER",
                'Z', "SCISSORS"
        );

        var shapeValues = Map.of(
                "ROCK", 1,
                "PAPER", 2,
                "SCISSORS", 3
        );

        var reader = new BufferedReader(new FileReader("src/test/resources/day2/" + filename));
        String line;
        var total = 0;
        while ((line = reader.readLine()) != null) {
            var picks = line.split(" ");
            var theirPick = shapeDecoder.get(picks[0].charAt(0));
            var myPick = shapeDecoder.get(picks[1].charAt(0));
            var match = String.format("%s vs %s", theirPick, myPick);
            total += outcomeValues.get(match)+ shapeValues.get(myPick);
        }

        return total;
    }

    @SneakyThrows
    public int getPart2TotalScore(String filename) {
        var lossValues = Map.of(
                "ROCK", "SCISSORS",
                "PAPER", "ROCK",
                "SCISSORS", "PAPER"
        );

        var winValues = Map.of(
                "ROCK", "PAPER",
                "PAPER", "SCISSORS",
                "SCISSORS", "ROCK"
        );

        var shapeValues = Map.of(
                "ROCK", 1,
                "PAPER", 2,
                "SCISSORS", 3
        );

        var outcomeDecoder = Map.of(
                'X', "LOSE",
                'Y', "DRAW",
                'Z', "WIN"
        );

        var shapeDecoder = Map.of(
                'A', "ROCK",
                'B', "PAPER",
                'C', "SCISSORS"
        );

        var reader = new BufferedReader(new FileReader("src/test/resources/day2/" + filename));
        String line;
        var total = 0;
        while ((line = reader.readLine()) != null) {
            var picks = line.split(" ");
            var theirShape = shapeDecoder.get(picks[0].charAt(0));
            var neededOutcome = outcomeDecoder.get(picks[1].charAt(0));
            int matchValue = 0;
            switch (neededOutcome) {
                case "LOSE" -> {
                    var neededShape = lossValues.get(theirShape);
                    matchValue = shapeValues.get(neededShape);
                }
                case "DRAW" -> matchValue = shapeValues.get(theirShape) + 3;
                case "WIN" -> {
                    var neededShape = winValues.get(theirShape);
                    matchValue = shapeValues.get(neededShape) + 6;
                }
            }
            total += matchValue;
        }
        return total;
    }
}
