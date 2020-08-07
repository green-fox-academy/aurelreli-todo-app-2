package todoapp;

public class Main {
  public static void main(String[] args) {
    String fileName = "data.txt";
    Tasks tasks = new Tasks();
    if (args.length == 0) {
      System.out.println(printUsage());
    } else if (args[0].equals("-l")) {
      tasks.listTasks(fileName);
    } else if (args[0].equals("-a")) {
      tasks.addTask(fileName, args[1]);
    } else if (args[0].equals("-r")) {
      tasks.removeTask(fileName, args[1]);
    }
  }
  public static String printUsage() {
    return ("Command Line Todo application\n" +
        "=============================\n" +
        "\n" +
        "Command line arguments:\n" +
        "    -l   Lists all the tasks\n" +
        "    -a   Adds a new task\n" +
        "    -r   Removes an task\n" +
        "    -c   Completes an task");
  }
}
