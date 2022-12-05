package advent2022;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {
    
    private Day5 subject = new Day5();

    @Test
    void getStackCount_returnsCorrectCountForSampleInput() {
        var input = "    [D]    ";

        var result = subject.getStackCount(input);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void getStackCount_returnsCorrectCountForActualInput() {
        var input = "                    [L]     [H] [W]";

        var result = subject.getStackCount(input);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void getEmptyStacks_returnsListWithCorrectNumberOfStacks() {
        var expected = List.of(new Stack<String>(), new Stack<String>(), new Stack<String>());

        var result = subject.getEmptyStacks(3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void initializeStacks_returnsExpectedStacksFilledWithCrates() {
        var input = "    [D]    \n" +
                "[N] [C]    \n" +
                "[Z] [M] [P]";
        var emptyStacks = List.of(new Stack<String>(), new Stack<String>(), new Stack<String>());

        var expected = getInitialStacks();

        var result = subject.initializeStacks(input, emptyStacks);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void moveCrates_changesStacksAsExpected() {
        var stacks = getInitialStacks();

        var result = subject.moveCrates(1,2,1, stacks, false);

        assertThat(result).isEqualTo(getFirstMoveStacks());
    }

    @Test
    void moveCrates_changesStacksAsExpectedForMove2() {
        var stacks = getFirstMoveStacks();

        var result = subject.moveCrates(3,1,3, stacks, false);

        assertThat(result).isEqualTo(getSecondMoveStacks());
    }

    @Test
    void moveCrates_changesStacksAsExpectedForCrateMover9001() {
        var stacks = getFirstMoveStacks();

        var result = subject.moveCrates(3,1,3, stacks, true);

        assertThat(result).isEqualTo(getSecondMoveStacks9001());
    }

    @Test
    void part1_withSampleInput() {
        var result = subject.getTopOfStacks("sampleInput.txt", false);

        assertThat(result).isEqualTo("CMZ");
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getTopOfStacks("input.txt", false));
    }

    @Test
    void part2_withSampleInput() {
        var result = subject.getTopOfStacks("sampleInput.txt", true);

        assertThat(result).isEqualTo("MCD");
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getTopOfStacks("input.txt", true));
    }

    private List<Stack<String>> getInitialStacks() {
        var stack1 = new Stack<String>();
        stack1.push("Z");
        stack1.push("N");
        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");
        stack2.push("D");
        var stack3 = new Stack<String>();
        stack3.push("P");
        return List.of(stack1, stack2, stack3);
    }

    private List<Stack<String>> getFirstMoveStacks() {
        var stack1 = new Stack<String>();
        stack1.push("Z");
        stack1.push("N");
        stack1.push("D");
        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");
        var stack3 = new Stack<String>();
        stack3.push("P");
        return List.of(stack1, stack2, stack3);
    }

    private List<Stack<String>> getSecondMoveStacks() {
        var stack1 = new Stack<String>();
        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");
        var stack3 = new Stack<String>();
        stack3.push("P");
        stack3.push("D");
        stack3.push("N");
        stack3.push("Z");
        return List.of(stack1, stack2, stack3);
    }

    private List<Stack<String>> getSecondMoveStacks9001() {
        var stack1 = new Stack<String>();
        var stack2 = new Stack<String>();
        stack2.push("M");
        stack2.push("C");
        var stack3 = new Stack<String>();
        stack3.push("P");
        stack3.push("Z");
        stack3.push("N");
        stack3.push("D");
        return List.of(stack1, stack2, stack3);
    }
}