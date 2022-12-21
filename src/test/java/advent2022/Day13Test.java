package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day13Test {

    private Day13 subject = new Day13();

    @Test
    void part1_withSampleInput() {
        var result = subject.getPairsOfPackets("sampleInput.txt");

        assertThat(result).isEqualTo(13);
    }
}