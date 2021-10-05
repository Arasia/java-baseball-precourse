package baseball.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputConsoleTest {

    @Test
    void invalidInputCheckTest() {
        assertThat(UserInputConsole.validateInput("abc"))
                .isFalse();

        assertThat(UserInputConsole.validateInput("a1c"))
                .isFalse();

        assertThat(UserInputConsole.validateInput("123"))
                .isTrue();
    }
}
