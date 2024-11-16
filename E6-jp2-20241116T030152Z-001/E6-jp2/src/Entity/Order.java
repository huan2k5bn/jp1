package Entity;

import java.util.Date;

public class Order {
    private int id;
    private int customerId;
    private Date dateTime;

    public Order(int id, int customerId, Date dateTime) {
        this.id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public Date getDateTime() { return dateTime; }
}