package advent2022;

import advent2022.day11.Day11;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day11Test {
    private Day11 subject = new Day11();

    @Test
    void part1_withTestInput() {
        var result = subject.getMonkeyBusinessLevel("sampleInput.txt", false);

        assertThat(result).isEqualTo(10605);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getMonkeyBusinessLevel("input.txt", false));
    }

    @Test
    void part2_withTestInput() {
        var result = subject.getMonkeyBusinessLevel("sampleInput.txt", true);

        assertThat(result).isEqualTo(2713310158L);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getMonkeyBusinessLevel("input.txt", true));
    }
}