package advent2022.day7.strategies;

import advent2022.day7.Directory;

public class DirStrategy extends BaseStrategy {

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean shouldApply(String input) {
        return input.startsWith("dir");
    }

    @Override
    public Directory run(String line, Directory currentDirectory) {
        var instruction = line.split(" ");
        currentDirectory.getSubdirectories().add(new Directory(instruction[1], currentDirectory));
        return currentDirectory;
    }
}
