package advent2022.day11;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Day11 {

    @SneakyThrows
    public long getMonkeyBusinessLevel(String filename, boolean imSuperWorried) {
        var reader = new BufferedReader(new FileReader("src/test/resources/day11/" + filename));
        String line;
        var monkeys = new ArrayList<Monkey>();
        Monkey currentMonkey = new Monkey();
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Monkey")) {
                currentMonkey = new Monkey();
                //monkeys.add(currentMonkey);
            } else {
                while (line != null && !line.isEmpty()) {
                    var itemString = line.replace("  Starting items: ", "");
                    var items = itemString.split(",");
                    for (int i = 0; i < items.length; i++) {
                        currentMonkey.getItems().add(Long.parseLong(items[i].trim()));
                    }
                    line = reader.readLine();
                    var operationString = line.replace("  Operation: new = old ", "");
                    var operationType = operationString.split(" ")[0];
                    var operationNum = operationString.split(" ")[1];
                    currentMonkey.setOperationType(operationType);
                    currentMonkey.setOperationNumString(operationNum);

                    line = reader.readLine();
                    var divisor = line.replace("  Test: divisible by ", "");
                    currentMonkey.setDivisorNum(Integer.parseInt(divisor));

                    line = reader.readLine();
                    var instruction = line.split(" ");
                    currentMonkey.setTrueMonkey(Integer.parseInt(instruction[instruction.length - 1]));

                    line = reader.readLine();
                    instruction = line.split(" ");
                    currentMonkey.setFalseMonkey(Integer.parseInt(instruction[instruction.length - 1]));

                    monkeys.add(currentMonkey);
                    line = reader.readLine();
                }
            }
        }
        var monkeyItemCount = new HashMap<Integer, Long>();
        for (int i = 0; i < monkeys.size(); i++) {
            monkeyItemCount.put(i, 0L);
        }
        var rounds = imSuperWorried ? 10000 : 20;
        var mod = 1;
        for (var monkey : monkeys) {
            mod *= monkey.getDivisorNum();
        }
        for (int i = 0; i < rounds; i++) {
            var monkeyIndex = 0;
            for (var monkey : monkeys) {
                var itemCount = monkey.getItems().size();
                if (itemCount > 0) {
                    for (int j = 0; j < itemCount; j++) {
                        monkeyItemCount.put(monkeyIndex, monkeyItemCount.get(monkeyIndex) + 1);
                        var currentItem = monkey.getItems().remove(0);
                        currentItem = monkey.getValueAfterOperation(currentItem);
                        if (imSuperWorried) {
                            currentItem = currentItem % mod;
                        } else {
                            currentItem = currentItem / 3;
                        }
                        var monkeyToThrowTo = monkey.getMonkeyNumberAfterTest(currentItem);
                        monkeys.get(monkeyToThrowTo).getItems().add(currentItem);
                    }
                }
                monkeyIndex++;
            }
        }
        var sortedItemCount = monkeyItemCount.values().stream().sorted(Comparator.comparingLong(Long::longValue).reversed()).toList();
        return sortedItemCount.get(0) * sortedItemCount.get(1);
    }
}
