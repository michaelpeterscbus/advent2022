package advent2022.day7.strategies;

import advent2022.day7.Directory;

public abstract class BaseStrategy {

    public abstract int getPriority();
    public abstract boolean shouldApply(String input);
    public abstract Directory run(String line, Directory currentDirectory);
}
