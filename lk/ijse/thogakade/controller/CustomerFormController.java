package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.bo.custom.impl.CustomerBOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.view.tm.CustomerTM;

import java.util.ArrayList;
import java.util.Optional;

public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TextField txtSearch;
    public JFXButton btnSave;
    public TableView <CustomerTM> tbl;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperate;

    CustomerBO bo = new CustomerBOImpl();

    public void initialize() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAllCustomers();
    }

    private void loadAllCustomers() throws Exception {
        ArrayList<CustomerDTO> allCustomers = bo.getAllCustomers();
        ObservableList<CustomerTM> obList =FXCollections.observableArrayList();
        obList.clear();
        for (CustomerDTO dto:allCustomers){
            JFXButton btn= new JFXButton("Delete");
            CustomerTM tm=new CustomerTM(
                    dto.getId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getSalary(),
                    btn);
            obList.add(tm);

            btn.setOnAction(e->{
                ButtonType ok= new ButtonType("OK",
                        ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("NO",
                        ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert= new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Are You Sure whether You Want to Delete This Customer?",
                        ok,no);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no)==ok){
                    try {
                        boolean isDeleted = bo.deleteCustomer(tm.getId());
                        if (isDeleted){
                            new Alert(Alert.AlertType.CONFIRMATION,"Deleted !",
                                    ButtonType.OK).show();
                            loadAllCustomers();
                        }else{
                            new Alert(Alert.AlertType.WARNING,"Try Again !",
                                    ButtonType.OK).show();
                        }
                    } catch (Exception classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }

                }

            });
        }
        tbl.setItems(obList);
    }

    public void searchOnAction(KeyEvent keyEvent) {
    }

    public void filterOnAction(ActionEvent actionEvent) throws Exception {
        CustomerDTO  dto =bo.getCustomer(txtId.getText());
        if(dto !=null){
            txtName.setText(dto.getName());
            txtAddress.setText(dto.getAddress());
            txtSalary.setText(dto.getSalary()+"");

        } else{
            new Alert(Alert.AlertType.WARNING,"Customer Not Found", ButtonType.OK).show();
        }
    }

    public boolean saveUpdateOnAction(ActionEvent actionEvent) throws Exception {
        if (btnSave.getText().equalsIgnoreCase("Save")){
            //Save
            CustomerDTO dto = new CustomerDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );
            boolean isSaved = bo.saveCustomer(dto);
            System.out.println(isSaved);



        }else{
            //update
        }

        return false;
    }

    public void newOnAction(ActionEvent actionEvent) {
    }
}
