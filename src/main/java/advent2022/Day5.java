package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Day5 {

    @SneakyThrows
    public String getTopOfStacks(String filename, boolean isCrateMover9001) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day5/" + filename));
        String line;
        var nums = List.of('1','2','3','4','5','6','7','8','9');
        var stackString = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (!nums.contains(line.charAt(1))) {
                stackString.append(line).append("\n");
            } else {
                reader.readLine();
                break;
            }
        }

        var stackCount = getStackCount(stackString.toString().split("\n")[0]);
        var stacks = getEmptyStacks(stackCount);
        stacks = initializeStacks(stackString.toString(), stacks);

        while ((line = reader.readLine()) != null) {
            var instructions = line.split(" ");
            moveCrates(parseInt(instructions[1]), parseInt(instructions[3]), parseInt(instructions[5]), stacks, isCrateMover9001);
        }

        var topOfStacks = new StringBuilder();
        for (var stack : stacks) {
            topOfStacks.append(stack.pop());
        }
        return  topOfStacks.toString();
    }

    public int getStackCount(String input) {
        //4 spaces for each crate besides the last
        return (input.length() + 1) / 4;
    }

    public List<Stack<String>> initializeStacks(String input, List<Stack<String>> stacks) {
        var rows = input.split("\n");
        for (int i = rows.length - 1; i >=0; i--) {
            var row = rows[i];
            for (int j = 1; j < row.length(); j+=4) {
                var crateValue = row.charAt(j);
                if (crateValue != ' ') {
                    var stackIndex = (j + 2) / 4;
                    stacks.get(stackIndex).push(String.valueOf(crateValue));
                }
            }
        }
        return stacks;
    }

    public List<Stack<String>> getEmptyStacks(int count) {
        var stacks = new ArrayList<Stack<String>>();
        for (int i = 0; i < count; i++) {
            stacks.add(new Stack<>());
        }
        return stacks;
    }

    public List<Stack<String>> moveCrates(int count, int startIndex, int endIndex, List<Stack<String>> stacks, boolean isCrateMover9001) {
        if (isCrateMover9001) {
            var crates = new ArrayList<String>();
            for (int i = 0; i < count; i++) {
                crates.add(stacks.get(startIndex - 1).pop());
            }
            for (int i = crates.size() - 1; i >= 0; i--) {
                stacks.get(endIndex - 1).push(crates.get(i));
            }
        } else {
            for (int i = 0; i < count; i++) {
                var crate = stacks.get(startIndex - 1).pop();
                stacks.get(endIndex - 1).push(crate);
            }
        }
        return stacks;
    }
}
