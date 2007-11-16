package br.com.meutempo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Bruno
 * @since 06/11/2007
 */
@Entity
@Table(name="mestre")
@SequenceGenerator(name = "seq_mestre", sequenceName = "seq_mestre")
public class Mestre {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mestre")
	private Integer id;
	 
	private String descricao;
	
	private Date dataInclusao = new Date();
	
	@ManyToOne
	private Prioridade prioridade;
	
	private String concluido = "N";
	
	public Mestre() {
		super();
	}

	public Mestre(Integer id, String descricao, Date dataInclusao, Prioridade prioridade, String concluido) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.prioridade = prioridade;
		this.concluido = concluido;
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
	
	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getConcluido() {
		return concluido;
	}

	public void setConcluido(String concluido) {
		this.concluido = concluido;
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
		return String.format("{Mestre id=[%s], descricao=[%s], dataInclusao=[%s], prioridade=[%s], concluído=[%s] }", id, descricao, dataInclusao, prioridade, concluido);
	}

}
