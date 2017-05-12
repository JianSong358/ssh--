package main.java.com.hj.shop.utils;

import java.util.List;

import main.java.com.hj.shop.entity.Product;

/**
 * 分页信息类的封装
 * @author hj
 *
 */
public class PageBean<T> {

	private int currentPage;	//当前页数
	private int totalCount;		//总的记录数
	private int totalPage;		//总的页数
	private int limit;			//每页要显示的记录数
	private List<T> list; //每页显示的数据集合
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
