package processing.app.exec;

import java.util.Arrays;
import java.util.Iterator;

public class ProcessResult implements Iterable<String> {
  private final String cmd;
  private final long time;
  private final String output;
  private final String error;
  private final int result;

  public ProcessResult(String cmd, int result, String output,
                       String error, long time) {
    this.cmd = cmd;
    this.output = output;
    this.error = error;
    this.result = result;
    this.time = time;
  }

  public Iterator<String> iterator() {
    return Arrays.asList(output.split("\r?\n")).iterator();
  }

  public String getCmd() {
    return cmd;
  }

  public int getResult() {
    return result;
  }

  public boolean succeeded() {
    return result == 0;
  }

  public String getStderr() {
    return error;
  }

  public String getStdout() {
    return output;
  }

  public long getTime() {
    return time;
  }

  @Override
  public String toString() {
      String sb = cmd + "\n" +
              "    status: " + result + "\n" +
              "    " + time + "ms" + "\n" +
              "    stdout:\n" + output.trim() + "\n" +
              "    stderr:\n" + error.trim();
    return sb;
  }

}
