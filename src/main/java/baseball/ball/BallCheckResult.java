package baseball.ball;

import baseball.config.BaseballConfig;

public class BallCheckResult {
    private int strike = 0;
    private int ball = 0;

    public void addResult(BallResult ballResult) {
        if (BallResult.STRIKE.equals(ballResult)) {
            strike++;
            return;
        }

        if (BallResult.BALL.equals(ballResult)) {
            ball++;
        }
    }

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (strike > 0) {
            result.append(strike)
                    .append("스트라이크 ");
        }

        if (ball > 0) {
            result.append(ball)
                    .append("볼");
        }

        return result.toString().trim();
    }

    public boolean isFinish() {
        return strike == BaseballConfig.NUMBER_COUNT;
    }
}
