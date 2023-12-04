package pe.com.tpp.maestros.service;

import org.springframework.http.ResponseEntity;

import pe.com.tpp.maestros.model.Pais;
import pe.com.tpp.maestros.model.response.PaisResponse;

public interface IPaisService extends ICrud<Pais, Integer, PaisResponse> {

	ResponseEntity<PaisResponse> buscarPorPaisLike(String cpcpais);

}
