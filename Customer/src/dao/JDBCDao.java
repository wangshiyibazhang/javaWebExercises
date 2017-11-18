package dao;

import java.util.List;

import domain.Customer;
import domain.QueryResult;

public interface JDBCDao {

	public abstract void add(Customer c);

	public abstract void updata(Customer c);

	public abstract void delete(String id);

	public abstract Customer select(String id);

	public abstract List<Customer> getAll();
	public QueryResult getQueryResult(int startindex,int pagesize);

}