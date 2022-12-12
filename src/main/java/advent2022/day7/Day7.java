package advent2022.day7;

import advent2022.day7.strategies.BaseStrategy;
import advent2022.day7.strategies.FileStrategy;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

@RequiredArgsConstructor
public class Day7 {

    private final List<BaseStrategy> strategies;

    @SneakyThrows
        public int getTotalSizesSum(String filename) {
        var root = buildFileSystem(filename);
        var stack = new Stack<Directory>();
        stack.push(root);
        var sum = 0;
        while (!stack.isEmpty()) {
            var current = stack.pop();
            var currentSize = current.getSize();
            if (currentSize <= 100000) sum += currentSize;
            stack.addAll(current.getSubdirectories());
        }
        return sum;
    }

    @SneakyThrows
    public int getSmallestDirectoryToDelete(String filename) {
        var root = buildFileSystem(filename);
        var smallest = Integer.MAX_VALUE;
        var freeSpace = 70000000 - root.getSize();
        var neededSpace = 30000000 - freeSpace;
        var stack = new Stack<Directory>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            var currentSize = current.getSize();
            if (currentSize >= neededSpace) {
                smallest = Math.min(smallest, currentSize);
            }
            stack.addAll(current.getSubdirectories());
        }
        return smallest;
    }

    private Directory buildFileSystem(String filename) throws IOException {
        var reader = new BufferedReader(new FileReader("src/test/resources/day7/" + filename));
        String line;
        var root = new Directory("/", null);
        var currentDirectory = root;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            var input = line;
            var strategy = strategies.stream()
                    .sorted(Comparator.comparingInt(BaseStrategy::getPriority))
                    .filter(strat -> strat.shouldApply(input))
                    .findFirst().orElse(new FileStrategy());
            currentDirectory = strategy.run(line, currentDirectory);


        }
        return root;
    }
}
