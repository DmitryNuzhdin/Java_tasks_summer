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
            final double check = 0.0000000001;
            String variableName1 = args.get(0);
            String variableName2 = args.get(1);

            double variable1 = context.getConstants().remove(variableName1);
            double variable2 = context.getConstants().remove(variableName2);

            if(context.getStack().size()<2)
                throw new CommandException("There should be at least 2 values in the stack");

            double b = context.getStack().pop();//два самых верхних из стека
            double a = context.getStack().pop();

            if((Math.abs(a - variable1)<check)&(Math.abs(a - variable2)<check)&(Math.abs(b - variable1)<check)&(Math.abs(b - variable2)<check)){
                context.getConstants().put(variableName1,variable1+variable2);
                context.getStack().push(variable1+variable2);
            }else
                throw new CommandException("Variable must be the highest in the Stack");
        }catch(Exception e){
            throw new CommandException("Variables not found");
        }
    }
}