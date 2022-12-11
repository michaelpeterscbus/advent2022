package advent2022.day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTest {

    private Monkey monkey = new Monkey();

    @Test
    void getOperation_test1() {
        monkey.setOperationType("*");
        monkey.setOperationNumString("19");

        var result = monkey.getValueAfterOperation(79);

        assertThat(result).isEqualTo(1501);
    }

    @Test
    void getOperation_test2() {
        monkey.setOperationType("+");
        monkey.setOperationNumString("old");

        var result = monkey.getValueAfterOperation(10);
        assertThat(result).isEqualTo(20);
    }

    @Test
    void getMonkeyNumberAfterTest_test1() {
        monkey.setDivisorNum(23);
        monkey.setTrueMonkey(2);
        monkey.setFalseMonkey(3);

        var result = monkey.getMonkeyNumberAfterTest(500);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void getMonkeyNumberAfterTest_test2() {
        monkey.setDivisorNum(13);
        monkey.setTrueMonkey(1);
        monkey.setFalseMonkey(7);

        var result = monkey.getMonkeyNumberAfterTest(2080);

        assertThat(result).isEqualTo(1);
    }
}