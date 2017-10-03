/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.excepciones.OperacionInvalidaException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del catalogo en el sistema.
 * @author WALTER-SEBASTIAN
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase sin argumentos
     */
     public ServicioCatalogoMock()
     {
     }
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioCatalogoMockLocal catalogo;
    
    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    @Override
    public void agregarMueble(Mueble mueble) throws OperacionInvalidaException {
        try {
           persistencia.create(mueble);                  
        }
        catch(Exception ex)
        {
            throw new OperacionInvalidaException(ex.getMessage());
        }
    }
        
    /**
     * Elimina un mueble del sistema
     * @param id Identificador único del mueble a eliminar
     */
    @Override
    public void eliminarMueble(long id) throws OperacionInvalidaException {
       try
        {
        Mueble mueble=(Mueble) persistencia.findById(Mueble.class, id);
        persistencia.delete(mueble);
        }
        catch(OperacionInvalidaException e)
        {
            throw new OperacionInvalidaException("Ocurrió un error al momento de eliminar:"+e.getMessage());
        }
    }

    /**
     * Devuelve todos los muebles del sistema
     * @return muebles Lista de muebles
     */
    @Override
    public List<Mueble> darMuebles() {
       return(ArrayList<Mueble>) persistencia.findAll(Mueble.class);
    }

    /**
     * Remueve un ejemplar del mueble (no el mueble)
     * @param id Identificador único del mueble
     */
    @Override
    public void removerEjemplarMueble(long id) {
        Mueble mueble=(Mueble) persistencia.findById(Mueble.class, id);
        mueble.reducirCantidad();
        persistencia.update(mueble);        
    }
}