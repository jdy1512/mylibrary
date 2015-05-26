package publisher.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import publisher.common.manager.DatabaseManager;
import publisher.vo.Publisher;

public class PublisherDAO {
	private static PublisherDAO instance = new PublisherDAO();

	private String namespace = "publisher.";
	
	private PublisherDAO() {}
	
	public static PublisherDAO getInstance() {
		return instance;
	}
	
	public int insertPublisher(Publisher publisher) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.insert(namespace + "insertPublisher", publisher);
			session.commit();
			
			return result;
		} finally {
			session.close();
		}
	}
	
	public int deletePublisherByNo(int pNo) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.delete(namespace + "deletePublisherByNo", pNo);
			session.commit();
			
			return result;
		} finally {
			session.close();
		}
	}
	
	public int updatePublisher(Publisher publisher) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			int result = session.update(namespace + "updatePublisher", publisher);
			session.commit();
			
			return result;
		} finally {
			session.close();
		}
	}
	
	public List<Publisher> selectAllPublishers() {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectAllPublishers");
		} finally {
			session.close();
		}
	}
	
	public List<Publisher> selectPublishersByAddress(String pAddr) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectPublishersByAddress", pAddr);
		} finally {
			session.close();
		}
	}
	
	public List<Publisher> selectPublishersByNo(int pNo) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			return session.selectList(namespace + "selectPublishersByNo", pNo);
		} finally {
			session.close();
		}
	}
	
	public List<Publisher> selectPublishersByKeyword(String pName, String pAddr) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			Map<String, String> keywords = new HashMap<String, String>();
			keywords.put("pName", pName);
			keywords.put("pAddr", pAddr);
			return session.selectList(namespace + "selectPublishersByKeyword", keywords);
		} finally {
			session.close();
		}
	}
	
	public List<Publisher> selectPublishersByKeywords(String pName, String pAddr, String pTel) {
		SqlSession session = DatabaseManager.getInstance().getSession();
		try {
			Map<String, String> keywords = new HashMap<String, String>();
			keywords.put("pName", pName);
			keywords.put("pAddr", pAddr);
			keywords.put("pTel", pTel);
			return session.selectList(namespace + "selectPublishersByKeywords", keywords);
		} finally {
			session.close();
		}
	}
}
