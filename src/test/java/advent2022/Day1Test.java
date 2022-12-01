package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {

    private final Day1 subject = new Day1();

    @Test
    void part1_withSampleInput() {
        var result = subject.getMaxCalories("sampleInput.txt");

        assertThat(result).isEqualTo(24000);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getMaxCalories("input.txt"));
    }

    @Test
    void part2_withSampleInput() {
        var result = subject.getTop3CalorieTotal("sampleInput.txt");

        assertThat(result).isEqualTo(45000);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getTop3CalorieTotal("input.txt"));
    }
}