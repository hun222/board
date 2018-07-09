package boardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDAO;
import boardModel.BoardDTO;
import command.Command;

public class UpdateCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		logger.info(logMsg+boardNumber+","+pageNumber);
		
		BoardDTO boardDTO = BoardDAO.getInstance().select(boardNumber);
		logger.info(logMsg+boardDTO.toString());
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("boardDTO", boardDTO);
		return "/WEB-INF/board/update.jsp";
	}
	

}
