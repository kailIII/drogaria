package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws SQLException{
		
		Produto p = new Produto();
		p.setDescricao("dipirona");
		p.setPreco(10.45);
		p.setQuantidade(10L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(17L);				
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
		
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{		
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();
		
		for(Produto p:lista){
			System.out.println("codigo"+ p.getCodigo());
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(1L);
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
		
		
	}
	
	@Test
	public void editar() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(3L);
		p.setDescricao("Cataflan pomada com 60 gramas");
		p.setPreco(15.380);
		p.setQuantidade(1L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(34L);
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}
	
	
	

}
