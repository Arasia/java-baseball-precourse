package baseball.answer;

import baseball.config.BaseballConfig;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerGenerator {
    private final Set<Integer> duplicateCheck = new HashSet<>();
    private final List<Integer> answerNumberList = new ArrayList<>();

    public Answer generateAnswer() {

        while (answerNumberList.size() != BaseballConfig.NUMBER_COUNT) {
            pickAndDuplicateCheck();
        }

        return new Answer(answerNumberList);
    }

    private void pickAndDuplicateCheck() {
        int pickNum = Randoms.pickNumberInRange(BaseballConfig.NUMBER_START_INCLUSIVE, BaseballConfig.NUMBER_FINISH_INCLUSIVE);

        if (duplicateCheck.contains(pickNum)) {
            return;
        }

        duplicateCheck.add(pickNum);
        answerNumberList.add(pickNum);
    }
}
