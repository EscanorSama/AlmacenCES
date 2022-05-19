package com.ces.almacen.services;

import com.ces.almacen.converters.TaquillaConverter;
import com.ces.almacen.entities.Alumno;
import com.ces.almacen.entities.Contenedor;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.entities.Taquilla;
import com.ces.almacen.models.TaquillaModel;
import com.ces.almacen.repositories.AlumnoRepository;
import com.ces.almacen.repositories.ContenedorRepository;
import com.ces.almacen.repositories.TaquillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaquillaService {
    @Autowired
    private TaquillaRepository taquillaRepository;
    @Autowired
    private TaquillaConverter taquillaConverter;
    @Autowired
    private ContenedorService contenedorService;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private ContenedorRepository contenedorRepository;


    public TaquillaModel insertTaquilla(TaquillaModel taquillaModel) {
        Contenedor contenedor = contenedorService.insertContenedor(taquillaModel,"Taquilla");
        Taquilla taquilla = taquillaConverter.modelToEntity(taquillaModel);
        taquilla.setContenedor(contenedor);

        /*if (taquillaModel.getAlumnoId()!=0){ //hay alumno asociado
            Optional<Alumno> alumno = alumnoRepository.findById(taquillaModel.getAlumnoId());
            if (alumno.isPresent()){  //el alumno existe en la base de datos
                taquilla.setAlumno(alumno.get());
            }
        }*/
        taquillaModel.setTaquillaId(taquillaRepository.save(taquilla).getId());
        return taquillaModel;
    }

    public Optional<TaquillaModel> deleteTaquilla(Long id) {
        Optional<TaquillaModel> resultTm = Optional.empty();
        Optional<Taquilla> result = taquillaRepository.findById(id);
        if(result.isPresent()){
            Taquilla taquilla = result.get();
            TaquillaModel taquillaModel = taquillaConverter.entityToModel(taquilla);
            resultTm = Optional.of(taquillaModel);
            taquillaRepository.delete(taquilla);
        }
        return resultTm;
    }

    public Optional<TaquillaModel> getTaquilla(Long id) {
        Optional<TaquillaModel> resultTm = Optional.empty();
        Optional<Taquilla> result = taquillaRepository.findById(id);
        if (result.isPresent()){
            Taquilla taquilla = result.get();
            TaquillaModel taquillaModel = taquillaConverter.entityToModel(taquilla);
            resultTm = Optional.of(taquillaModel);
        }
        return resultTm;
    }

    public List<TaquillaModel> getTaquillas() {
        List<Taquilla> taquillas = taquillaRepository.findAll();
        List<TaquillaModel> taquillasModel = listTaquillasToListTaquillasModel(taquillas);
        return taquillasModel;
    }

    private List<TaquillaModel> listTaquillasToListTaquillasModel(List<Taquilla> taquillas) {
        List<TaquillaModel> taquillasModel = new ArrayList<>();
        for (Taquilla taquilla: taquillas) {
            TaquillaModel taquillaModel = taquillaConverter.entityToModel(taquilla);
            taquillasModel.add(taquillaModel);
        }
        return taquillasModel;
    }

    public void updateTaquilla(TaquillaModel taquillaModel) {
        Optional<Taquilla> result = taquillaRepository.findById(taquillaModel.getTaquillaId());
        if (result.isPresent()){
            Taquilla taquilla = result.get();
            Contenedor contenedor = taquilla.getContenedor();
            contenedor.setZona(taquillaModel.getZona());
            contenedor.setDescripcion(taquillaModel.getDescripcion());
            contenedor.setNumero(taquillaModel.getNumero());
            contenedorRepository.save(contenedor);
            taquillaRepository.save(taquilla);
        }
    }

    public List<TaquillaModel> postTaquillas(List<TaquillaModel> taquillasModel) {
        for (TaquillaModel taquillaModel: taquillasModel) {
            insertTaquilla(taquillaModel);
        }
        return taquillasModel;
    }

    public List<TaquillaModel> getTaquillasPag(int nPag, int tPag){
        Pageable pageable = PageRequest.of(nPag, tPag);
        Page<Taquilla> taquillasPag = taquillaRepository.findAll(pageable);
        List<Taquilla> taquillas = taquillasPag.getContent();
        List<TaquillaModel> taquillasModel = listTaquillasToListTaquillasModel(taquillas);
        return taquillasModel;
    }

    public int getNumTaquillas() {
        List<Taquilla> taquillas = taquillaRepository.findAll();
        return taquillas.size();
    }
}
