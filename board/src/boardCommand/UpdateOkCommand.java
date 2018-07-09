package boardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDAO;
import boardModel.BoardDTO;
import command.Command;

public class UpdateOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setContent(request.getParameter("content"));
		boardDTO.setPassword(request.getParameter("password"));
		logger.info(logMsg+boardDTO.toString());
		
		int count = BoardDAO.getInstance().update(boardDTO);
		logger.info(logMsg+count);
		
		request.setAttribute("count", count);
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("boardNumber", boardDTO.getBoardNumber());
		return "/WEB-INF/board/updateOk.jsp";
	}

}
