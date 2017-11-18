package service.impl;

import java.util.List;

import service.BusinessService;

import dao.JDBCDao;
import daoImpl.JDBCDaoImpl;
import domain.Customer;
import domain.PageBean;
import domain.QueryInfo;
import domain.QueryResult;
//服务层用来实现业务逻辑
public class BusinessServiceImpl implements BusinessService {
	private JDBCDao dao = new JDBCDaoImpl();
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addCustomer(domain.Customer)
	 */
	@Override
	public void addCustomer(Customer customer){
		dao.add(customer);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#deleteCustomer(java.lang.String)
	 */
	@Override
	public void deleteCustomer(String id){
		dao.delete(id);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#updataCustomer(domain.Customer)
	 */
	@Override
	public void updataCustomer(Customer customer){
		dao.updata(customer);
	} 
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findCustomer(java.lang.String)
	 */
	@Override
	public Customer findCustomer(String id){
		return dao.select(id);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCustomer()
	 */
	@Override
	public List<Customer> getAllCustomer(){
		return dao.getAll();
	}
	
	//将客户请求数据封装到客户数据线束页面
	public PageBean pageQuery(QueryInfo queryInfo){
		QueryResult qr =dao.getQueryResult(queryInfo.getStartindex(),queryInfo.getPagesize());
		
		PageBean bean = new PageBean();
		bean.setCurrentpage(queryInfo.getCurrentPage());
		bean.setList(qr.getList());
		bean.setPagesize(queryInfo.getPagesize());
		bean.setTotalrecord(qr.getTolalrecord());
		return bean;
	}
}
