package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.ncs.dto.Title;

public interface TitleMapper {
	public int insertTitle(Title title);
	public int updateTitle(Title title);
	public int deleteTitle(Title title);
	public List<Title> selectTitleByAll();
	public int getLastTitleCode();
	public Title selectTitleByNo(Map<String, Object> param);
}
