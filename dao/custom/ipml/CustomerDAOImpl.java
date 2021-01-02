package lk.ijse.thogakade.dao.custom.ipml;

import lk.ijse.thogakade.dao.CrudUtil;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {// Alt+ Enter

    @Override
    public boolean save(Customer customer) throws Exception {

        return CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?)",customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public Customer get(String id) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Customer WHERE id =?",id);
        //---------------
        if (set.next()){
            return new Customer(set.getString(1),
                    set.getString(2),set.getString(3),
                    set.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {

        ResultSet set = CrudUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> customerList=new ArrayList();
        while (set.next()){
            customerList.add(new Customer(set.getString(1),
                    set.getString(2),set.getString(3),
                    set.getDouble(4)
            ));
        }
        return customerList;
    }
}
