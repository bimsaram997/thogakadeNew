package lk.ijse.thogakade.dao.custom.ipml;

import lk.ijse.thogakade.dao.CrudUtil;
import lk.ijse.thogakade.dao.custom.OrderDAO;

import lk.ijse.thogakade.entity.Order;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean save(Order order) throws Exception {
        return false;
    }

    @Override
    public boolean update(Order order) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.execute("DELETE FROM Orders WHERE id=?",id);
    }

    @Override
    public Order get(String id) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Orders WHERE id =?",id);
        //-------
        if(set.next()){
            return new Order(
                    set.getString(1),
                    set.getDate(2),
                    set.getString(3)

            );
        }
        return null;
    }

    @Override
    public ArrayList<Order> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Orders");
        //------------------
        ArrayList<Order> orderList=new ArrayList();
        while (set.next()){
            orderList.add(new Order(set.getString(1),
                    set.getDate(2),set.getString(3)

            ));
        }
        return orderList;
    }
}
