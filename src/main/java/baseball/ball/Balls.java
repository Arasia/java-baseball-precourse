package baseball.ball;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static baseball.config.BaseballConfig.NUMBER_COUNT;

public class Balls {
    private final Map<Integer, Ball> ballHashMap = new HashMap<>();

    public Balls(List<Integer> numberList) {
        validateListCount(numberList);
        validateDuplicateNumber(numberList);
        convertToBallList(numberList);
    }

    private void validateListCount(List<Integer> numberList) {
        if (numberList.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자의 갯수가 설정과 일치하지 않습니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList) {
        Set<Integer> set = new HashSet<>(numberList);
        if (set.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    private void convertToBallList(List<Integer> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            ballHashMap.put(numberList.get(i), new Ball(i, numberList.get(i)));
        }
    }

    public BallCheckResult checkResult(Balls balls) {
        BallCheckResult ballCheckResult = new BallCheckResult();

        for (Map.Entry<Integer, Ball> entry : balls.ballHashMap.entrySet()) {
            ballCheckResult.addResult(checker(entry.getValue()));
        }

        return ballCheckResult;
    }

    public BallResult checker(Ball ball) {
        if (!ballHashMap.containsKey(ball.getValue())) {
            return BallResult.NOTHING;
        }

        return ballHashMap.get(ball.getValue()).check(ball);
    }
}
