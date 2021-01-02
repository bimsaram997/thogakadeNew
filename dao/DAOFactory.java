package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.ipml.CustomerDAOImpl;
import lk.ijse.thogakade.dao.custom.ipml.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.ipml.OrderDAOImpl;

public class DAOFactory {
    private static  DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?(daoFactory = new DAOFactory()): daoFactory;
    }
    public enum DAOType{
        CUSTOMER, ITEM, ORDER
    }
    public <T> T getDAO(DAOType type){
        switch (type){
            case ITEM:
                return (T) new ItemDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case ORDER:
                return (T) new OrderDAOImpl();
            default:
                return null;
        }
    }
}
