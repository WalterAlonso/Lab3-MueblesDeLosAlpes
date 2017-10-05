/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Juan Paz
 */
@Named(value = "ventasBean")

public class VentasBean implements Serializable {

    /**
     * Relación con la interfaz que provee los servicios necesarios del carrito
     * de compras
     */
    @EJB
    private IServicioVentasMockLocal ventas;

    private int anio;

    private ArrayList<Integer> meses;

    private HashMap<Integer, Integer> ventasDias;

    private int mes;

    private boolean mesVisible;

    /**
     * Creates a new instance of VentasBean
     */
    public VentasBean() {
        ventasDias = new HashMap<>();
        meses = new ArrayList<>();
        mesVisible = false;
    }

    public ArrayList<RegistroVenta> getVentas() {
        return ventas.getVentas();
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public HashMap<Integer, Integer> getVentasDias() {
        return ventasDias;
    }

    public boolean isMesVisible() {
        return mesVisible;
    }

    public void setMesVisible(boolean mesVisible) {
        this.mesVisible = mesVisible;
    }

    public ArrayList<Integer> getAnios() {
        return ventas.getAniosVentas();
    }

    public ArrayList<Integer> getMeses() {
        return meses;
    }

    public void anioSeleccionado() {
        meses = ventas.getMesesAnio(anio);
    }

    public void mesSeleccionado() {
        ventasDias = ventas.getVentasPorDias(anio, mes);
    }

}
