package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Product;


public class ProductDao {
	
	
	private Connection connection;

	public ProductDao(Connection connection) {
	    this.connection = connection;
	}
	
	private static final String SQL_SELECT_WHERE_USER_ID = "SELECT * FROM products WHERE product_id = ?";

	public Product findById(Integer product_id) {
		
		//System.out.println(product_id);
    	
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_USER_ID)) {
            stmt.setInt(1, product_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	System.out.println(product_id);
                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	
        return null;
    }
	
}
