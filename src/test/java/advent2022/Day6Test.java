package advent2022;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {

    private Day6 subject = new Day6();

    @Test
    void part1_sampleInput1() {
        var result = subject.getFirstMarker("sampleInput1.txt", 4);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void part1_sampleInput2() {
        var result = subject.getFirstMarker("sampleInput2.txt", 4);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void part1_sampleInput3() {
        var result = subject.getFirstMarker("sampleInput3.txt", 4);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void part1_sampleInput4() {
        var result = subject.getFirstMarker("sampleInput4.txt", 4);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void part1_sampleInput5() {
        var result = subject.getFirstMarker("sampleInput5.txt", 4);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getFirstMarker("input.txt", 4));
    }

    @Test
    void part2_sampleInput1() {
        var result = subject.getFirstMarker("sampleInput1.txt", 14);

        assertThat(result).isEqualTo(19);
    }

    @Test
    void part2_sampleInput2() {
        var result = subject.getFirstMarker("sampleInput2.txt", 14);

        assertThat(result).isEqualTo(23);
    }

    @Test
    void part2_sampleInput3() {
        var result = subject.getFirstMarker("sampleInput3.txt", 14);

        assertThat(result).isEqualTo(23);
    }

    @Test
    void part2_sampleInput4() {
        var result = subject.getFirstMarker("sampleInput4.txt", 14);

        assertThat(result).isEqualTo(29);
    }

    @Test
    void part2_sampleInput5() {
        var result = subject.getFirstMarker("sampleInput5.txt", 14);

        assertThat(result).isEqualTo(26);
    }

    @Test
    void part2_answer() {
        System.out.println(subject.getFirstMarker("input.txt", 14));
    }
}