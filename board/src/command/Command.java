package command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.FrontController;

public interface Command {
	public Logger logger = Logger.getLogger(Command.class.getName());
	public String logMsg = "LogMSg----------";
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
