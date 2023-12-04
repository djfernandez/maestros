package pe.com.tpp.maestros.model.response;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PuertoDto {

	@Id
	private Integer id;
	private Long cpnduplicacion;
	private Integer cpnidpais;
	private String cpcpuerto;
	private String cpccortopuerto;
	private String cpcisopuerto;
	private String cpcisofuncion;
	private String cpcisoestado;
	private Integer cpnidoficinaaduana;
	private Short cpnidestadoregistro;
	private Date cpdcreacion;

	private String cpcpais;

	public Integer getId() {
		return id;
	}

	public Long getCpnduplicacion() {
		return cpnduplicacion;
	}

	public Integer getCpnidpais() {
		return cpnidpais;
	}

	public String getCpcpuerto() {
		return cpcpuerto;
	}

	public String getCpccortopuerto() {
		return cpccortopuerto;
	}

	public String getCpcisopuerto() {
		return cpcisopuerto;
	}

	public String getCpcisofuncion() {
		return cpcisofuncion;
	}

	public String getCpcisoestado() {
		return cpcisoestado;
	}

	public Integer getCpnidoficinaaduana() {
		return cpnidoficinaaduana;
	}

	public Short getCpnidestadoregistro() {
		return cpnidestadoregistro;
	}

	public Date getCpdcreacion() {
		return cpdcreacion;
	}

	public String getCpcpais() {
		return cpcpais;
	}

}
