package Entity;

public class Customer {
    private String id;
    private String cusName;
    private String cusPhone;

    public Customer(String id, String cusName, String cusPhone) {
        this.id = id;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
    }

    public String getId() {
        return id;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }
}
