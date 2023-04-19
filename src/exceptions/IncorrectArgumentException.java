package exceptions;

public class IncorrectArgumentException extends RuntimeException {
    private final String argument;

    public IncorrectArgumentException(final String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "Ошибка ввода {" +
                "описание ошибки: '" + getArgument() + '\'' +
                '}';
    }
}
