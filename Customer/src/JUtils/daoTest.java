package JUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import dao.JDBCDao;
import daoImpl.JDBCDaoImpl;
import domain.Customer;

public class daoTest {
	@Test
	public void testAdd(){
		JDBCDaoImpl dao = new JDBCDaoImpl();
		Customer c = new Customer();
		c.setId("1");
		c.setName("张1");
		c.setGender("男");
		c.setBirthday(new Date());
		c.setCellphone("123124");
		c.setEmail("aa@sina.com");
		c.setPreference("sing");
		c.setType("重要客户");
		c.setDescription("这是一个好人");
		dao.add(c);
	}
	
	@Test
	public void testUpdata(){
		JDBCDaoImpl dao = new JDBCDaoImpl();
		Customer c = new Customer();
		c.setId("3");
		c.setName("ccc");
		c.setGender("meal");
		c.setBirthday(new Date());
		c.setCellphone("123124");
		c.setEmail("cc@sina.com");
		c.setPreference("dance");
		c.setType("ordiral");
		c.setDescription(" good man");
		//dao.updata(c);
		dao.add(c);
	}
	
	@Test
	public void testDelete(){
		JDBCDaoImpl dao = new JDBCDaoImpl();
		String id = "1";
		dao.delete(id);
	}
	@Test
	public void testSelect(){
		JDBCDaoImpl dao = new JDBCDaoImpl();
		String id = "2";
		Customer c =dao.select(id);
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getEmail());
		
	}
	
	@Test
	public void testGetAll(){
		JDBCDao dao = new JDBCDaoImpl();
		List list = dao.getAll();
		Iterator<Customer> it = list.iterator();
		while(it.hasNext()){
			Customer c = it.next();
			System.out.println(c.getId()+"-->"+c.getName());
		}
	}
}
