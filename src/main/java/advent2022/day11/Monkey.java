package advent2022.day11;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Monkey {
    private List<Long> items = new ArrayList<>();
    private String operationType;
    private String operationNumString;
    private int divisorNum;
    private int trueMonkey;
    private int falseMonkey;

    public long getValueAfterOperation(long oldValue) {
        long operationNum;
        if (operationNumString.startsWith("old")) {
            operationNum = oldValue;
        } else {
            operationNum = Integer.parseInt(operationNumString);
        }
        if (operationType.equals("*")) {
            return oldValue * operationNum;
        } else {
            return oldValue + operationNum;
        }
    }

    public int getMonkeyNumberAfterTest(long num) {
        if (num % divisorNum == 0) return trueMonkey;
        return falseMonkey;
    }
}
