package Ex05;

import java.util.*;

class SleepModeCommand implements Command {
    private List<Command> commands;

    public SleepModeCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute() {
        System.out.println("SleepMode: Kích hoạt");

        for (Command cmd : commands) {
            cmd.execute();
        }
    }
}