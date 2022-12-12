package advent2022.day7.strategies;

import advent2022.day7.Directory;
import advent2022.day7.File;

public class FileStrategy extends BaseStrategy {
    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public boolean shouldApply(String input) {
        return true;
    }

    @Override
    public Directory run(String line, Directory currentDirectory) {
        var instruction = line.split(" ");
        var file = new File(instruction[1], Integer.parseInt(instruction[0]));
        currentDirectory.getFiles().add(file);
        return currentDirectory;
    }
}
