package edu.pe.cibertec.service;

import edu.pe.cibertec.model.CursoEntity;
import edu.pe.cibertec.repository.CursoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Getter @Setter
    @Autowired
    CursoRepository cursoRepository;

    public List<CursoEntity> listarTodos(){
        return (List<CursoEntity>)getCursoRepository().findAll();
    }

    public CursoEntity obtenerCurso(int id){
        Optional<CursoEntity> optional = getCursoRepository().findById(id);
        //if (optional.isPresent()){
            return optional.get();
        //}else{
        //    return optional.orElse(null);
        //}
    }

    public CursoEntity saveUpdateCurso(CursoEntity curso){
        return getCursoRepository().save(curso);
    }

    public boolean deleteCurso(Integer id){
        Optional<CursoEntity> optional = getCursoRepository().findById(id);
        if (optional.isPresent()){
            getCursoRepository().delete(optional.get());
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

}
