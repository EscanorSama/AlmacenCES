package com.ces.almacen.services;

import com.ces.almacen.converters.AlumnoConverter;
import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Material;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.AlumnoModel;
import com.ces.almacen.repositories.AlumnoRepository;
import com.ces.almacen.repositories.PersonaRepository;
import com.ces.almacen.repositories.TaquillaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private AlumnoConverter alumnoConverter;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private TaquillaRepository taquillaRepository;

    public AlumnoModel insertAlumno(AlumnoModel alumnoModel) {
        Persona persona = personaService.insertPersona(alumnoModel);
        log.info("ALUMNO MODEL: "+alumnoModel.toString());
        Alumno alumno = alumnoConverter.modelToEntity(alumnoModel);
        log.info("ALUMNO: "+alumno.toString());
        alumno.setPersona(persona);
        alumno.setId(alumnoRepository.save(alumno).getId());
        return alumnoModel;
    }

    public Optional<AlumnoModel> deleteAlumno(Long id) {
        Optional<AlumnoModel> resultAm = Optional.empty();
        Optional<Alumno> result = alumnoRepository.findById(id);
        if(result.isPresent()){
            Alumno alumno = result.get();
            AlumnoModel alumnoModel = alumnoConverter.entityToModel(alumno);
            resultAm = Optional.of(alumnoModel);
            alumnoRepository.delete(alumno);
        }
        return resultAm;
    }

    public Optional<AlumnoModel> getAlumno(Long id) {
        Optional<AlumnoModel> resultAm = Optional.empty();
        Optional<Alumno> result = alumnoRepository.findById(id);
        if(result.isPresent()){
            Alumno alumno = result.get();
            AlumnoModel alumnoModel = alumnoConverter.entityToModel(alumno);
            resultAm = Optional.of(alumnoModel);
        }
        return resultAm;
    }

    public List<AlumnoModel> getAlumnoNumExpediente(int nPag, int tPag, String numExpediente){
        Pageable pageable = PageRequest.of(nPag,tPag);
        Page<Alumno> alumnosNumExpedientePag = alumnoRepository.findByNumExpediente(numExpediente, pageable);
        List<Alumno> alumnosNumExpediente = alumnosNumExpedientePag.getContent();
        List<AlumnoModel> alumnosModel = listAlumnoToListAlumnoModel(alumnosNumExpediente);
        return alumnosModel;
    }

    public List<AlumnoModel> getAlumnoCodigoPostal(int nPag, int tPag, String codigoPostal){
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Alumno> alumnosCodigoPostalPag = alumnoRepository.findByCodigoPostal(codigoPostal, pageable);
        List<Alumno> alumnosCodigoPostal = alumnosCodigoPostalPag.getContent();
        List<AlumnoModel> alumnosModel = listAlumnoToListAlumnoModel(alumnosCodigoPostal);
        return alumnosModel;
    }



    public List<AlumnoModel> getAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        List<AlumnoModel> alumnosModel = listAlumnoToListAlumnoModel(alumnos);
        return alumnosModel;
    }

    private List<AlumnoModel> listAlumnoToListAlumnoModel(List<Alumno> alumnos) {
        List<AlumnoModel> alumnosModel = new ArrayList<>();
        for (Alumno alumno:alumnos) {
            AlumnoModel alumnoModel = alumnoConverter.entityToModel(alumno);
            alumnosModel.add(alumnoModel);
        }
        return alumnosModel;
    }

    public List<AlumnoModel> postAlumnos(List<AlumnoModel> alumnosModel) {
        for (AlumnoModel alumnoModel: alumnosModel) {
            insertAlumno(alumnoModel);
        }
        return alumnosModel;
    }

    public void updateAlumno (AlumnoModel alumnoM){
        Optional<Alumno> result = alumnoRepository.findById(alumnoM.getAlumnoId());
        if(result.isPresent()){
            Alumno alumno = result.get();
            Persona persona = alumno.getPersona();
            persona.setMail(alumnoM.getMail());
            personaRepository.save(persona);
            alumnoRepository.save(alumno);
        }
    }


    public void insertTaquilla(Long alumnoId, Long taquillaId) {
        Optional<Taquilla> resultTaquilla = taquillaRepository.findById(taquillaId);
        Optional<Alumno> resultAlumno = alumnoRepository.findById(alumnoId);
        if(resultTaquilla.isPresent() && resultAlumno.isPresent()){
            Alumno alumno = resultAlumno.get();
            alumno.setTaquilla(resultTaquilla.get());
            Taquilla taquilla = resultTaquilla.get();
            taquilla.setAlumno(alumno);
            alumnoRepository.save(alumno);
            taquillaRepository.save(taquilla);
        }

    }

    public List<AlumnoModel> getAlumnosPag(int nPag, int tPag){
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Alumno> alumnosPag = alumnoRepository.findAll(pageable);
        List<Alumno> alumnos = alumnosPag.getContent();
        List<AlumnoModel> alumnosModel = listAlumnoToListAlumnoModel(alumnos);
        return alumnosModel;
    }


    public int getNumAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.size();
    }
}
