package publisher.service;

import java.sql.Date;
import java.util.List;

import publisher.common.dao.BookDAO;
import publisher.common.dao.PublisherDAO;
import publisher.vo.Book;
import publisher.vo.Publisher;

public class MainService {
	private static MainService instance = new MainService();
	
	private PublisherDAO publisherDAO;
	private BookDAO bookDAO;

	private MainService() {
		publisherDAO = PublisherDAO.getInstance();
		bookDAO = BookDAO.getInstance();
	}
	
	public static MainService getInstance() {
		return instance;
	}
	
	// 출판사

	// 출판사 추가
	public int registPublisher(Publisher publisher) {
		return publisherDAO.insertPublisher(publisher);
	}
	
	// 출판사 삭제
	public int dropPublisher(int pNo) {
		return publisherDAO.deletePublisherByNo(pNo);
	}
	
	// 출판사 수정
	public int changePublisherInfo(Publisher publisher) {
		return publisherDAO.updatePublisher(publisher);
	}
	
	// 출판사 전체 조회
	public List<Publisher> searchAllPublishers() {
		return publisherDAO.selectAllPublishers();
	}
	
	// 주소로 출판사 조회
	public List<Publisher> searchPublishersByAddr(String pAddr) {
		return publisherDAO.selectPublishersByAddress(pAddr);
	}
	
	// no로 출판사 조회
	public List<Publisher> searchPublishersByNo(int pNo) {
		return publisherDAO.selectPublishersByNo(pNo);
	}
	
	// keyword로 출판사 조회
	public List<Publisher> searchPublishersByKeyword(String pName, String pAddr) {
		return publisherDAO.selectPublishersByKeyword(pName, pAddr);
	}
	
	// keyword로 출판사 조회
	public List<Publisher> searchPublishersByKeywords(String pName, String pAddr, String pTel) {
		return publisherDAO.selectPublishersByKeywords(pName, pAddr, pTel);
	}
	
	// 책
	
	// 책 추가
	public int registBook(Book book) {
		return bookDAO.insertBook(book);
	}
	
	// 책 삭제
	public int dropBook(String isbn) {
		return bookDAO.deleteBookByISBN(isbn);
	}
	
	// 책 수정
	public int changeBookInfo(Book book) {
		return bookDAO.updateBook(book);
	}
	
	// 출판사 전체 조회
	public List<Book> searchAllBooks() {
		return bookDAO.selectAllBooks();
	}
	
	// 저자로 책 조회
	public List<Book> searchBooksByAuthor(String author) {
		return bookDAO.selectBooksByAuthor(author);
	}
	
	// 출판일 범위로 책 조회
	public List<Book> searchBooksByDate(Date date1, Date date2) {
		return bookDAO.selectBooksByDate(new Date[] {date1, date2});
	}
	
	// ISBN으로 책 조회
	public List<Book> searchBooksByISBN(String isbn) {
		return bookDAO.selectBooksByISBN(isbn);
	}
	
	// 리스트 출력
	public <T> void printList(List<T> list) {
		for (T t : list) {
			System.out.println(t);
			if (t instanceof Book) {
				Book book = (Book) t;
				if (book.getPublisher() != null) {
					System.out.println(book.getPublisher());
				}
			}else if (t instanceof Publisher) {
				Publisher publisher = (Publisher) t;
				if (publisher.getBooks() != null) {
					printList(publisher.getBooks());
				}
			}
		}
		System.out.println("------------------------------------------------------------------------------");
	}
}
