package model;

import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(final String title, final String description, final Type type) {
        super(title, description, type);
    }

    @Override
    public boolean appearsIn(final LocalDate date) {
        return false;
    }
}
