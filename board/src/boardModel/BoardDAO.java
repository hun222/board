package boardModel;

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
			
		}
		
		boardDTO.setGroupNumber(groupNumber);
		boardDTO.setSequenceNumber(sequenceNumber);
		boardDTO.setSequenceLevel(sequenceLevel);
	}
}
