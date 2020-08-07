package todoapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Tasks {


  public void listTasks(String fileName) {
    ArrayList<Task> tasks = new ArrayList<>();
    try {
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
      for (String line: lines) {
        Task task = new Task();
        task.setContent(line);
        tasks.add(task);
      }
      if (tasks.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < tasks.size(); i++) {
          System.out.println((i + 1) + " - " + tasks.get(i).getTask());
        }
      }
    } catch (IOException e) {
      System.out.println("cannot read file");
    }
  }

  public void addTask(String fileName, String taskContent) {
    try {
      Path filePath = Paths.get(fileName);
      Files.write(filePath, (taskContent + "\n").getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("cannot read file");
    }
  }

  public void removeTask(String fileName, String index) {
    try {
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
      lines.remove(lines.get(Integer.parseInt(index) - 1));
      Files.write(filePath, lines);
    } catch (IOException e) {
      System.out.println("cannot read file");
    }
  }
}
