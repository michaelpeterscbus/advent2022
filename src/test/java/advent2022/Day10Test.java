package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

    private Day10 subject = new Day10();

    @Test
    void part1_withSampleInput() {
        var result = subject.getSignalStrengthSum("sampleInput.txt");

        assertThat(result).isEqualTo(13140);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getSignalStrengthSum("input.txt"));
    }

    @Test
    void part2_withSampleInput() {
        subject.renderImage("sampleInput.txt");
    }

    @Test
    void part2_answer() {
        subject.renderImage("input.txt");
    }
}