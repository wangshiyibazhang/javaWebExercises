package service;

import java.util.List;

import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;

public interface BusinessService {

	public abstract void addCustomer(Customer customer);

	public abstract void deleteCustomer(String id);

	public abstract void updataCustomer(Customer customer);

	public abstract Customer findCustomer(String id);

	public abstract List<Customer> getAllCustomer();
	
	public PageBean pageQuery(QueryInfo queryInfo);

}