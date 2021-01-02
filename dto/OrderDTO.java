package lk.ijse.thogakade.dto;

import java.util.Date;

public class OrderDTO {
    private String id;
    private Date date;
    private String customerId;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }


    public OrderDTO() {
    }


    public OrderDTO(String id, Date date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
