package boardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDAO;
import command.Command;

public class DeleteOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		String password = request.getParameter("password");
		
		logger.info(logMsg+boardNumber+","+pageNumber+","+password);
		
		int chk = BoardDAO.getInstance().delete(boardNumber, password);
		logger.info(logMsg+chk);
		
		request.setAttribute("chk", chk);
		request.setAttribute("pageNumber", pageNumber);
		return "/WEB-INF/board/deleteOk.jsp";
	}

}
