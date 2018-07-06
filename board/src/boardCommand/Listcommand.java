package boardCommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDAO;
import boardModel.BoardDTO;
import command.Command;

public class Listcommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) pageNumber="1";
		
		int currentPage = Integer.parseInt(pageNumber);
		logger.info(logMsg+"currentPage:"+currentPage);
		
		// 페이지당 게시물 수를 정하고, 첫 행의 번호와 마지막 행의 번호를 구한다.
		// 페이지당 게시물: 10개, 첫 행 번호: 1, 마지막 행 번호: 10
		int boardSize = 2;	//10 -> 3 변경함.
		int startRow = (currentPage-1)*boardSize+1;	
		int endRow = currentPage*boardSize;
		
		int count = BoardDAO.getInstance().getCount();
		logger.info(logMsg+"count:"+count);
		
		List<BoardDTO> boardList = null;
		if(count > 0) {
			boardList = BoardDAO.getInstance().getBoardList(startRow,endRow);
			logger.info(logMsg+"boardSize:"+boardList.size());
		}
		
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("count", count);
		request.setAttribute("boardList", boardList);
		
		return "/WEB-INF/board/list.jsp";
	}

}