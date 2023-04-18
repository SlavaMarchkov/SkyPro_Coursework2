package service;

import model.Task;

import java.time.LocalDateTime;
import java.util.Collection;

public interface TaskService {
    void add(Task task);

    Task remove(int id);

    Collection<Task> getAllByDate(LocalDateTime dateTime);
}
