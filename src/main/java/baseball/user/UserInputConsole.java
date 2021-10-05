package baseball.user;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputConsole {

    private UserInputConsole() {
    }

    public static UserInput getUserInput() {
        UserInput userInput = null;

        while (userInput == null) {
            List<Integer> inputNumberList = getOnlyDigitInput();

            userInput = generateUserInput(inputNumberList);
        }

        return userInput;
    }

    private static List<Integer> getOnlyDigitInput() {
        String inputString;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputString = Console.readLine();
        } while (!validateInput(inputString));

        return convertStringToIntegerList(inputString);
    }

    protected static boolean validateInput(String inputString) {
        String pattern = "^[1-9][0-9]*$";

        if (inputString.matches(pattern)) {
            return true;
        }

        System.out.println("[ERROR] 숫자가 아닌 값을 입력하였습니다.");
        return false;
    }

    private static List<Integer> convertStringToIntegerList(String inputString) {
        List<Integer> inputNumberList = new ArrayList<>();

        for (char c : inputString.toCharArray()) {
            inputNumberList.add(Character.digit(c, 10));
        }

        return inputNumberList;
    }

    private static UserInput generateUserInput(List<Integer> inputNumberList) {
        try {
            return new UserInput(inputNumberList);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 입력값을 다시 확인해주세요.");
            return null;
        }
    }
}
