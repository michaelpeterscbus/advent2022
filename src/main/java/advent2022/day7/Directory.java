package advent2022.day7;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Data
@EqualsAndHashCode
public class Directory {
    private String name;
    private Directory parent;
    private List<Directory> subdirectories = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public int getSize() {
        var sum = 0;
        var stack = new Stack<Directory>();
        stack.push(this);
        while (!stack.isEmpty()) {
            var currentDirectory = stack.pop();
            sum += currentDirectory.getFiles().stream().mapToInt(File::getSize).sum();
            for (var subdirectory : currentDirectory.getSubdirectories()) {
                stack.push(subdirectory);
            }
        }
        return sum;
    }
}
