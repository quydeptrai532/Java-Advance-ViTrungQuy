package Ex05;

class FanLowCommand implements Command {
    private Fan fan;

    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.setLow();
    }
}