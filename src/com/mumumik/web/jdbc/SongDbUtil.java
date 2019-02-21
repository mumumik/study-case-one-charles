package com.mumumik.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SongDbUtil {

	private DataSource dataSource;
	
	public SongDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Song> getSongs() throws Exception{
		
		List<Song> songs = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			//create sql statement
			String sql = "select * from song order by title";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while(myRs.next()) {
				
				//retrieve data from result row
				int id = myRs.getInt("id");
				String title = myRs.getString("title");
				String startingLyrics = myRs.getString("startingLyrics");
				String reff = myRs.getString("reff");
				String baseKey = myRs.getString("baseKey");
				
				// create new song object
				Song tempSong = new Song(id, title, startingLyrics, reff, baseKey);
				
				// add it to the list of students
				songs.add(tempSong);
				
			}
			
			return songs;
		}
		finally {
			//close JDBC object
			close(myConn,myStmt, myRs);
		}
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		
		try {
			
			if(myRs != null) {
				myRs.close();
			}
			
			if(myStmt != null) {
				myStmt.close();
			}
			
			if(myConn != null) {
				myConn.close(); // doesn't realy close it .. just puts back in connection pool
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
