/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Juan Paz
 */
@Remote
public interface IServicioVentasMockRemote {

    /**
     * Devuelve todas las ventas del sistema
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<RegistroVenta> getVentas();
}
