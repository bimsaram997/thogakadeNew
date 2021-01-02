package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import controller.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.bo.custom.impl.OrderBOImpl;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.view.tm.ItemTM;
import lk.ijse.thogakade.view.tm.OrderTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class OrderFormController {
    public TableColumn colId;
    public TableColumn colDate;
    public TableColumn colCustId;
    public TableColumn colOperate;
    public TextField txtId;
    public TextField txtDate;
    public TextField txtCustId;
    public TableView tbl;

    OrderBO bo = new OrderBOImpl();

    public void initialize() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllOrders();
    }

    public void filterOnAction(ActionEvent actionEvent) throws Exception {
        OrderDTO dto = bo.getOrder(txtId.getText());
        if(dto !=null){
            txtDate.setText(dto.getDate()+"");
            txtCustId.setText(dto.getCustomerId()+" ");


        } else{
            new Alert(Alert.AlertType.WARNING,"Order Not Found", ButtonType.OK).show();
        }
    }

    private void loadAllOrders() throws Exception {
        ArrayList<OrderDTO> allOrder = bo.getAllOrder();
        ObservableList<OrderTM> obList = FXCollections.observableArrayList();
        obList.clear();
        for (OrderDTO dto:allOrder){
            JFXButton btn= new JFXButton("Delete");
            OrderTM tm=new OrderTM(
                    dto.getId(),
                    dto.getDate(),
                    dto.getCustomerId(),
                    btn);
            obList.add(tm);

            btn.setOnAction(e->{
                ButtonType ok= new ButtonType("OK",
                        ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("NO",
                        ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert= new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Are You Sure whether You Want to Delete This Order?",
                        ok,no);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no)==ok){
                    try {
                        boolean isDeleted = bo.deleteOrder(tm.getId());
                        if (isDeleted){
                            new Alert(Alert.AlertType.CONFIRMATION,"Deleted !",
                                    ButtonType.OK).show();
                            loadAllOrders();
                        }else{
                            new Alert(Alert.AlertType.WARNING,"Try Again !",
                                    ButtonType.OK).show();
                        }
                    } catch (ClassNotFoundException | SQLException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }

            });
        }
        tbl.setItems(obList);

    }
}
