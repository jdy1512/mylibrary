package publisher.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import publisher.service.MainService;
import publisher.vo.Book;
import publisher.vo.Publisher;

public class PublisherMain {
	public static void main(String[] args) {
		MainService service = MainService.getInstance();
		List<Publisher> publisherList = null;
		List<Book> bookList = null;
		
//		// 출판사 sample info
//		Publisher p1 = new Publisher("KOSTA 출판사", "경기도 성남시 분당구 삼평동", "031-1234-5678");
//		Publisher p2 = new Publisher("한국 출판사", "서울시 강남구 청담동", "031-0000-0000");
//		Publisher p3 = new Publisher("책가게", "서울시 송파구 잠실2동", "031-4343-5353");
//		Publisher p4 = new Publisher("만화방", "강원도 철원시 군인동", "031-1234-1111");
//		Publisher p5 = new Publisher("북카페", "경기도 성남시 분당구 수내동 111-1 지하9층", "031-8282-8282");
//		
//		// 출판사 추가
//		service.registPublisher(p1);
//		service.registPublisher(p2);
//		service.registPublisher(p3);
//		service.registPublisher(p4);
//		service.registPublisher(p5);
//		
//		// 출판사 전체 조회 & 출력
//		System.out.println("출판사 전체 조회 & 출력");
//		publisherList = service.searchAllPublishers();
//		service.printList(publisherList);
//		
//		// p2 출판사 주소 조회 & 출력
//		System.out.println("p2 출판사 주소 조회 & 출력");
//		publisherList = service.searchPublishersByAddr(p2.getpAddr().substring(4, 11));
//		service.printList(publisherList);
//		
//		// p2 출판사 정보 변경 & 출력
//		System.out.println("p2 출판사 정보 변경 & 출력");
//		p2.setpName("코리아 출판사 (수정됨)");
//		p2.setpAddr("서울시 강남구 청담동 독서실 뒷방 (수정됨)");
//		service.changePublisherInfo(p2);
//		publisherList = service.searchPublishersByAddr(p2.getpAddr());
//		service.printList(publisherList);
//		
//		System.out.println("******************************************************************");
//
//		// 책 sample info
//		publisherList = service.searchAllPublishers();
//		for (Publisher p : publisherList) {
//			int ran = new Random().nextInt(5) + 1;
//			for (int idx = 0; idx < ran; idx++) {
//				int no = (int)(idx / (ran/3.0)) + 1;
//				String bookCd = "어렵게";
//				
//				if (no == 1) {
//					bookCd = "쉽게";
//				} else if (no == 2) {
//					bookCd = "편하게";
//				} else if (no == 3) {
//					bookCd = "무섭게";
//				} else if (no == 4) {
//					bookCd = "웃으며";
//				}
//				Book book = new Book(
//						"89-" + p.getpNo() + "-" + (idx + 1),
//						bookCd + " 배우는 JAVA " + (idx + 1) + "권",
//						"KOSTA " + no + "강사님",
//						100 * (ran + idx),
//						5000 * (ran + idx),
//						new java.sql.Date(new Date().getTime()),
//						p.getpNo());
//				service.registBook(book);
//			}
//		}
//		
//		// 책 전체 조회 & 출력
//		System.out.println("책 전체 조회 & 출력");
//		bookList = service.searchAllBooks();
//		service.printList(bookList);
//
//		// 저자로 책 조회 & 출력
//		System.out.println("저자로 책 조회 & 출력");
//		bookList = service.searchBooksByAuthor("KOSTA 1강사님");
//		service.printList(bookList);
//		
//		// 'KOSTA 1강사님' 저자로 책 정보 변경 & 출력
//		System.out.println("'KOSTA 1강사님' 저자로 책 정보 변경 & 출력");
//		for (Book book : bookList) {
//			book.setTitle("겁나게 어려운 JAVA 통합본 (수정됨)");
//			service.changeBookInfo(book);
//		}
//		bookList = service.searchBooksByAuthor("KOSTA 1강사님");
//		service.printList(bookList);
//
//		// 출판일 범위로 책 조회 & 출력
//		Date date1 = new GregorianCalendar(2015, 3, 1).getTime();
//		Date date2 = new GregorianCalendar(2016, 3, 1).getTime();
//		System.out.println("출판일 범위로 책 조회 & 출력 (" + new SimpleDateFormat("yyyy-MM-dd").format(date1) + " ~ " + new SimpleDateFormat("yyyy-MM-dd").format(date2) + ")");
//		bookList = service.searchBooksByDate(new java.sql.Date(date1.getTime()), new java.sql.Date(date2.getTime()));
//		service.printList(bookList);
//
//		// ISBN으로 책 조회 (출판사 정보도 조회) & 출력
//		System.out.println("ISBN(" + bookList.get(0).getIsbn() + ")으로 책 조회 (출판사 정보도 조회) & 출력");
//		bookList = service.searchBooksByISBN(bookList.get(0).getIsbn());
//		service.printList(bookList);
//		
//		// p2의 no로 출판사 조회- 그 출판사가 출간한 책 포함 & 출력
//		System.out.println("p2의 no(" + publisherList.get(0).getpNo() + ")로 출판사 조회- 그 출판사가 출간한 책 포함 & 출력");
//		publisherList = service.searchPublishersByNo(publisherList.get(0).getpNo());
//		service.printList(publisherList);

		
		System.out.println("-------------- 키워드로 검색 ---------------");
		publisherList = service.searchPublishersByKeywords(null, "서울", null);
		service.printList(publisherList);
		
		Publisher p = new Publisher();
		p.setpNo(261);
		p.setpName("바뀐 출판사 이름");
		System.out.println(service.changePublisherInfo(p));

		System.out.println("------<choose> 테스트------");
		publisherList = service.searchPublishersByKeyword(null, null);
		service.printList(publisherList);

//		
//		// 모든 출판사 제거
//		publisherList = service.searchAllPublishers();
//		for (Publisher p : publisherList) {
//			service.dropPublisher(p.getpNo());
//		}
//		
//		// 모든 책 제거
//		bookList = service.searchAllBooks();
//		for (Book b : bookList) {
//			service.dropBook(b.getIsbn());
//		}
	}
}
