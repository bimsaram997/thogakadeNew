package lk.ijse.thogakade.dao.custom.ipml;

import lk.ijse.thogakade.dao.CrudUtil;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public Item get(String code) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Item WHERE code =?",code);
        //-------
        if(set.next()){
            return new Item(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getInt(4)

            );
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM Item");
        //------------------
        ArrayList<Item> itemList=new ArrayList();
        while (set.next()){
            itemList.add(new Item(set.getString(1),
                    set.getString(2),set.getDouble(3),
                    set.getInt(4)
            ));
        }
        return itemList;
    }
}
