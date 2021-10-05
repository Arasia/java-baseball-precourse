package baseball.answer;

import baseball.ball.Balls;

import java.util.List;

public class Answer {
    /**
     * 랜덤하게 생성된 정답
     */
    private final Balls answerBalls;

    protected Answer(List<Integer> numberList) {
        answerBalls = new Balls(numberList);
    }

    public String checkAnswer(Balls balls) {
        return answerBalls.checkResult(balls);
    }
}
