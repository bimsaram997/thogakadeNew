package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemBO {
    public boolean saveItem(ItemDTO dto) throws Exception;
    public boolean updateItem(ItemDTO dto) throws Exception;
    public boolean deleteItem(String code) throws Exception;
    public ItemDTO getItem(String code) throws Exception;
    public ArrayList<ItemDTO> getAllItems() throws Exception;
}
