package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append(" VALUES (?) ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.executeUpdate();

	}
	
	
	public void excluir(Fabricante f) throws  SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();


	}
	
	public Fabricante buscarPorCodigo(Fabricante f) throws  SQLException{
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		
		Fabricante retorno = null;
		
		if(resultado.next()){
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		
		return retorno;
	}
	
	
	public void editar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());		
		comando.executeUpdate();
		
	}
	
	
	public ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");
		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()){
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			lista.add(f);
		}
		
		
		return lista;
	}
	
	
	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, "%" + f.getDescricao() + "%");

		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()){
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			lista.add(item);
		}
		
		
		return lista;
	}
	
	
	public static void main(String[] args) {
		/*
		Fabricante f1 = new Fabricante();
		f1.setDescricao("jose papeis");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("maria papeis");
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("fabricante salvos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ocorreu erro");
		}*/
		
		/*Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("exclusao com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro");
		}*/
		
		/*		//teste  edição
		Fabricante f3 = new Fabricante();
		f3.setCodigo(3L);
		f3.setDescricao("colchoes");
		
		try {
			fdao.editar(f3);
			System.out.println("edição bem sucedida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro");
		}*/
		
		//teste  busca por codigo
//		Fabricante f1 = new Fabricante();
//		f1.setCodigo(3L);
//		
//		
//		FabricanteDAO fdao = new FabricanteDAO();
//		
//		try {
//			Fabricante f3 = fdao.buscarPorCodigo(f1);
//			
//			System.out.println(" resultado" + f3.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			
			Fabricante fab = new Fabricante();
			fab.setDescricao("mar");
			
			ArrayList<Fabricante> lista = fdao.buscarPorDescricao(fab);
			
				
				for(Fabricante f:lista){
					System.out.println("resultado"+ f);
				}
			
			
		} catch (SQLException e) {
			System.out.println("ocorreu erro ao listar fabricantes");
			e.printStackTrace();
		}
		
		
	}

}

