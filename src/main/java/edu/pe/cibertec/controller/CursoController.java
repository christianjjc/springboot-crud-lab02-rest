package edu.pe.cibertec.controller;

import edu.pe.cibertec.model.CursoEntity;
import edu.pe.cibertec.service.CursoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {

    @Getter
    @Setter
    @Autowired
    private CursoService cursoService;

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CursoEntity> listarTodos(){
        return cursoService.listarTodos();
    }

    @GetMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoEntity obtenerCurso(@PathVariable (value="id") Integer id){
        return getCursoService().obtenerCurso(id);
    }

    @DeleteMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean eliminarCurso(@PathVariable (value="id") Integer id){
        return getCursoService().deleteCurso(id);
    }

    @PostMapping(value = "cursos",produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoEntity guardarCurso(@RequestBody CursoEntity curso){
        return getCursoService().saveUpdateCurso(curso);
    }

    @PutMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CursoEntity actualizarCurso(@RequestBody CursoEntity curso,@PathVariable (value="id") Integer id){
        CursoEntity cursActualizar = new CursoEntity();
        curso.setId(id);
        BeanUtils.copyProperties(curso, cursActualizar);
        return getCursoService().saveUpdateCurso(cursActualizar);
    }


}
