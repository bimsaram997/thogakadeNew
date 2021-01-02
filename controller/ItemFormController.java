package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.bo.custom.impl.ItemBOImpl;
import lk.ijse.thogakade.dao.DataBaseAccessCode;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.view.tm.CustomerTM;
import lk.ijse.thogakade.view.tm.ItemTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ItemFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField textSearch;
    public JFXButton btnSave;
    public TableView <ItemTM>tbl;
    public TableColumn colCode;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colOperate;
    public TextField txtUnitPrice;
    public TextField txtQTYOnHand;

    ItemBO bo =  new ItemBOImpl();

    public void initialize() throws Exception {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllItems();

    }

    private void loadAllItems() throws Exception {
        ArrayList<ItemDTO> allItems = bo.getAllItems();
        ObservableList<ItemTM> obList =FXCollections.observableArrayList();
        obList.clear();
        for (ItemDTO dto:allItems){
            JFXButton btn= new JFXButton("Delete");
            ItemTM tm=new ItemTM(
                    dto.getCode(),
                    dto.getDescription(),
                    dto.getUnitPrice(),
                    dto.getQtyOnHand(),
                    btn);
            obList.add(tm);

            btn.setOnAction(e->{
                ButtonType ok= new ButtonType("OK",
                        ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("NO",
                        ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert= new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Are You Sure whether You Want to Delete This Item?",
                        ok,no);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no)==ok){
                    try {
                        boolean isDeleted = bo.deleteItem(tm.getCode());
                        if (isDeleted){
                            new Alert(Alert.AlertType.CONFIRMATION,"Deleted !",
                                    ButtonType.OK).show();
                            loadAllItems();
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


    public void filterOnAction(ActionEvent actionEvent) throws Exception {
        ItemDTO  dto = bo.getItem(txtCode.getText());
        if(dto !=null){
            txtDescription.setText(dto.getDescription());
            txtUnitPrice.setText(dto.getUnitPrice()+"");
            txtQTYOnHand.setText(dto.getQtyOnHand()+"");

        } else{
            new Alert(Alert.AlertType.WARNING,"Item Not Found", ButtonType.OK).show();
        }
    }

    public void searchOnAction(KeyEvent keyEvent) {
    }

    public boolean saveAndUpdateOnAction(ActionEvent actionEvent) throws Exception {
        if (btnSave.getText().equalsIgnoreCase("Save")){
            //Save
            ItemDTO dto = new ItemDTO(
                    txtCode.getText(),
                    txtDescription.getText(),
                    Double.parseDouble(txtUnitPrice.getText()),
                    Integer.parseInt(txtQTYOnHand.getText())
            );
            boolean isSaved = bo.saveItem(dto);
            System.out.println(isSaved);



        }else{
            //update
        }

        return false;
    }

    public void newOnAction(ActionEvent actionEvent) {
    }
}
