package Ex05;

class ACSetTempCommand implements Command {
    private AirConditioner ac;
    private int temp;

    public ACSetTempCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.temp = temp;
    }

    public void execute() {
        ac.setTemperature(temp);
    }
}