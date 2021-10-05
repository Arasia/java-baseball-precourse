package baseball.answer;

import baseball.ball.Balls;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class AnswerTest {
    static Answer answer;

    @BeforeAll
    static void beforeAll() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);

            AnswerGenerator answerGenerator = new AnswerGenerator();
            answer = answerGenerator.generateAnswer();
        }
    }

    @Test
    void checkAnswerTest_Nothing() {
        Balls input = new Balls(Arrays.asList(2, 4, 6));

        assertThat(answer.checkAnswer(input).getResultString())
                .isEqualTo("낫싱");
    }

    @Test
    void checkAnswerTest_Ball3() {
        Balls input = new Balls(Arrays.asList(3, 5, 1));

        assertThat(answer.checkAnswer(input).getResultString())
                .isEqualTo("3볼");
    }

    @Test
    void checkAnswerTest_Strike3() {
        Balls input = new Balls(Arrays.asList(1, 3, 5));

        assertThat(answer.checkAnswer(input).getResultString())
                .isEqualTo("3스트라이크");
    }
}
