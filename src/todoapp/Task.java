package todoapp;

public class Task {
  private String content;
  private boolean done = false;

  public boolean isDone() {
    return done;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTask() {
    if (done) {
      return "[x] " + content;
    }
    return "[ ] " + content;
  }
}
