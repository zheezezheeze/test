<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/script.js"></script>
<title>list</title>
</head>
<body>
	<div>
		<form>
			<table>
				<thead>
					<tr>
						<th>
							번호
						</th>
						<th>
							제목
						</th>
						<th>
							작성자	
						</th>
						<th>
							조회수
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th colspan="4">
							<input type="button" value="글쓰기" onClick="goPage('goWrite', this.form)"/>	
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:choose>
						<c:when test="${list != null}">
							<c:forEach var="board" items="${ list }">
								<tr>
									<td>
										${ board.b_num }
									</td>
									<td>
										<c:choose>
											<c:when test="${ board.b_password == '' }">
												<a href="detail?b_num=${ board.b_num }">
													${ board.b_title }
												</a>
											</c:when>
											<c:otherwise>
												<a onclick="goNewWindow('confirm?b_num=${ board.b_num }')">
													${ board.b_title }
												</a>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										${ board.m_id }
									</td>
									<td>
										${ board.b_count }
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>목록이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>