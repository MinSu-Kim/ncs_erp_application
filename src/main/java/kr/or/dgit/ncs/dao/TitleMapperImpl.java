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
	public int insertTitle(Title title) {
		log.debug("============== insertTitle() ==============");
		return sqlSession.insert(nameSpace+".insert", title);
	}

	@Override
	public int updateTitle(Title title) {
		log.debug("============== updateTitle() ==============");
		return sqlSession.update(nameSpace+".update", title);
	}

	@Override
	public int deleteTitle(Title title) {
		log.debug("============== deleteTitle() ==============");
		return sqlSession.delete(nameSpace+".delete", title);
	}

	@Override
	public List<Title> selectTitleByAll() {
		log.debug("============== selectTitleByAll() ==============");
		return sqlSession.selectList(nameSpace+".select");
	}

	@Override
	public int getLastTitleCode() {
		log.debug("============== getLastTitleCode() ==============");
		return sqlSession.selectOne(nameSpace+".lastNum");
	}

	@Override
	public Title selectTitleByNo(Map<String, Object> param) {
		log.debug("============== selectTitleByNo() ==============");
		return sqlSession.selectOne(nameSpace+".selectOne", param);
	}

}
