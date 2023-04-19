package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 1;
    private final int id;
    private String title;
    private String description;
    private final Type type;
    private final LocalDateTime dateTime;

    public Task(final String title,
                final String description,
                final Type type
    ) {
        this.id = idGenerator++;
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateTime = LocalDate.now().atTime(0, 0);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate date);

    @Override
    public String toString() {
        return " {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type.getTaskType() +
                ", dateTime=" + dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Task task = (Task) o;

        if (id != task.id) return false;
        if (!Objects.equals(title, task.title)) return false;
        if (!Objects.equals(description, task.description)) return false;
        if (type != task.type) return false;
        return Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        int result = idGenerator;
        result = 31 * result + id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
