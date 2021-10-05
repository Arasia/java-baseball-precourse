package baseball.ball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {
    @Test
    void checkRangeTest() {
        assertThatThrownBy(() -> new Ball(0, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임에 설정된 숫자 범위를 벗어났습니다.");
    }

    @Test
    void checkNothing() {
        Ball answer = new Ball(0, 1);
        Ball input = new Ball(0, 2);

        assertThat(answer.check(input))
                .isEqualByComparingTo(BallResult.NOTHING);
    }

    @Test
    void checkBall() {
        Ball answer = new Ball(0, 1);
        Ball input = new Ball(1, 1);

        assertThat(answer.check(input))
                .isEqualByComparingTo(BallResult.BALL);
    }

    @Test
    void checkStrike() {
        Ball answer = new Ball(0, 1);
        Ball input = new Ball(0, 1);

        assertThat(answer.check(input))
                .isEqualByComparingTo(BallResult.STRIKE);
    }
}
