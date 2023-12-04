package pe.com.tpp.maestros.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ICrud<E, T, Y> {

	public ResponseEntity<Y> buscarTodos(Pageable pageable);
	
	public ResponseEntity<Y> buscarPorId(T id);

	public ResponseEntity<Y> crear(E entidad);

	public ResponseEntity<Y> actualizar(E entidad, T id);

	public ResponseEntity<Y> eliminar(T id);

}
