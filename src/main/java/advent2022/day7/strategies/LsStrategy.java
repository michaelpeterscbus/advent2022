package advent2022.day7.strategies;

import advent2022.day7.Directory;

public class LsStrategy extends BaseStrategy {
    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean shouldApply(String input) {
        return input.startsWith("$ ls");
    }

    @Override
    public Directory run(String line, Directory currentDirectory) {
        return currentDirectory;
    }
}
