package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {

    private Day8 subject = new Day8();

    @Test
    void part1_withSampleInput() {
        var result = subject.getVisibleTrees("sampleInput.txt");

        assertThat(result).isEqualTo(21);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getVisibleTrees("input.txt"));
    }
}