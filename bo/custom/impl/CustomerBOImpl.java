package lk.ijse.thogakade.bo.custom.impl;

import lk.ijse.thogakade.bo.custom.CustomerBO;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dao.custom.ipml.CustomerDAOImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO dao = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return dao.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws Exception {
        Customer c = dao.get(id);
        return new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {

        ArrayList<Customer> all = dao.getAll();
        ArrayList<CustomerDTO> list= new ArrayList<>();
        for (Customer c:all
        ) {
            list.add(
                    new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getSalary())
            );
        }
        return list;
    }
}
