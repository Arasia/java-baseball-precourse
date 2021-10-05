package baseball.ball;

import static baseball.config.BaseballConfig.NUMBER_FINISH_INCLUSIVE;
import static baseball.config.BaseballConfig.NUMBER_START_INCLUSIVE;

public class Ball {
    private final int index;
    private final int value;

    public Ball(int index, int value) {
        checkRange(value);

        this.index = index;
        this.value = value;
    }

    private void checkRange(int value) {
        if (value < NUMBER_START_INCLUSIVE || value > NUMBER_FINISH_INCLUSIVE) {
            throw new IllegalArgumentException("게임에 설정된 숫자 범위를 벗어났습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public BallResult check(Ball ball) {
        if (value != ball.value) {
            return BallResult.NOTHING;
        }

        if (index == ball.index) {
            return BallResult.STRIKE;
        }

        return BallResult.BALL;
    }
}
