package edu.pe.cibertec.repository;

import edu.pe.cibertec.model.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<CursoEntity,Integer> {



}
