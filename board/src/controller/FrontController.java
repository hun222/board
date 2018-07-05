package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardCommand.WriteCommand;
import command.Command;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FrontController.class.getName());
	private final String logMsg = "LogMSg----------";
	private Map<String, Object> commandMap = new HashMap<>();
	
	public FrontController() {
		super();
	}
	
	/**
	 * property setting : instance mapping
	 * */
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		String path = config.getServletContext().getRealPath(configFile);	// 실제 서버 경로
		logger.info(logMsg+configFile+", "+path);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();
		
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			pro.load(bis);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null)bis.close();
				if(fis != null)fis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		Iterator<Object> keyIter = pro.keySet().iterator();
		while(keyIter.hasNext()) {
			//	/write.do = boardCommand.WriteCommand
			String key = keyIter.next().toString();
			String className = pro.getProperty(key);
			logger.info(logMsg + key+", "+className);
			
			try {
				// 동적 객체생성 : 문자열을 객체로 만들어준다.
				Class<?> handlerClass = Class.forName(className);
				Object handlerInstance = handlerClass.newInstance();
				commandMap.put(key, handlerInstance);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(request.getContextPath().length());
		logger.info(logMsg+cmd);
		
		String view = null;
		try {
			Command command = (Command)commandMap.get(cmd);
			view = command.proRequest(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		if(view!=null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
