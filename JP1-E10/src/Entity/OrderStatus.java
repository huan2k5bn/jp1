package Entity;

public enum OrderStatus {
    PENDING("Chờ xử lý"),
    COMPLETED("Đã hoàn thành"),
    CANCEL("Hủy"),
    PAID("Đã thanh toán");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}