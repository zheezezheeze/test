<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/ajax.js"></script>
<title>setting</title>
</head>
<body>
	<div>
		<form id="settingForm">
			<table>
				<tr>
					<td>
						비밀번호
					</td>
					<td>
						<input type="password" id="firstValue" name="b_password"></input>
					</td>
					<td rowspan="2">
						<input type="button" id="settingButton" value="저장"/>
					</td>
				</tr>
				<tr>
					<td>
						비밀번호 재입력
					</td>
					<td>
						<input type="password" id="secondValue" name="b_retry" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>