package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs.dto.Title;

public class TitleMapperImpl implements TitleMapper {
	private String nameSpace = "kr.or.dgit.ncs.mappers.TitleMapper"; //StudentMapper.xml�쓽 namespace
	private SqlSession sqlSession;
	
	private static final Log log = LogFactory.getLog(EmployeeMapperImpl.class);
	
	public TitleMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertTitle(Title title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTitle(Title title) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTitle(Title title) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Title> selectTitleByAll() {
		log.debug("============== selectTitleByAll() ==============");
		return sqlSession.selectList(nameSpace+".select");
	}

	@Override
	public String getLastTitleCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Title selectTitleByNo(Map<String, Object> param) {
		log.debug("============== selectTitleByNo() ==============");
		return sqlSession.selectOne(".selectOne", param);
	}

}
