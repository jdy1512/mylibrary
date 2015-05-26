package publisher.vo;

import java.io.Serializable;
import java.util.List;

public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pNo;
	private String pName;
	private String pAddr;
	private String pTel;
	private List<Book> books;

	public Publisher() {
	}

	public Publisher(int pNo, String pName, String pAddr, String pTel) {
		this.pNo = pNo;
		this.pName = pName;
		this.pAddr = pAddr;
		this.pTel = pTel;
	}

	public Publisher(int pNo, String pName, String pAddr, String pTel,
			List<Book> books) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pAddr = pAddr;
		this.pTel = pTel;
		this.books = books;
	}

	public Publisher(String pName, String pAddr, String pTel) {
		this.pName = pName;
		this.pAddr = pAddr;
		this.pTel = pTel;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAddr() {
		return pAddr;
	}

	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}

	public String getpTel() {
		return pTel;
	}

	public void setpTel(String pTel) {
		this.pTel = pTel;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [pNo=" + pNo + ", pName=" + pName + ", pAddr="
				+ pAddr + ", pTel=" + pTel + "]";
	}

}
