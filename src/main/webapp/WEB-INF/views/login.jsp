<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/script.js"></script>
<title>login</title>
</head>
<body>
	<div>
		<form>
			<table>
				<tr>
					<td>
						ID
					</td>
					<td>
						<input type="text" name="m_id" />
					</td>
					<td>
						<input type="button" value="로그인" onClick="goPage('doLogin', this.form)"/>
					</td>
				</tr>
				<tr>
					<td>
						PW
					</td>
					<td>
						<input type="password" name="m_password" />
					</td>
				</tr>
				<tr>
					<td>
						로그인유지
						<input type="checkbox" name="auto_login" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>