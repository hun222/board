package boardModel;

import java.util.Date;

public class BoardDTO {
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String password;
	
	private int boardNumber;
	private int groupNumber;
	private int sequenceNumber;
	private int sequenceLevel;
	
	private int readCount;
	private Date writeDate;
	
	public BoardDTO() {}
	
	public BoardDTO(String writer, String subject, String email, String content, String password, int boardNumber,
			int groupNumber, int sequenceNumber, int sequenceLevel, int readCount, Date writeDate) {
		super();
		this.writer = writer;
		this.subject = subject;
		this.email = email;
		this.content = content;
		this.password = password;
		this.boardNumber = boardNumber;
		this.groupNumber = groupNumber;
		this.sequenceNumber = sequenceNumber;
		this.sequenceLevel = sequenceLevel;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getSequenceLevel() {
		return sequenceLevel;
	}

	public void setSequenceLevel(int sequenceLevel) {
		this.sequenceLevel = sequenceLevel;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [writer=" + writer + ", subject=" + subject + ", email=" + email + ", content=" + content
				+ ", password=" + password + ", boardNumber=" + boardNumber + ", groupNumber=" + groupNumber
				+ ", sequenceNumber=" + sequenceNumber + ", sequenceLevel=" + sequenceLevel + ", readCount=" + readCount
				+ ", writeDate=" + writeDate + "]";
	}
	

}