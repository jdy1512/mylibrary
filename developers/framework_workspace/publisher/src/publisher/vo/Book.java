package publisher.vo;

import java.util.Date;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private int page;
	private int price;
	private Date pDate;
	private int pNo;
	private Publisher publisher;

	public Book() {
	}

	public Book(String isbn, String title, String author, int page, int price,
			Date pDate, int pNo) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.page = page;
		this.price = price;
		this.pDate = pDate;
		this.pNo = pNo;
	}

	public Book(String isbn, String title, String author, int page, int price,
			Date pDate, int pNo, Publisher publisher) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.page = page;
		this.price = price;
		this.pDate = pDate;
		this.pNo = pNo;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", page=" + page + ", price=" + price + ", pDate=" + pDate
				+ ", pNo=" + pNo + "]";
	}

}
