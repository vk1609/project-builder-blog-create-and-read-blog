package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface{
	public void insertBlog(Blog blog) throws Exception{
	
		Connection con = ConnectionManager.getConnection();
		String sql="insert into blog(ID,BLOG_TITLE,BLOG_DESCRIPTION,DATE_POSTED)values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, blog.getBlogId());
		st.setString(2, blog.getBlogTitle());
		st.setString(3, blog.getBlogDescription());
		st.setDate(4, java.sql.Date.valueOf(blog.getPostedOn()));
		
		st.executeQuery();
		con.close();
		
	}
	public List<Blog> selectAllBlogs() throws SQLException, IOException{
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * from BLOG");
		List<Blog> list = new ArrayList<Blog>();
		
		while(rs.next())
		{
			
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String desc = rs.getString("DESCRIPTION");
			Date date = rs.getDate("DATE1"); 
			
			Blog blog = new Blog();
			blog.setBlogId(id);
			blog.setBlogTitle(title);
			blog.setBlogDescription(desc);
			
//			LocalDate date1 = date.toLocalDate();
//			blog.setPostedOn(date1);
			list.add(blog);
			ConnectionManager.getConnection().close();
		}
		return list;
	
	} 
}