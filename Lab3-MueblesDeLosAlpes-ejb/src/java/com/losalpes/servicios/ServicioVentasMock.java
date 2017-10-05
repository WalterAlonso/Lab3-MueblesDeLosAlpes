/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.entities.RegistroVenta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Juan Paz
 */
@Stateless
public class ServicioVentasMock implements IServicioVentasMockLocal, IServicioVentasMockRemote {

    /**
     * Interface con referencia al servicio de persistencia en el sistema
     */
    @EJB
    private IServicioPersistenciaMockLocal persistencia;

    public ServicioVentasMock() {
    }

    /**
     * Devuelve todas las ventas del sistema
     *
     * @return ventas Ventas del sistema
     */
    @Override
    public ArrayList<RegistroVenta> getVentas() {
        return (ArrayList) persistencia.findAll(RegistroVenta.class);
    }

    /**
     * Devuelve todas las ventas por dia de mes del sistema
     *
     * @return ventas Ventas del sistema
     */
    @Override
    public ArrayList<RegistroVenta> getVentasPorDiaMes() {
        ArrayList<RegistroVenta> ventas = (ArrayList) persistencia.findAll(RegistroVenta.class);
        RegistroVenta venta;
        for (int i = 0, max = ventas.size(); i < max; i++) {
            venta = (RegistroVenta) ventas.get(i);

        }
        return null;
    }

    /**
     * Devuelve todas los años en los que han habido ventas en el sistema
     *
     * @return ventas Ventas del sistema
     */
    @Override
    public ArrayList<Integer> getAniosVentas() {
        ArrayList<RegistroVenta> ventas = (ArrayList) persistencia.findAll(RegistroVenta.class);
        ArrayList<Integer> anios = new ArrayList<Integer>();
        RegistroVenta venta;
        for (int i = 0, max = ventas.size(); i < max; i++) {
            venta = (RegistroVenta) ventas.get(i);
            Calendar fecha = toCalendar(venta.getFechaVenta());
            int anio = fecha.get(Calendar.YEAR);
            if (!anios.contains(anio)) {
                anios.add(anio);
            }

        }
        return anios;
    }

    /**
     * Devuelve todas los meses en los que han habido ventas en el sistema de un
     * año
     * @param anio, año del cual se quieren obtener los meses
     * @return ventas Ventas del sistema
     */
    @Override
    public ArrayList<Integer> getMesesAnio(int anio) {
        ArrayList<RegistroVenta> ventas = (ArrayList) persistencia.findAll(RegistroVenta.class);
        ArrayList<Integer> meses = new ArrayList<>();
        RegistroVenta venta;
        for (int i = 0, max = ventas.size(); i < max; i++) {
            venta = (RegistroVenta) ventas.get(i);
            Calendar fecha = toCalendar(venta.getFechaVenta());
            if (fecha.get(Calendar.YEAR) == anio) {
                int mes = fecha.get(Calendar.MONTH) + 1;
                if (!meses.contains(mes)) {
                    meses.add(mes);
                }
            }
        }
        return meses;
    }

    /**
     * Devuelve numéro de ventas por dia en un mes
     * @param anio, año del cual se quieren obtener los reportes
     * @param mes, mes del cual se quieren obtener los reportes
     * @return ventas Ventas del sistema
     */
    @Override
    public HashMap<Integer, Integer> getVentasPorDias(int anio, int mes) {
        ArrayList<RegistroVenta> ventas = (ArrayList) persistencia.findAll(RegistroVenta.class);
        HashMap<Integer, Integer> ventasPorDias = new HashMap<Integer, Integer>();

        RegistroVenta venta;
        for (int i = 0, max = ventas.size(); i < max; i++) {
            venta = (RegistroVenta) ventas.get(i);
            Calendar fecha = toCalendar(venta.getFechaVenta());
            if (fecha.get(Calendar.YEAR) == anio) {
                if ((fecha.get(Calendar.MONTH) + 1) == mes) {
                    int numeroVentas = 1;
                    int dia = fecha.get(Calendar.DATE);
                    if (ventasPorDias.containsKey(dia)) {
                        numeroVentas = ventasPorDias.get(dia);
                        numeroVentas++;
                    }
                    ventasPorDias.put(dia, numeroVentas);
                }
            }
        }
        return ventasPorDias;
    }

    private static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

}
