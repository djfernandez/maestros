package pe.com.tpp.maestros.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import pe.com.tpp.maestros.model.Pais;

public interface IPaisDao extends PagingAndSortingRepository<Pais, Integer>, CrudRepository<Pais, Integer> {
 
	List<Pais> findByCpcpaisLike(String cpcpais);
	
}
