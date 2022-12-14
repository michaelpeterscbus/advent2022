package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day12Test {

    private Day12 subject = new Day12();

    @Test
    void part1_withSampleInput() {
        var result = subject.getFewestSteps("sampleInput.txt");

        assertThat(result).isEqualTo(31);
    }

    @Test
    void part1_answer() {
        var result = subject.getFewestSteps("input.txt");

        System.out.println(result);
    }

    @Test
    void part2_withTestInput() {
        var result = subject.getFewestStepsFromBestStartingPosition("sampleInput.txt");

        assertThat(result).isEqualTo(29);
    }

    @Test
    void part2_answer() {
        var result = subject.getFewestStepsFromBestStartingPosition("input.txt");

        System.out.println(result);
    }
}