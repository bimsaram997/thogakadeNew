package lk.ijse.thogakade.view.tm;

import com.jfoenix.controls.JFXButton;

import java.util.Date;

public class OrderTM {
    private String id;
    private Date date;
    private String customerID;
    private JFXButton btn;

    public OrderTM() {
    }

    public OrderTM(String id, Date date, String customerID, JFXButton btn) {
        this.id = id;
        this.date = date;
        this.customerID = customerID;
        this.btn = btn;
        btn.setStyle("-fx-background-color: chocolate; -fx-font-weight: bold; -fx-cursor: hand");
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customerID='" + customerID + '\'' +
                ", btn=" + btn +
                '}';
    }
}
