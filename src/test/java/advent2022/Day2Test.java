package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    private final Day2 subject = new Day2();

    @Test
    void part1_withSampleInput() {
        assertThat(subject.getPart1TotalScore("sampleInput.txt")).isEqualTo(15);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getPart1TotalScore("input.txt"));
    }

    @Test
    void part2_withSampleInput() {
        assertThat(subject.getPart2TotalScore("sampleInput.txt")).isEqualTo(12);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getPart2TotalScore("input.txt"));
    }
}