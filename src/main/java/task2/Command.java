package task2;

import java.util.List;

public interface Command {
    void execute(Context context, List<String> args) throws CommandException; //возвращаю сигнутур метода как была
}
