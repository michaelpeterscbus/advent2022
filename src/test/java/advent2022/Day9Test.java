package advent2022;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

class Day9Test {
    private Day9 subject = new Day9();


    @Test
    void touchingTest1() {
        var headPos = new Point(0,0);
        var tailPos = new Point(0,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }

    @Test
    void touchingTest2() {
        var headPos = new Point(1,0);
        var tailPos = new Point(0,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }

    @Test
    void touchingTest3() {
        var headPos = new Point(0,1);
        var tailPos = new Point(0,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }


    @Test
    void touchingTest4() {
        var headPos = new Point(0,0);
        var tailPos = new Point(1,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }

    @Test
    void touchingTest5() {
        var headPos = new Point(1,1);
        var tailPos = new Point(0,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }

    @Test
    void touchingTest6() {
        var headPos = new Point(1,1);
        var tailPos = new Point(0,0);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isTrue();
    }

    @Test
    void touchingTest7() {
        var headPos = new Point(1,1);
        var tailPos = new Point(0,-1);

        assertThat(subject.tailAndHeadAreTouching(headPos, tailPos)).isFalse();
    }

    @Test
    void part1_withSampleInput() {
        var result = subject.getTailMoves("sampleInput.txt");

        assertThat(result).isEqualTo(13);
    }

    @Test
    void part1_answer() {
        System.out.println(subject.getTailMoves("input.txt"));
    }
}