package advent2022;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day13 {

    @SneakyThrows
    public int getPairsOfPackets(String filename) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day13/" + filename));
        String line;
        int index = 1;
        while((line = reader.readLine()) != null) {
            var list1 = getLineLists(line);
            line = reader.readLine();
            var list2 = getLineLists(line);
            reader.readLine();
        }

        return -1;
    }

    private List<List<Integer>> getLineLists(String line) {
        List<List<Integer>> lists = new ArrayList<>();
        var stack = new Stack<Integer>();
        var characters = line.split("");
        var currentNum = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            var current = characters[i];
            if (!current.equals("[") && !current.equals("]") && !current.equals(",")) {
                currentNum.append(current);
            } else if (current.equals(",")) {
                stack.push(Integer.parseInt(currentNum.toString()));
                currentNum = new StringBuilder();
            } else if (current.equals("]")) {
                stack.push(Integer.parseInt(currentNum.toString()));
                var list = new ArrayList<Integer>();
                while(!stack.isEmpty()) {
                    list.add(stack.pop());
                }
                lists.add(list);
            }
        }
        return lists;
    }
}
