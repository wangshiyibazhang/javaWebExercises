package domain;

//设计一个用来封装客户请求信息的实体
public class QueryInfo {
	private int currentPage = 1;//当前页，默认为第一页
	private int pagesize = 5;//显示数据大小默认为5条
	private int startindex;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	//索引值是通过当前页和数据大小来获取的
	public int getStartindex() {
		this.startindex =(this.currentPage-1)*this.pagesize;
		return this.startindex;
	}
	
	
}
