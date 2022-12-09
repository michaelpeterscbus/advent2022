package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    private Day7 subject = new Day7();

    @Test
    void part1_withSampleInput() {
        var result = subject.getTotalSizesSum("sampleInput.txt");

        assertThat(result).isEqualTo(95437);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getTotalSizesSum("input.txt"));
    }
}