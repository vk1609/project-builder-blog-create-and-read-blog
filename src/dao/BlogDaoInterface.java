package dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface{
	void insertBlog(Blog blog) throws IOException, SQLException, Exception;
	List selectAllBlogs() throws SQLException, Exception;
}