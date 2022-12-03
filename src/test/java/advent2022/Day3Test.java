package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    private Day3 subject = new Day3();

    @Test
    void part1_withSampleInput() {
        var result = subject.getPrioritySum("sampleInput.txt");

        assertThat(result).isEqualTo(157);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getPrioritySum("input.txt"));
    }

    @Test
    void part2_withSampleInput() {
        var result = subject.getPart2Sum("sampleInput.txt");

        assertThat(result).isEqualTo(70);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getPart2Sum("input.txt"));
    }
}