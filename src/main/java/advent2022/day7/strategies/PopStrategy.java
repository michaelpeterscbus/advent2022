package advent2022.day7.strategies;

import advent2022.day7.Directory;

public class PopStrategy extends BaseStrategy {
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean shouldApply(String input) {
        return input.startsWith("$ cd ..");
    }

    @Override
    public Directory run(String line, Directory currentDirectory) {
        return currentDirectory.getParent();
    }
}
