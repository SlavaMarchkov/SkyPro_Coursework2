package model;

import java.time.LocalDate;

public class OneTimeTask extends Task {
    private final String repeat;

    public OneTimeTask(final String title, final String description, final Type type) {
        super(title, description, type);
        this.repeat = "Однократная задача";
    }

    @Override
    public boolean appearsIn(final LocalDate date) {
        return true;
    }

    public String getRepeat() {
        return repeat;
    }

    @Override
    public String toString() {
        return getRepeat() + super.toString();
    }
}
