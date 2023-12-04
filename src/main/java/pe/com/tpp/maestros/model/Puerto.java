package pe.com.tpp.maestros.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_mge_puerto")
public class Puerto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cpnid_puerto")
	private Integer id;
	@Column(name = "cpnduplicacion")
	private Long cpnduplicacion;
	@Column(name = "cpnid_pais")
	private Integer cpnidpais;
	@Column(name = "cpcpuerto")
	private String cpcpuerto;
	@Column(name = "cpccortopuerto")
	private String cpccortopuerto;
	@Column(name = "cpcisopuerto")
	private String cpcisopuerto;
	@Column(name = "cpcisofuncion")
	private String cpcisofuncion;
	@Column(name = "cpcisoestado")
	private String cpcisoestado;
	@Column(name = "cpnid_oficinaaduana")
	private Integer cpnidoficinaaduana;
	@Column(name = "cpnid_estadoregistro")
	private Integer cpnidestadoregistro;
	@Column(name = "cpdcreacion")
	private Date cpdcreacion;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "cpnid_pais", insertable = false, updatable = false)
	private Pais pais;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCpnduplicacion() {
		return cpnduplicacion;
	}

	public void setCpnduplicacion(Long cpnduplicacion) {
		this.cpnduplicacion = cpnduplicacion;
	}

	public Integer getCpnidpais() {
		return cpnidpais;
	}

	public void setCpnidpais(Integer cpnidpais) {
		this.cpnidpais = cpnidpais;
	}

	public String getCpcpuerto() {
		return cpcpuerto;
	}

	public void setCpcpuerto(String cpcpuerto) {
		this.cpcpuerto = cpcpuerto;
	}

	public String getCpccortopuerto() {
		return cpccortopuerto;
	}

	public void setCpccortopuerto(String cpccortopuerto) {
		this.cpccortopuerto = cpccortopuerto;
	}

	public String getCpcisopuerto() {
		return cpcisopuerto;
	}

	public void setCpcisopuerto(String cpcisopuerto) {
		this.cpcisopuerto = cpcisopuerto;
	}

	public String getCpcisofuncion() {
		return cpcisofuncion;
	}

	public void setCpcisofuncion(String cpcisofuncion) {
		this.cpcisofuncion = cpcisofuncion;
	}

	public String getCpcisoestado() {
		return cpcisoestado;
	}

	public void setCpcisoestado(String cpcisoestado) {
		this.cpcisoestado = cpcisoestado;
	}

	public Integer getCpnidoficinaaduana() {
		return cpnidoficinaaduana;
	}

	public void setCpnidoficinaaduana(Integer cpnidoficinaaduana) {
		this.cpnidoficinaaduana = cpnidoficinaaduana;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
