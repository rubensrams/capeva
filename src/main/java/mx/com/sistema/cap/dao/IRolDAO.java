package mx.com.sistema.cap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.sistema.cap.entity.RolEntity;

@Repository
public interface IRolDAO extends CrudRepository<RolEntity, Long>{
	
	
}
