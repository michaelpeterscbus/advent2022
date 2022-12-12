package advent2022;

import advent2022.day7.Day7;
import advent2022.day7.strategies.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

    private final CdStrategy cdStrategy = new CdStrategy();
    private final PopStrategy popStrategy = new PopStrategy();
    private final DirStrategy dirStrategy = new DirStrategy();
    private final LsStrategy lsStrategy = new LsStrategy();
    private final FileStrategy fileStrategy = new FileStrategy();
    private final Day7 subject = new Day7(List.of(cdStrategy, popStrategy, dirStrategy, lsStrategy, fileStrategy));

    @Test
    void part1_withSampleInput() {
        var result = subject.getTotalSizesSum("sampleInput.txt");

        assertThat(result).isEqualTo(95437);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getTotalSizesSum("input.txt"));
    }

    @Test
    void part2_withSampleInput() {
        var result = subject.getSmallestDirectoryToDelete("sampleInput.txt");

        assertThat(result).isEqualTo(24933642);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getSmallestDirectoryToDelete("input.txt"));
    }
}