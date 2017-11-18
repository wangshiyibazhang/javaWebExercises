package domain;

import java.util.List;

//设计一个用来封装数据库中数据的实体，
public class QueryResult {
	private int tolalrecord;//总记录数
	private List list;//封装客户的list集合
	public int getTolalrecord() {
		return tolalrecord;
	}
	public void setTolalrecord(int tolalrecord) {
		this.tolalrecord = tolalrecord;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
