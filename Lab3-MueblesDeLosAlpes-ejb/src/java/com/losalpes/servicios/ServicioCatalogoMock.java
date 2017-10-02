/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del catalogo en el sistema.
 * @author WALTER-SEBASTIAN
 */
@Stateless
public class ServicioCatalogoMock implements IServicioCatalogoMockLocal, IServicioCatalogoMockRemote{
    
    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioCatalogoMockLocal catalogo;
    
    @Override
    public void agregarMueble(Mueble mueble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMueble(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mueble> darMuebles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerEjemplarMueble(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
