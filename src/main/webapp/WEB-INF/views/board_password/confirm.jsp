<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/ajax.js"></script>
<title>confirm</title>
</head>
<body>
	<div>
		<form>
			<table>
				<tr>
					<td>
						비밀번호
					</td>
					<td>
						<input type="password" id="inputPassword" name="b_password" />
					</td>
					<td>
						<input type="hidden" id="boardNumber" name="b_num" value="${ b_num }"/>
						<input type="button" id="confirmButton" value="확인" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>