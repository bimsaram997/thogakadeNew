package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.entity.Customer;

import java.util.ArrayList;

public interface CrudDAO <T, Id> {
    public boolean save(T t) throws Exception;
    public boolean update(T t) throws Exception;
    public boolean delete(Id id) throws Exception;
    public T get(Id id) throws Exception;
    public ArrayList<T> getAll() throws  Exception;


}
