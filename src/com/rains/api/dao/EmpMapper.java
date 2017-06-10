package com.rains.api.dao;

import java.util.List;

import com.rains.api.bean.Emp;

public interface EmpMapper {
	/*
	 * 查询所有
	 */
	public List<Emp> queryAll();
	
	/*
	 * 添加员工
	 */
	public void addEmp(Emp emp);

	/*
	 * 删除员工
	 */
	public void deleteEmp(int u_id);
	
	/*
	 * 修改信息
	 */
	public void updateEmp(Emp emp);

}
