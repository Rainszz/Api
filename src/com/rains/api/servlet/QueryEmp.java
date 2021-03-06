package com.rains.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.rains.api.bean.Emp;
import com.rains.api.bean.Result;
import com.rains.api.dao.EmpMapper;
import com.rains.api.utils.JsonMananger;

/**
 * Servlet implementation class QueryEmp
 */
@WebServlet("/queryEmp")
public class QueryEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通过配置文件构建SqlSessionFactory对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
		// 通过SqlSessionFactory对象来打开获取SqlSession对象
		SqlSession sqlSession = sessionFactory.openSession();
		// 通过sqlSession对象来获取Mapper对象
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		// 声明并实例化数据传输对象result
		Result<List<Emp>> result = new Result<>();
		List<Emp> list = null;
		try {
			// 通过Mapper对象发送sql语句，并执行，获取返回的结果
			list = empMapper.queryAll();
			result.setCode(200);
			result.setMsg("请求成功!");
			result.setResult(list);
		} catch (Exception e) {
			result.setCode(400);
			result.setMsg("请求失败!");
			result.setResult(list);

		}
		sqlSession.commit();

		String jsonStr = JsonMananger.beanToJson(result);
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
