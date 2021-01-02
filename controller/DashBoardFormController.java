package lk.ijse.thogakade.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane root;

    public void loadCustomerForm(ActionEvent actionEvent) throws IOException {
        loadUi("CustomerForm");
    }

    private void loadUi(String location) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass()
                .getResource("/lk/ijse/thogakade/view/"+location+".fxml")));
    }

    public void openItemForm(ActionEvent actionEvent) throws IOException {
        loadUi("ItemForm");
    }

    public void OpenOrderForm(ActionEvent actionEvent) throws IOException {
        loadUi("OrderForm");
    }
}
