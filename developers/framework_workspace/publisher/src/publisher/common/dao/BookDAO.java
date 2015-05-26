package publisher.common.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import publisher.common.manager.DatabaseManager;
import publisher.vo.Book;
import publisher.vo.Publisher;

public class BookDAO {
	private static BookDAO instance = new BookDAO();

	private String namespace = "book.";

	private BookDAO() {}

	public static BookDAO getInstance() {
		return instance;
	}

	public int insertBook(Book book) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.insert(namespace + "insertBook", book);
			session.commit();

			return result;
		} finally {
			session.close();
		}
	}
	
	public int deleteBookByISBN(String isbn) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.delete(namespace + "deleteBookByISBN", isbn);
			session.commit();
			
			return result;
		} finally {
			session.close();
		}
	}
	
	public int updateBook(Book book) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.update(namespace + "updateBook", book);
			session.commit();
			
			return result;
		} finally {
			session.close();
		}
	}
	
	public List<Book> selectAllBooks() {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectAllBooks");
		} finally {
			session.close();
		}
	}
	
	public List<Book> selectBooksByAuthor(String author) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectBooksByAuthor", author);
		} finally {
			session.close();
		}
	}
	
	public List<Book> selectBooksByDate(Date[] dates) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectBooksByDate", dates);
		} finally {
			session.close();
		}
	}
	
	public List<Book> selectBooksByISBN(String isbn) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectBooksByISBN", isbn);
		} finally {
			session.close();
		}
	}

}
