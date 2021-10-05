package baseball.ball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {
    @Test
    void validateListCountTest() {
        List<Integer> integerList = Arrays.asList(1, 2);

        assertThatThrownBy(() -> new Balls(integerList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 갯수가 설정과 일치하지 않습니다.");
    }

    @Test
    void validateDuplicateNumberTest() {
        List<Integer> integerList = Arrays.asList(1, 1, 1);

        assertThatThrownBy(() -> new Balls(integerList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 포함되어 있습니다.");
    }

    @Test
    void checkResultTest_Nothing() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(4, 5, 6));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("낫싱");
    }

    @Test
    void checkResultTest_Ball1() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(3, 4, 5));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("1볼");
    }

    @Test
    void checkResultTest_Ball2() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(2, 3, 4));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("2볼");
    }

    @Test
    void checkResultTest_Ball3() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(2, 3, 1));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("3볼");
    }

    @Test
    void checkResultTest_Strike1() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(1, 4, 5));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("1스트라이크");
    }

    @Test
    void checkResultTest_Strike1Ball1() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(1, 3, 4));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("1스트라이크 1볼");
    }

    @Test
    void checkResultTest_Strike1Ball2() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(1, 3, 2));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("1스트라이크 2볼");
    }

    @Test
    void checkResultTest_Strike2() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(1, 2, 4));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("2스트라이크");
    }

    @Test
    void checkResultTest_Strike3() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Balls input = new Balls(Arrays.asList(1, 2, 3));

        assertThat(answer.checkResult(input).getResultString())
                .isEqualTo("3스트라이크");
    }
}
