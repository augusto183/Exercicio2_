package dao;

import model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CarroDAO extends DAO {	
	public CarroDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Carro carro) {
		boolean status = false;
		try {
			String sql = "INSERT INTO carro (marca, modelo, ano, cor, preco) "
		               + "VALUES ('" + carro.getMarca() + "', '"
		               + carro.getModelo() + "', " + carro.getAno() + ", '" + carro.getCor() + "', " + carro.getPreco() + ");";
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Carro get(int id) {
		Carro carro = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE id="+id;
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 carro = new Carro(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), 
	        			   rs.getInt("ano"), rs.getString("cor"), (float)rs.getDouble("preco"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}
	
	
	public List<Carro> get() {
		return get("");
	}

	
	public List<Carro> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Carro> getOrderByMarca() {
		return get("marca");		
	}
	
	
	public List<Carro> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Carro> get(String orderBy) {
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Carro c = new Carro(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), 
	        			                rs.getInt("ano"), rs.getString("cor"), (float)rs.getDouble("preco"));
	            carros.add(c);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carros;
	}
	
	
	public boolean update(Carro carro) {
		boolean status = false;
		try {  
			String sql = "UPDATE carro SET marca = '" + carro.getMarca() + "', "
					   + "modelo = '" + carro.getModelo() + "', " 
					   + "ano = " + carro.getAno() + ","
					   + "cor = '" + carro.getCor() + "', " 
					   + "preco = " + carro.getPreco() + " WHERE id = " + carro.getID();
			Statement st = conexao.createStatement();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM carro WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}
