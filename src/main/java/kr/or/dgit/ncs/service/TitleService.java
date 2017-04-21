package kr.or.dgit.ncs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dao.TitleMapper;
import kr.or.dgit.ncs.dao.TitleMapperImpl;
import kr.or.dgit.ncs.dto.Title;
import kr.or.dgit.ncs.jdbc.MyBatisSqlSessionFactory;

public class TitleService {
	private static TitleService instance = new TitleService();
	
	private TitleService() {}

	public static TitleService getInstance() {
		return instance;
	}
	
	public int getLastCode(){
		int lastCode = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			lastCode = titleMapper.getLastTitleCode();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lastCode;
	}
	
	public void insertTitle(Title title){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			titleMapper.insertTitle(title);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateTitle(Title title){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			titleMapper.updateTitle(title);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteTitle(Title title){
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			titleMapper.deleteTitle(title);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Title> selectList() {
		List<Title> lists = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			lists = titleMapper.selectTitleByAll();
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists;
	}
	
	public Title selectOne(int empCode) {
		Title title = null;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("tcode", empCode);
			title =  titleMapper.selectTitleByNo(parameters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return title;
	}
}
