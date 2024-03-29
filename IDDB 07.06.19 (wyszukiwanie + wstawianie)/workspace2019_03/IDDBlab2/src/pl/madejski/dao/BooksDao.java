package pl.madejski.dao;

import pl.madejski.model.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BooksDao {

	private List<Book> books;
	
	public BooksDao() {
		books = new ArrayList<>();
		init();
	}
	
	public void init() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("jdbc/SQLServer");
			
			//Connection conn = ds.getConnection();
			Connection conn=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","Misia123");  
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT book_id, title, author_name, availability FROM books");
			while (rs.next()) {
				books.add(new Book(
						Long.parseLong(rs.getString("book_id")),
						rs.getString("title"),
						rs.getString("author_name"),
						rs.getInt("availability")
				));
			}
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Book> findAll() {
		return books;
	}
	
	public List<Book> findByName(String name) {
		return books.stream()
				.filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	public void save(Product product) {
		// TODO: init JDBC connection once/move create somewhere else
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("jdbc/SQLServer");
			
			//Connection conn = ds.getConnection();
			Connection conn=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","Misia123");  
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO products (productname) VALUES (?)");
			
			
			pstmt.setString(1, product.getName());
			
			if(pstmt.executeUpdate() != 1) { // shouldn't insert more than 1 row
				pstmt.close();
				conn.close();
				throw new Exception("Wyst�pi� b��d podczas dodawania produktu!");
			}
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
