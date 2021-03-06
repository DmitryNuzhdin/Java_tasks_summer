package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;

public class Pop implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        if (!context.getStack().empty()) context.getStack().pop();
    }
}
