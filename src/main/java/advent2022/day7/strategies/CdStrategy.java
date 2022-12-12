package advent2022.day7.strategies;

import advent2022.day7.Directory;

public class CdStrategy extends BaseStrategy{

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean shouldApply(String input) {
        return input.startsWith("$ cd");
    }

    @Override
    public Directory run(String line, Directory currentDirectory) {
        var instruction = line.split(" ");
        return currentDirectory.getSubdirectories()
                .stream().filter(sub -> sub.getName().equals(instruction[2]))
                .findFirst().orElseThrow();
    }
}
