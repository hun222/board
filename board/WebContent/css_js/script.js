function checkForm(boardForm){
	if(boardForm.writer.value==""){
		alert("input writer");
		boardForm.writer.focus();
		return false;
	}
	
	return true;
}