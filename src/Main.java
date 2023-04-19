import exceptions.IncorrectArgumentException;
import model.*;
import service.TaskService;
import service.TaskServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayUserMenu(scanner, taskService);
        }
//        scanner.close();
    }

    private static void displayUserMenu(final Scanner scanner, final TaskService taskService) {
        System.out.println("""
                Выберите действие, нажав на нужную клавишу \s
                1 - Добавить задачу \s
                2 - Удалить задачу \s
                3 - Получить список задач на день
                Любая другая цифровая клавиша завершает программу""");
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> addTask(scanner, taskService);
            case 2 -> removeTask();
            case 3 -> getTasksPerDay(LocalDateTime.of(2023, 4, 20, 0, 0, 0), taskService);
            default -> throw new IncorrectArgumentException("Программа завершена");
        }
    }

    private static void addTask(final Scanner scanner, final TaskService taskService) {
        System.out.println("Добавляем новую задачу. Введите название задачи:");
        String title = scanner.next();
        System.out.println("Введите описание задачи:");
        String description = scanner.next();
        System.out.println("""
                Выберите тип задачи:
                1 - рабочая
                2 - личная""");
        final Type taskType = getTaskType(scanner);
        System.out.println("""
                Выберите повторяемость задачи:
                1 - однократная
                2 - ежедневная
                3 - еженедельная
                4 - ежемесячная
                5 - ежегодная""");
        Task task = getTaskRepeat(scanner, title, description, taskType);
        taskService.add(task);
    }

    private static Task getTaskRepeat(final Scanner scanner, final String title, final String description, final Type taskType) {
        int repeat = scanner.nextInt();
        Task task;
        switch (repeat) {
            case 1 -> task = new OneTimeTask(title, description, taskType);
            case 2 -> task = new DailyTask(title, description, taskType);
            case 3 -> task = new WeeklyTask(title, description, taskType);
            case 4 -> task = new MonthlyTask(title, description, taskType);
            case 5 -> task = new YearlyTask(title, description, taskType);
            default -> throw new IncorrectArgumentException("Неверно указана повторяемость задачи: " + repeat);
        }
        return task;
    }

    private static Type getTaskType(final Scanner scanner) {
        int type = scanner.nextInt();
        final Type taskType;
        if (type == 1) {
            taskType = Type.WORK;
        } else if (type == 2) {
            taskType = Type.PERSONAL;
        } else {
            throw new IncorrectArgumentException("Неверно указан тип задачи: " + type);
        }
        return taskType;
    }

    private static void getTasksPerDay(final LocalDateTime dateTime, final TaskService taskService) {
        List<Task> taskList = new ArrayList<>(taskService.getAllByDate(dateTime));
        taskList.forEach(System.out::println);
    }

    private static void removeTask() {
        System.out.println("Remove Task");
    }
}