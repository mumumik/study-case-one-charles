<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>List Songs</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Song List</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Judul</th>
					<th>Lirik Awal</th>
					<th>Lirik Reff</th>
					<th>Kunci Dasar</th>
				</tr>
				
				<c:forEach var="tempSong" items="${song_list}">
					<tr>
						<td>${tempSong.title}</td>
						<td>${tempSong.startingLyrics}</td>
						<td>${tempSong.reff}</td>
						<td>${tempSong.baseKey}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>