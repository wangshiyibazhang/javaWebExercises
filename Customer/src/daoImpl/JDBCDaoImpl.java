package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Exception.SQLException;
import Utils.DaoUtils;
import dao.JDBCDao;
import domain.Customer;
import domain.QueryResult;

public class JDBCDaoImpl implements JDBCDao {
	/* (non-Javadoc)
	 * @see daoImpl.JDBCDao#add(domain.Customer)
	 */
	
	//添加客户给数据库中
	@Override
	public  void add(Customer c){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DaoUtils.getConnextion();
			//System.out.println("connection succeed!");
			String sql ="insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1,c.getId());
			st.setString(2,c.getName());
			st.setString(3,c.getGender());
			//将Date类进行强转
			st.setDate(4,new java.sql.Date(c.getBirthday().getTime()));
			st.setString(5,c.getCellphone());
			st.setString(6,c.getEmail());
			st.setString(7,c.getPreference());
			st.setString(8,c.getType());
			st.setString(9,c.getDescription());
			st.executeUpdate();
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			DaoUtils.closeAll(null, st, conn);
		}
	}
	/* (non-Javadoc)
	 * @see daoImpl.JDBCDao#updata(domain.Customer)
	 */
	
	//更新客户数据
	@Override
	public  void updata(Customer c){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DaoUtils.getConnextion();
			String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=? ";
			st = conn.prepareStatement(sql);
			st.setString(1,c.getName());
			st.setString(2,c.getGender());
			st.setDate(3,new java.sql.Date(c.getBirthday().getTime()));
			st.setString(4,c.getCellphone());
			st.setString(5,c.getEmail());
			st.setString(6,c.getPreference());
			st.setString(7,c.getType());
			st.setString(8,c.getDescription());
			st.setString(9,c.getId());
			st.executeUpdate();
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			DaoUtils.closeAll(null, st, conn);
		}
	}
	/* (non-Javadoc)
	 * @see daoImpl.JDBCDao#delete(java.lang.String)
	 */
	
	//通过客户id删除客户
	@Override
	public  void delete(String id){
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DaoUtils.getConnextion();
			String sql = " delete  from customer where id=?";
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}finally{
			DaoUtils.closeAll(null, st, conn);
		}
	}
	/* (non-Javadoc)
	 * @see daoImpl.JDBCDao#select(java.lang.String)
	 */
	
	//通过id查询指定客户
	@Override
	public  Customer select(String id){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DaoUtils.getConnextion();
			String sql = "select * from customer where id =?";
			st = conn.prepareStatement(sql);
			st.setString(1,id);
			rs = st.executeQuery();
			if(rs.next()){
				Customer c = new Customer();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				return c;
			}
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			DaoUtils.closeAll(rs, st, conn);
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see daoImpl.JDBCDao#getAll()
	 */
	
	//查询所有客户并装在一个list集合中
	@Override
	public  List<Customer> getAll(){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList();
		try {
			conn = DaoUtils.getConnextion();
			String sql = "select * from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			DaoUtils.closeAll(rs, st, conn);
		}
		return list;
	}
	
	//通过sql的limit语句将客户数据实现分页
	public QueryResult getQueryResult(int startindex,int pagesize){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//实例化一个用于封装结果的对象
		QueryResult qr = new QueryResult();
		//将每一个对象转在list集合中
		List<Customer> list = new ArrayList();
		try {
			conn = DaoUtils.getConnextion();
			String sql = "select * from customer limit ?,?";
			st = conn.prepareStatement(sql);
			//第一个数据是开始索引值
			st.setInt(1,startindex );
			//第二个数据是数值大小
			st.setInt(2, pagesize);
			rs = st.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
			qr.setList(list);
			
			//统计所有客户个数
			String sql1 ="select count(*) from customer";
			st = conn.prepareStatement(sql1);
			rs = st.executeQuery();
			if(rs.next())qr.setTolalrecord(rs.getInt(1));
			return qr;
		} catch (Exception e) {
			throw new SQLException(e);
		}finally{
			DaoUtils.closeAll(rs, st, conn);
		}
	}
}
