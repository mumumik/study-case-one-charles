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
			<h2>Study Case Charles</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Add Song"
					onclick="window.location.href='add-song-form.jsp'; return false;"
					class="add-song-button"
			 />
			<table>
				<tr>
					<th>Judul</th>
					<th>Lirik Awal</th>
					<th>Lirik Reff</th>
					<th>Kunci Dasar</th>
					<th>Aksi</th>
				</tr>
				
				<c:forEach var="tempSong" items="${song_list}"> 
					
					<!-- set up a link for each song -->
					<c:url var="tempLink" value="SongControllerServlet">
						<c:param name="command" value="load" />
						<c:param name="songId" value="${tempSong.id}" />
					</c:url>
					
					<tr>
						<td>${tempSong.title}</td>
						<td>${tempSong.startingLyrics}</td>
						<td>${tempSong.reff}</td>
						<td>${tempSong.baseKey}</td>
						<td><a href="${tempLink}">Update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>