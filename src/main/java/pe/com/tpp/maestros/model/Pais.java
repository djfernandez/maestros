package pe.com.tpp.maestros.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_mge_pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpnid_pais")
	private Integer id;
	@Column(name = "cpnid_regioncontinente")
	private Long cpnidregioncontinente;
	@Column(name = "cpcpais")
	private String cpcpais;
	@Column(name = "cpccortopais")
	private String cpccortopais;
	@Column(name = "cpcisopais")
	private String cpcisopais;
	@Column(name = "cpnid_monedalocal")
	private Integer cpnidmonedalocal;
	@Column(name = "cpnid_monedaextranjera")
	private Integer cpnidmonedaextranjera;
	@Column(name = "cpnid_estadoregistro")
	private Integer cpnidestadoregistro;
	@Column(name = "cpdcreacion")
	private Date cpdcreacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCpnidregioncontinente() {
		return cpnidregioncontinente;
	}

	public void setCpnidregioncontinente(Long cpnidregioncontinente) {
		this.cpnidregioncontinente = cpnidregioncontinente;
	}

	public String getCpcpais() {
		return cpcpais;
	}

	public void setCpcpais(String cpcpais) {
		this.cpcpais = cpcpais;
	}

	public String getCpccortopais() {
		return cpccortopais;
	}

	public void setCpccortopais(String cpccortopais) {
		this.cpccortopais = cpccortopais;
	}

	public String getCpcisopais() {
		return cpcisopais;
	}

	public void setCpcisopais(String cpcisopais) {
		this.cpcisopais = cpcisopais;
	}

	public Integer getCpnidmonedalocal() {
		return cpnidmonedalocal;
	}

	public void setCpnidmonedalocal(Integer cpnidmonedalocal) {
		this.cpnidmonedalocal = cpnidmonedalocal;
	}

	public Integer getCpnidmonedaextranjera() {
		return cpnidmonedaextranjera;
	}

	public void setCpnidmonedaextranjera(Integer cpnidmonedaextranjera) {
		this.cpnidmonedaextranjera = cpnidmonedaextranjera;
	}

	public Integer getCpnidestadoregistro() {
		return cpnidestadoregistro;
	}

	public void setCpnidestadoregistro(Integer cpnidestadoregistro) {
		this.cpnidestadoregistro = cpnidestadoregistro;
	}

	public Date getCpdcreacion() {
		return cpdcreacion;
	}

	public void setCpdcreacion(Date cpdcreacion) {
		this.cpdcreacion = cpdcreacion;
	}
}
