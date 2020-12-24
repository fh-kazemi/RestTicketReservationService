package ticket.service;

import ticket.model.entity.Customer;
import ticket.repository.CustomerDao;

import java.util.Objects;

public class CustomerService {
    CustomerDao customerDao = new CustomerDao();

    public void addNewCustomer(Customer customer) throws Exception {
        if (Objects.nonNull(customer)) {
            customerDao.create(customer);
        }else{
            throw new Exception(BizException.customerException);
        }

    }

    public int preparedCustomerId() {
        return PreparedIdService.prepareId(0,10000);
    }
}
