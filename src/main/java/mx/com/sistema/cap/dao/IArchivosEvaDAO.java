package mx.com.sistema.cap.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.com.sistema.cap.entity.ArchivosEvaEntity;


public interface IArchivosEvaDAO extends CrudRepository<ArchivosEvaEntity, Long>{

	List<ArchivosEvaEntity>  findByTipoDocumentoOrderByIdDesc(String documento);

}
