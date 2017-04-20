package kr.or.dgit.ncs.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.ncs.dto.Title;

public interface TitleMapper {
	public void insertTitle(Title title);
	public void updateTitle(Title title);
	public void deleteTitle(Title title);
	public List<Title> selectTitleByAll();
	public String getLastTitleCode();
	public Title selectTitleByNo(Map<String, Object> param);
}
