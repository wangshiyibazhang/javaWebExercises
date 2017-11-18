package domain;

import java.util.List;
//设计一个用来封装jsp页面显示数据的一个实体
public class PageBean {
	private int totalrecord;//总记录数
	private int pagesize;//页面数据
	private int totalpage;//总页数
	private int currentpage;//当前页
	private int previouspage;//上一页
	private int nextpage;//下一页
	private int pageBar[];//数据条
	private List list;//用来封装客户的list集合
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	//总页数是通过总记录数和页面大小求出来的
	public int getTotalpage() {
		if(this.totalrecord%this.pagesize==0){
			this.totalpage=this.totalrecord/this.pagesize;
		}else{
			this.totalpage=this.totalrecord/this.pagesize+1;
		}
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	
	//上一页是通过当前页获取
	public int getPreviouspage() {
		if(this.currentpage-1<0){
			this.previouspage=1;
		}else{
			this.previouspage=this.currentpage-1;
		}
		return previouspage;
	}
	
	//下一个也是通过当前页获取
	public int getNextpage() {
		if(this.currentpage+1>this.totalpage){
			this.nextpage=this.totalpage;
		}else{
			this.nextpage=this.currentpage+1;
		}
		return nextpage;
	}
	
	
	
	//数据条是通过总页数和当前页获取
	public int[] getPageBar() {
		
		int pageBar[] = new int[10];
		int startpage;
		int endpage;
		
		if(this.totalpage<10){
			startpage = 1;
			endpage=10;
		}else{
			startpage = this.currentpage-4;
			endpage = this.currentpage+5;
			
			if(startpage<1){
				startpage=1;
				endpage=10;
			}
			
			
			if(endpage>this.totalpage){
				startpage =this.totalpage-9;
				endpage = this.totalpage;
			}
		}
		
		int index=0;
		for(int i=startpage;i<=endpage;i++){
			pageBar[index++]=i;
		}
		
		this.pageBar=pageBar;
		
		/*int pageBar[] = new int[this.totalpage];
		for(int i=1;i<=this.totalpage;i++){
			pageBar[i-1]=i;
		}
		this.pageBar=pageBar;*/
		return this.pageBar;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
