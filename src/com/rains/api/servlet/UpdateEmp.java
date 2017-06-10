package com.rains.api.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/updateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 通过配置文件构建SqlSessionFactory对象
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
		// 通过SqlSessionFactory对象来打开获取SqlSession对象
		SqlSession sqlSession = sessionFactory.openSession();
		// 通过sqlSession对象来获取Mapper对象
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		Result<String> result = new Result<>();
		try {
			// 通过Mapper对象发送sql语句，并执行，获取返回的结果 int类型密码不需要引号
			Emp emp =new Emp(7,"10086","嗷大喵","猫");
			empMapper.updateEmp(emp);
			
			result.setCode(200);
			result.setMsg("请求成功!");
			result.setResult("更新成功!");
		} catch (Exception e) {
			result.setCode(400);
			result.setMsg("请求失败!");
			result.setResult("更新失败!");
		}
		sqlSession.commit();

		String jsonStr = JsonMananger.beanToJson(result);
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
