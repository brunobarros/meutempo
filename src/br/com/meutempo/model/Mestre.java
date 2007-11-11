package br.com.meutempo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bruno
 * @since 06/11/2007
 */
@Entity
@Table(name="mestre")
public class Mestre {
	 
	@Id
	@GeneratedValue
	private Integer id;
	 
	private String descricao;
	
	public Mestre() {
		super();
	}

	public Mestre(Integer id, String descricao) {
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

        final Mestre mestre = (Mestre) o;

        if (id != null ? !id.equals(mestre.id) : mestre.id != null) return false;

        return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{Mestre id=[%s] descricao=[%s]}", id, descricao);
	}
	 
}
