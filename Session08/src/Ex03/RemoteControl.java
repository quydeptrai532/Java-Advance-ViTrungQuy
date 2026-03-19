package Ex03;

import java.util.*;

class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int slot, Command command) {
        buttons.put(slot, command);
        System.out.println("Đã gán command cho nút " + slot);
    }

    public void pressButton(int slot) {
        Command cmd = buttons.get(slot);
        if (cmd != null) {
            cmd.execute();
            history.push(cmd);
        } else {
            System.out.println("Chưa gán nút!");
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("Không có gì để undo!");
        }
    }
}