<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/script.js"></script>
<title>detail</title>
</head>
<body>
	<div>
		<form>
			<table>
				<tr>
					<td>
						번호
					</td>
					<td>
						제목
					</td>
					<td>
						작성자
					</td>
					<td>
						조회수
					</td>
				</tr>
				<tr>
					<td>
						${ board.b_num }
					</td>
					<td>
						${ board.b_title }
					</td>
					<td>
						${ board.m_id }
					</td>
					<td>
						${ board.b_count }
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea cols="100" rows="4">${ board.b_content }</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="b_number" value="${ board.b_num }"/>
						<input type="hidden" id="hasPassword"/>
						<input type="hidden" id="b_password" value="${ board.b_password }"/>
						<input type="button" value="비밀번호 설정" onclick="goNewWindow('setting', ${ board.b_num })"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>