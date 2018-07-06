package boardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;

import boardModel.BoardDAO;
import boardModel.BoardDTO;
import command.Command;
import myBatis.SqlManager;

public class ReadCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		logger.info(logMsg+boardNumber+"\t"+pageNumber);
		
		BoardDTO boardDTO = BoardDAO.getInstance().read(boardNumber);
		logger.info(logMsg+boardDTO.toString());
		
		request.setAttribute("boardDTO", boardDTO);
		
		return "/WEB-INF/board/read.jsp";
	}

}
