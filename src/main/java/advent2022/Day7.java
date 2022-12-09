package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day7 {

    @SneakyThrows
        public int getTotalSizesSum(String filename) {
            var reader = new BufferedReader(new FileReader("src/test/resources/day7/" + filename));
            String line;
            var directoryMap = new HashMap<String, List<String>>();
            var fileSizeMap = new HashMap<String, Integer>();
            String currentDirectory = "";
            var dupeIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("$ cd") && !line.contains("$ cd ..")) {
                    currentDirectory = line.split(" ")[2];
                    if (directoryMap.containsKey(currentDirectory)) {
                        currentDirectory = currentDirectory + "1";
                    }
                } else {
                    var neighbors = directoryMap.getOrDefault(currentDirectory, new ArrayList<>());
                    var fileSize = 0;
                    String endingDirectory = "";
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("$ cd")) {
                            while (line.startsWith("$ cd ..")) {
                                line = reader.readLine();
                            }
                            endingDirectory = line.split(" ")[2];
                            if (directoryMap.containsKey(endingDirectory)) {
                                endingDirectory = endingDirectory + dupeIndex;
                                dupeIndex++;
                            }
                            break;
                        }

                        if (line.startsWith("dir")) {
                            neighbors.add(line.split(" ")[1]);
                        } else {
                            fileSize += Integer.parseInt(line.split(" ")[0]);
                        }
                    }
                    directoryMap.put(currentDirectory, neighbors);
                    fileSizeMap.put(currentDirectory, fileSize);
                    currentDirectory = endingDirectory;
                }
            }
            var totalSum = 0;
            for (var directory : directoryMap.keySet()) {
                var visited = new HashSet<String>();
                var directorySum = 0;
                var stack = new Stack<String>();
                stack.push(directory);
                while (!stack.isEmpty()) {
                    var popped = stack.pop();
                    visited.add(popped);
                    directorySum += fileSizeMap.get(popped);
                    if (directorySum > 100000) break;
                    for (var neighbor : directoryMap.get(popped)) {
                        if (!visited.contains(neighbor)) {
                            stack.add(neighbor);
                        }
                    }
                }
                if (directorySum <= 100000) totalSum += directorySum;
            }
            return totalSum;
        }
}
