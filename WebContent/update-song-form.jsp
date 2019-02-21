<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Update song</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-song-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Study Case Charles</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Ubah Lagu</h3>
		
		<form action="SongControllerServlet" method="GET">
			
			<input type="hidden" name="command" value="update" />
			<input type="hidden" name="songId" value="${the_song.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Judul :</label></td>
						<td><input type="text" name="title" 
									value="${the_song.title}"/></td>
					</tr>
					
					<tr>
						<td><label>Lirik Awal :</label></td>
						<td><input type="text" name="startingLyrics" 
									value="${the_song.startingLyrics}"/></td>
					</tr>
					
					<tr>
						<td><label>Lirik Reff :</label></td>
						<td><input type="text" name="reff" 
									value="${the_song.reff}"/></td>
					</tr>
					
					<tr>
						<td><label>Kunci Dasar :</label></td>
						<td><input type="text" name="baseKey" 
									value="${the_song.baseKey}"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Simpan" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="SongControllerServlet">Kembali</a>
		</p>
	</div>
</body>

</html>