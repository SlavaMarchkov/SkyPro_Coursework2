import model.Task;
import model.Type;
import service.TaskService;
import service.TaskServiceImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskServiceImpl();
        taskService.add(new Task("Some task1", "Description of Task1", Type.WORK));
        System.out.println(taskService.getAllByDate(LocalDateTime.now()));
    }
}