package pe.com.tpp.maestros.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import pe.com.tpp.maestros.model.Puerto;

public interface IPuertoDao extends PagingAndSortingRepository<Puerto, Integer>, CrudRepository<Puerto, Integer> {

}
