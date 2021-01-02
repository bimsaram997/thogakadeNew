package lk.ijse.thogakade.bo.custom;

import lk.ijse.thogakade.dto.OrderDTO;

import java.util.ArrayList;

public interface OrderBO {
    public boolean saveOrder(OrderDTO dto) throws Exception;
    public boolean updateOrder(OrderDTO dto) throws Exception;
    public boolean deleteOrder(String id) throws Exception;
    public OrderDTO getOrder(String id) throws Exception;
    public ArrayList<OrderDTO> getAllOrder() throws Exception;
}
