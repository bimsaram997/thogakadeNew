package lk.ijse.thogakade.view.tm;

import com.jfoenix.controls.JFXButton;

public class CustomerTM {
    private String id;
    private String name;
    private String address;
    private double salary;
    private JFXButton btn;

    public CustomerTM(String id, String name, String address, double salary, JFXButton btn) {
       this.id=id;
       this.name=name;
       this.address=address;
       this.salary=salary;
       this.btn=btn;
       btn.setStyle("-fx-background-color: chocolate; -fx-font-weight: bold; -fx-cursor: hand");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", btn=" + btn +
                '}';
    }
}
