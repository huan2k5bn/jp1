package Entity;

import java.time.LocalDate;

public class Order extends Customer{
    private String id;
    private String cusId;
    private LocalDate datetime;
    public Order() {;}
    public Order(String id, String cusId, LocalDate datetime) {
        super();
        this.id = id;
        this.cusId = cusId;
        this.datetime = datetime;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + id +
                ", cusId=" + cusId +
                ", datetime=" + datetime +
                '}';
    }
}