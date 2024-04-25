package edu.pe.cibertec.controller;

import edu.pe.cibertec.dto.ErrorDTO;
import edu.pe.cibertec.model.CursoEntity;
import edu.pe.cibertec.service.CursoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CursoController {

    @Getter
    @Setter
    @Autowired
    private CursoService cursoService;

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorDTO> handleException() {
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.CONFLICT.toString(),"Problema Interno", "Ha ocurrido un error en la aplicación. Verifique el log del Servidor.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDTO);
    }

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CursoEntity> listarTodos(){
        return cursoService.listarTodos();
    }

    @GetMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CursoEntity obtenerCurso(@PathVariable (value="id") Integer id){
        try {
            return getCursoService().obtenerCurso(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCurso(@PathVariable (value="id") Integer id){
        return getCursoService().deleteCurso(id);
    }

    @PostMapping(value = "cursos",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CursoEntity guardarCurso(@RequestBody CursoEntity curso){
        return getCursoService().saveUpdateCurso(curso);
    }

    @PutMapping(value = "cursos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CursoEntity actualizarCurso(@RequestBody CursoEntity curso,@PathVariable (value="id") Integer id){
        CursoEntity cursActualizar = new CursoEntity();
        curso.setId(id);
        BeanUtils.copyProperties(curso, cursActualizar);
        return getCursoService().saveUpdateCurso(cursActualizar);
    }


}
