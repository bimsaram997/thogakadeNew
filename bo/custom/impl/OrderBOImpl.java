package lk.ijse.thogakade.bo.custom.impl;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lk.ijse.thogakade.bo.custom.OrderBO;
import lk.ijse.thogakade.dao.DAOFactory;

import lk.ijse.thogakade.dao.custom.OrderDAO;

import lk.ijse.thogakade.dto.OrderDTO;

import lk.ijse.thogakade.entity.Order;

import java.util.ArrayList;

public class OrderBOImpl implements OrderBO {

    OrderDAO dao = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ORDER);

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrder(OrderDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) throws Exception {

        return dao.delete(id);
    }

    @Override
    public OrderDTO getOrder(String id) throws Exception {
        Order o = dao.get(id);
        return new OrderDTO(o.getId(),o.getDate(),o.getCustomerId());
    }

    @Override
    public ArrayList<OrderDTO> getAllOrder() throws Exception {
        ArrayList<Order> all = dao.getAll();
        ArrayList<OrderDTO> list= new ArrayList<>();
        for (Order o:all
        ) {
            list.add(
                    new OrderDTO(o.getId(),o.getDate(),o.getCustomerId())
            );
        }
        return list;
    }
}
