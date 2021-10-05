package baseball.user;

import baseball.ball.Balls;

import java.util.List;

public class UserInput {
    private final Balls balls;

    public UserInput(List<Integer> numberList) {
        balls = new Balls(numberList);
    }

    public Balls getBalls() {
        return balls;
    }
}
