package baseball.config;

public class BaseballConfig {
    private BaseballConfig() {
        throw new IllegalStateException("Config Constant Class");
    }

    public static final int NUMBER_COUNT = 3;
    public static final int NUMBER_START_INCLUSIVE = 1;
    public static final int NUMBER_FINISH_INCLUSIVE = 9;
}
