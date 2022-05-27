package com.ces.almacen.converters;

import com.ces.almacen.entities.Armario;
import com.ces.almacen.entities.Persona;
import com.ces.almacen.entities.Profesor;
import com.ces.almacen.models.ArmarioModel;
import com.ces.almacen.models.ProfesorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferencesFactory;

@Lazy
@Component
public class ProfesorConverter {

    @Lazy
    @Autowired
    private ArmarioConverter armarioConverter;

    public ProfesorModel entityToModel(Profesor profesor){
        ProfesorModel profesorModel = new ProfesorModel();

       Persona persona = profesor.getPersona();
        profesorModel.setProfesorId(profesor.getId());

        profesorModel.setNumSs(profesor.getNumSs());
        profesorModel.setSalario(profesor.getSalario());
        profesorModel.setDomicilio(profesor.getDomicilio());
        profesorModel.setPoblacion(profesor.getPoblacion());
        profesorModel.setProvincia(profesor.getProvincia());
        profesorModel.setCodigoPostal(profesor.getCodigoPostal());
        profesorModel.setTelefono(profesor.getTelefono());
        profesorModel.setMovil(profesor.getMovil());
        profesorModel.setFormaPago(profesor.getFormaPago());
        profesorModel.setEntidadDeCargo(profesor.getEntidadDeCargo());
        profesorModel.setCuentaBancaria(profesor.getCuentaBancaria());
        profesorModel.setPersonaId(persona.getId());
        profesorModel.setNombre(persona.getNombre());
        profesorModel.setApellido(persona.getApellido());
        profesorModel.setDni(persona.getDni());
        profesorModel.setMail(persona.getMail());
        profesorModel.setTipo(persona.getTipo());

        if (profesor.getArmarios()!=null) {
            List<Armario> armarios = profesor.getArmarios();

            profesorModel.setArmarios(armarioConverter.listEntityToListModel(armarios));
        }
        return profesorModel;
    }



    public Profesor modelToEntity (ProfesorModel profesorModel){
        Profesor profesor = new Profesor();
        profesor.setId(profesorModel.getProfesorId());
        profesor.setNumSs(profesorModel.getNumSs());
        profesor.setSalario(profesorModel.getSalario());
        profesor.setDomicilio(profesorModel.getDomicilio());
        profesor.setPoblacion(profesorModel.getPoblacion());
        profesor.setProvincia(profesorModel.getProvincia());
        profesor.setCodigoPostal(profesorModel.getCodigoPostal());
        profesor.setTelefono(profesorModel.getTelefono());
        profesor.setMovil(profesorModel.getMovil());
        profesor.setFormaPago(profesorModel.getFormaPago());
        profesor.setEntidadDeCargo(profesorModel.getEntidadDeCargo());
        profesor.setCuentaBancaria(profesorModel.getCuentaBancaria());

       Persona persona = new Persona();
        persona.setId(profesorModel.getPersonaId());
        persona.setNombre(profesorModel.getNombre());
        persona.setApellido(profesorModel.getApellido());
        persona.setMail(profesorModel.getMail());
        persona.setTipo(profesorModel.getTipo());
        persona.setDni(profesorModel.getDni());
        profesor.setPersona(persona);

        return profesor;
    }




}
