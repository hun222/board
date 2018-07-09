package boardModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.SqlManager;

// singleton -> 객체생성을 static으로 반환
public class BoardDAO {
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession sqlSession;
	private static BoardDAO instance=new BoardDAO();
	
	private BoardDAO() {} // 기본생성자 막아서 싱글톤 유지할 수 있게 장치.
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public int insert(BoardDTO boardDTO) {
		writeNumber(boardDTO);
		int value = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			value = sqlSession.insert("boardInsert", boardDTO);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return value;
	}
	
	public void writeNumber(BoardDTO boardDTO) {
		int boardNumber = boardDTO.getBoardNumber();	// 0 1 0 0
		int groupNumber = boardDTO.getGroupNumber();
		int sequenceNumber = boardDTO.getSequenceNumber();
		int sequenceLevel = boardDTO.getSequenceLevel();
		int max = 0;
		if(boardNumber==0) {	// root 글 - 그룹번호 처리
			try {
				sqlSession = sqlSessionFactory.openSession();
				max = sqlSession.selectOne("boardGroupNumberMax");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
			if(max!=0)max+=1;
			else max = groupNumber;	// 1
			
			groupNumber = max;
			sequenceNumber = boardDTO.getSequenceNumber();	// 0
			sequenceLevel = boardDTO.getSequenceLevel();	// 0
		}else {					// 댓글 - 글순서, 글레벨 처리
			Map<String, Integer> map = new HashMap<>();
			map.put("groupNumber", groupNumber);
			map.put("sequenceNumber", sequenceNumber);
			
			try {
				sqlSession = sqlSessionFactory.openSession();
				sqlSession.update("boardWriteNumber",map);
				sqlSession.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
			
			sequenceNumber = sequenceNumber+1;
			sequenceLevel = sequenceLevel+1;
		}
		
		boardDTO.setGroupNumber(groupNumber);
		boardDTO.setSequenceNumber(sequenceNumber);
		boardDTO.setSequenceLevel(sequenceLevel);
	}

	public int getCount() {
		int count = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			count = sqlSession.selectOne("countRow");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count;
	}

	public List<BoardDTO> getBoardList(int startRow, int endRow) {
		List<BoardDTO> boardList = null;
		Map<String, Integer> map = new HashMap<>();
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList", map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return boardList;
	}
	
	public BoardDTO read(int boardNumber) {
		BoardDTO boardDTO = null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			sqlSession.update("boardReadCount",boardNumber);
			boardDTO=sqlSession.selectOne("boardRead", boardNumber);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}
		
		return boardDTO;
	}
	
	public int delete(int boardNumber, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardNumber", boardNumber);
		map.put("password", password);
		int rst = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			rst = sqlSession.delete("deleteBoard", map);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return rst;
	}

	public BoardDTO select(int boardNumber) {
		BoardDTO boardDTO=null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardDTO = sqlSession.selectOne("boardRead", boardNumber);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return boardDTO;
	}

	public int update(BoardDTO boardDTO) {
		int rst = 0;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			rst = sqlSession.update("boardUpdate",boardDTO);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return rst;
	}
}
