package boardCommand;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDTO;
import command.Command;

public class WriteOkCommand implements Command{
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setWriter(request.getParameter("writer"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setContent(request.getParameter("content"));
		boardDTO.setPassword(request.getParameter("password"));
		
		boardDTO.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDTO.setGroupNumber(Integer.parseInt(request.getParameter("groupNumber")));
		boardDTO.setSequenceNumber(Integer.parseInt(request.getParameter("sequenceNumber")));
		boardDTO.setSequenceLevel(Integer.parseInt(request.getParameter("sequenceLevel")));
		
		boardDTO.setWriteDate(new Date());
		boardDTO.setReadCount(0);
		
		logger.info(logMsg + boardDTO.toString()); 
		
		return null;
	}

}
