package pe.com.tpp.maestros.model.response;

import java.util.List;

import org.springframework.data.domain.Page;

import pe.com.tpp.maestros.model.Pais;

public class PaisResponse extends Respuesta {

	private List<Pais> pais;

	private Page<Pais> paisPagina;

	public Page<Pais> getPaisPagina() {
		return paisPagina;
	}

	public void setPaisPagina(Page<Pais> paisPagina) {
		this.paisPagina = paisPagina;
	}

	public List<Pais> getPais() {
		return pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}

}
