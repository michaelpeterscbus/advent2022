package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day4Test {

    private Day4 subject = new Day4();


    @Test
    void part1_withSampleInput() {
        var result = subject.getOverlapCount("sampleInput.txt", false);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getOverlapCount("input.txt", false));
    }

    @Test
    void part2_withSampleInput() {
        var result = subject.getOverlapCount("sampleInput.txt", true);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getOverlapCount("input.txt", true));
    }
}