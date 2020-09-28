package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import bean.TinyURLBean;

import java.util.ArrayList;

public class Model {
	
	private String url="jdbc:mysql://localhost:3306/url_db";
	private String username="root";
	private String password="root";	
	
	private Connection con = null;
	
	public Model() {
		connect();
	}
	
	public void connect() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(url,username,password);
		}catch(SQLException e){
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public boolean isValidUser(String username, String password) {
		boolean isValid = false;
		String sql = "SELECT * FROM url_db.users where username='"+username+"' and password='"+password+"'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				isValid = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return isValid;
	}
	
	public void addTinyURL(int userId, String url, String tinyURL) {
		String sql = "INSERT INTO `url_db`.`tiny_url` (`user_id`, `url`, `tiny_url`) VALUES ('"+userId+"', '"+url+"', '"+tinyURL+"')";
		try {
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getUserId(String username) {
		int userId = 0;
		String sql = "SELECT id FROM url_db.users where username='"+username+"'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				userId = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}
	public String getUserName(int userId) {
		String username = "";
		String sql = "SELECT username FROM url_db.users where id='"+userId+"'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				username = rs.getString("username");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return username;
	}
	
	public List<TinyURLBean> getTinyUrls(int userId) {
		String sql = "SELECT * FROM url_db.tiny_url where user_id='"+userId+"'";
		List<TinyURLBean> urlList = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				urlList.add(new TinyURLBean(rs.getInt("id"), this.getUserName(rs.getInt("user_id")), rs.getString("url"), rs.getString("tiny_url")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return urlList;
	}

	public static void main(String[] args) {
		Model model = new Model();
		System.out.println(model.getUserName(1));
		//DELETE FROM `url_db`.`tiny_url` WHERE (`id` = '1');
		List<TinyURLBean> urlList = model.getTinyUrls(1);
//		for (TinyURLBean urlBean  : urlList){ 
//			System.out.println(urlBean.getId());
//			System.out.println(urlBean.getUserId());
//			System.out.println(urlBean.getUrl());
//			System.out.println(urlBean.getTinyURL());
//		}
		
	}
}
