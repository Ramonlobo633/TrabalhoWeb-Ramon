package com.trabalhoweb.trabalhoweb.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
public class Produto extends AbstractEntity<Long>{
	
	private String nome;
	private String descricao;
	
	@Column(nullable=false, columnDefinition="DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal valor;
	private String img;
	
	@OneToMany
	private List<Produto> compras;
	
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getCompras() {
		return compras;
	}
	public void setCompras(List<Produto> compras) {
		this.compras = compras;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return descricao;
	}
	public void setDesc(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
