package baseball.game;

import baseball.answer.Answer;
import baseball.answer.AnswerGenerator;
import baseball.ball.BallCheckResult;
import baseball.user.UserInput;
import baseball.user.UserInputConsole;
import nextstep.utils.Console;

public class BaseBallGame {
    private Answer answer;
    private UserInput userInput;

    public void start() {
        do {
            startBaseBallGame();
        } while (checkRestart());
    }

    private void startBaseBallGame() {
        initGame();

        BallCheckResult ballCheckResult;
        do {
            userInput = UserInputConsole.getUserInput();

            ballCheckResult = checkAnswer();

        } while (!checkFinishGame(ballCheckResult));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private void initGame() {
        answer = new AnswerGenerator().generateAnswer();
    }

    private BallCheckResult checkAnswer() {
        BallCheckResult ballCheckResult = answer.checkAnswer(userInput.getBalls());

        System.out.println(ballCheckResult.getResultString());

        return ballCheckResult;
    }

    private boolean checkFinishGame(BallCheckResult ballCheckResult) {
        return ballCheckResult.isFinish();
    }

    private boolean checkRestart() {
        String input = getRestartInput();

        if ("1".equals(input)) {
            System.out.println("새로운 게임 시작!");
            return true;
        }

        System.out.println("BassBall 게임 종료");
        return false;
    }

    private String getRestartInput() {
        String input;
        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        } while (validateRestartInput(input));

        return input;
    }

    private boolean validateRestartInput(String input) {
        if ("1".equals(input) || "2".equals(input)) {
            return false;
        }

        System.out.println("[ERROR] 1 또는 2를 입력해주세요.");
        return true;
    }
}
