package boardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;

public class WriteCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int boardNumber = 0;	// root 0, 답글은 부모의 글번호를 가져온다.
		int groupNumber = 1;
		int sequenceNumber = 0;
		int sequenceLevel = 0;
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);
		
		return "/WEB-INF/board/write.jsp";
	}

}
