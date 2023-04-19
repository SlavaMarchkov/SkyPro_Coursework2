package service;

import model.Task;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private final Map<Integer, Task> taskMap;
    private Collection<Task> removedTasks;

    public TaskServiceImpl() {
        this.taskMap = new HashMap<>();
    }

    @Override
    public void add(final Task task) {
        taskMap.put(task.getId(), task);
        System.out.println("Задача добавлена! " + task);
    }

    @Override
    public Task remove(final int id) {
        return null;
    }

    @Override
    public Collection<Task> getAllByDate(final LocalDateTime dateTime) {
        return taskMap
                .values()
                .stream()
                .filter((task -> task.getDateTime().equals(dateTime)))
                .collect(Collectors.toSet());
    }
}
