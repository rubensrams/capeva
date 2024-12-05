package mx.com.sistema.cap.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.sistema.cap.entity.GrupoEntity;

@Repository
public interface IGruposDAO extends CrudRepository<GrupoEntity, Long>{

	List<GrupoEntity>  findByEstatusOrderByNumero(int estatus);

}
