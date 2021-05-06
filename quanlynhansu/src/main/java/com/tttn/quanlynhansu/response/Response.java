package com.tttn.quanlynhansu.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
	private T object;
	private List<T> list;
	private Long totalItem;
	
	public Response(T object, List<T> list) {
		super();
		this.object = object;
		this.list = list;
	}
	
	public Response(T object, List<T> list, Long total) {
		super();
		this.object = object;
		this.list = list;
		this.totalItem = total;
	}
	
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public Long getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}
	
	
}
