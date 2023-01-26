package day20;
import java.sql.SQLException;
import java.util.List;

import day20.IOUtils;
public interface BookDal {
	
	List<Book>getallBook() throws SQLException;
	
	String addBook(Book b) throws SQLException;
	
	Book getBookbyid(int bookid);
	
	String updateBook() throws SQLException;

}
