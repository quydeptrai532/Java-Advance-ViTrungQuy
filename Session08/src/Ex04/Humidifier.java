package Ex04;

class Humidifier implements Observer {
    @Override
    public void update(int temp) {
        System.out.println("Máy tạo ẩm: Điều chỉnh độ ẩm cho nhiệt độ " + temp);
    }
}