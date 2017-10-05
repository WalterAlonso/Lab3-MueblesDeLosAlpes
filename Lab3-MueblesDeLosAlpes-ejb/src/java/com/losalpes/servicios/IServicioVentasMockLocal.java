/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author Juan Paz
 */
@Local
public interface IServicioVentasMockLocal {
            
    /**
     * Devuelve todas las ventas del sistema
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<RegistroVenta> getVentas();
    
    /**
     * Devuelve todas las ventas por dia de mes del sistema
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<RegistroVenta> getVentasPorDiaMes();

    /**
     * Devuelve todas los años en los que han habido ventas en el sistema
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<Integer> getAniosVentas();

    /**
     * Devuelve todas los meses en los que han habido ventas en el sistema de un
     * año
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<Integer> getMesesAnio(int anio);

    /**
     * Devuelve numéro de ventas por dia en un mes
     *
     * @return ventas Ventas del sistema
     */
    public HashMap<Integer, Integer> getVentasPorDias(int anio, int mes);
}
