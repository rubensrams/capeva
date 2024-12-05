package mx.com.sistema.cap.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.sistema.cap.entity.UsuarioEntity;

@Repository
public interface IUsuarioDAO extends CrudRepository<UsuarioEntity, Long>{

	UsuarioEntity findByEmailAndPasswordAndEnabled(String mail, String password, int estatus);
	
	UsuarioEntity findByEmail(String mail);
	
	UsuarioEntity findByUsername(String userName);
	
	
	
}
