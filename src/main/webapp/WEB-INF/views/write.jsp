<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/script.js"></script>
<title>write</title>
</head>
<body>
	<div>
		<form>
			<p>글쓰기</p>
			제목<input type="text" name="b_title" />
			<hr />
			내용<textarea id="b_content" name="b_content"></textarea>
			<hr />
			<input type="button" value="비밀번호 설정" onClick="goNewWindow('setting')">
			<p id="hasPassword"></p>
			<hr />
			<input type="hidden" id="b_password"name="b_password"></input>
			<input type="hidden" value="${ loginUser.m_id }" name="m_id"/>
			<input type="button" value="저장" onClick="goPage('doWrite', this.form)"/>
			<input type="button" value="취소" onClick="goPage('cancleWrite', this.form)"/>
		</form>
	</div>
</body>
</html>