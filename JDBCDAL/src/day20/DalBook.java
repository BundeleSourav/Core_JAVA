package day20;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import day20.Book;
import day20.IOUtils;
import day20.BookDal;

public class DalBook implements BookDal  {
	
	private Connection con;
	private PreparedStatement p1,p2,p3;
	
	public DalBook() throws ClassNotFoundException, SQLException
	{
		con=IOUtils.getconnectionto();
		
		p1=con.prepareStatement("insert into books values(?,?,?,?)");
		p2=con.prepareStatement("update books set title=?,author=?,price=? where bookid=?");
		p3=con.prepareStatement("select * from book where bookid=?");
	}
	
	@Override
	public String addBook(Book obj)
	{
		try
		{
			p1.setInt(1, obj.getId());
			p1.setString(2, obj.getTitle());
			p1.setString(3, obj.getAuthor());
			p1.setDouble(4, obj.getPrice());
			
			int i=p1.executeUpdate();
			if(i>0)
				return "Updated: ";
			else
				return null;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getallBook() throws SQLException {
		List<Book> allbooks=new ArrayList<>();
		String str="select 8 from books";
		Statement st;
		try
		{
			st=con.createStatement();
			ResultSet rset=st.executeQuery(str);
			while(rset.next())
			{
				allbooks.add(new Book(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getDouble(4)));
			}
			rset.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookbyid(int bookid) {
		try
		{
			p3.setInt(1, bookid);
			ResultSet rset = p3.executeQuery();
			if(rset.next())
				return new Book(rset.getInt("id"),rset.getString("title"),rset.getString("author"),rset.getDouble("price"));
			
			else
				return null;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateBook(Book obj) throws SQLException {
		CallableStatement cst=con.prepareCall("call updatebook(?,?,?,?)");
		cst.setInt(1,obj.getId());
		cst.setString(2, obj.getTitle());
		cst.setString(3, obj.getAuthor());
		cst.setDouble(4, obj.getPrice());
		int i=cst.executeUpdate();
		if(i>0)
			return "Updated:-";
		else 
			return null;
		return null;
	}
}
