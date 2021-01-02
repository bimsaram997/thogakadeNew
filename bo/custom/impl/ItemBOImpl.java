package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.ItemBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dao.custom.ipml.ItemDAOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO dao = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);
    @Override
    public boolean saveItem(ItemDTO dto) throws Exception {
        return dao.save(new Item(dto.getCode(),dto.getDescription(),
                dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        return dao.delete(code);
    }

    @Override
    public ItemDTO getItem(String code) throws Exception {
        Item i = dao.get(code);
        return new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand());
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<Item> all = dao.getAll();
        ArrayList<ItemDTO> list= new ArrayList<>();
        for (Item i:all
        ) {
            list.add(
                    new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand())
            );
        }
        return list;
    }
}
