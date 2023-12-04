package pe.com.tpp.maestros.model.response;

import java.util.List;

import org.springframework.data.domain.Page;

import pe.com.tpp.maestros.model.Puerto;

public class PuertoResponse extends Respuesta {

	private List<Puerto> puerto;
	private Page<Puerto> puertoPagina;

	public List<Puerto> getPuerto() {
		return puerto;
	}

	public void setPuerto(List<Puerto> puerto) {
		this.puerto = puerto;
	}

	public Page<Puerto> getPuertoPagina() {
		return puertoPagina;
	}

	public void setPuertoPagina(Page<Puerto> puertoPagina) {
		this.puertoPagina = puertoPagina;
	}

}
