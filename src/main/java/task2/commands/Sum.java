package task2.commands;

import task2.Command;
import task2.CommandException;
import task2.Context;

import java.util.List;
import java.util.Stack;

public class Sum implements Command {
    @Override
    public void execute(Context context, List<String> args) throws CommandException {
        //Stack<Double> stack = context.getStack();
        //if (stack.size() < 2) throw new CommandException("There should be at least 2 values in the stack");
        //stack.push(stack.pop() + stack.pop());
        try{
            if(context.getStack().size()<2)
                throw new CommandException("There should be at least 2 values in the stack");

            double a = context.getStack().pop();//два самых верхних из стека
            double b = context.getStack().pop();

            context.getConstants().put("const",a+b);
            context.getStack().push(a+b);

        }catch (CommandException ce){
            throw ce;
        }catch(Exception e){
            throw new CommandException("Variables not found");
        }
    }
}
