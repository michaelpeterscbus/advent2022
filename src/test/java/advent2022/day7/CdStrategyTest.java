package advent2022.day7;

import advent2022.day7.strategies.CdStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CdStrategyTest {

    private CdStrategy subject = new CdStrategy();

    @Test
    void shouldApply_returnsTrue() {
        assertThat(subject.shouldApply("$ cd a")).isTrue();
    }

    @Test
    void shouldApply_returnsFalse() {
        assertThat(subject.shouldApply("$ ls")).isFalse();
    }
}