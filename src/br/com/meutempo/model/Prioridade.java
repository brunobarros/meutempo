package br.com.meutempo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Bruno
 *
 */
@Entity
@Table(name="prioridade")
public class Prioridade {
	
	@Id
	private Integer id;
	
	private String descricao;
	
	@OneToMany(mappedBy = "prioridade", cascade = CascadeType.ALL)
	private Set<Mestre> mestres = new HashSet<Mestre>();
	
	public Prioridade() {
		// TODO Auto-generated constructor stub
	}
	
	public Prioridade(Integer id) {
		super();
		this.id = id;
	}

	public Prioridade(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Mestre> getMestres() {
		return mestres;
	}

	public void setMestres(Set<Mestre> mestres) {
		this.mestres = mestres;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		 return (id != null ? id.hashCode() : 0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Prioridade prioridade = (Prioridade) o;

        if (id != null ? !id.equals(prioridade.id) : prioridade.id != null) return false;

        return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{Prioridade id=[%s] descricao=[%s]}", id, descricao);
	}
	
}

