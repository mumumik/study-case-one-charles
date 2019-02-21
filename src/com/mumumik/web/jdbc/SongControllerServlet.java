package com.mumumik.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SongControllerServlet
 */
@WebServlet("/SongControllerServlet")
public class SongControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SongDbUtil songDbUtil;
	
	@Resource(name="jdbc/study_case_one_charles")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		//create our song db util and pass in the conn pool/datasource
		try {
			songDbUtil = new SongDbUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing song
			if(theCommand == null) {
				theCommand = "list";
			}
			
			//route to the appropriate method
			switch(theCommand) {
			
			case "list":
				listSongs(request,response);
			
			case "add":
				addSong(request,response);
				
			default:
				listSongs(request,response);
			}
			
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void addSong(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read song info from form data
		String title = request.getParameter("title");
		String startingLyrics = request.getParameter("startingLyrics");
		String reff = request.getParameter("reff");
		String baseKey = request.getParameter("baseKey");
		
		//create a new song object
		Song theSong = new Song(title,startingLyrics,reff,baseKey);
		
		//add the song to the database
		songDbUtil.addSong(theSong);
		
		//send back to main page (song list)
		listSongs(request,response);
		
	}

	private void listSongs(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		
		// get songs from db util
		List<Song> songs = songDbUtil.getSongs();
		
		// add songs to the request
		request.setAttribute("song_list", songs);
		
		// send to JSP Page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-songs.jsp");
		dispatcher.forward(request, response);
		
	}

}
