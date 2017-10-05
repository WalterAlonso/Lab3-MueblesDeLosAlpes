/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.entities.RegistroVenta;
import com.losalpes.servicios.IServicioVentasMockLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Juan Paz
 */
@Named(value = "ventasBean")

public class VentasBean implements Serializable {

    /**
     * Relación con la interfaz que provee los servicios necesarios de las
     * ventas
     */
    @EJB
    private IServicioVentasMockLocal ventas;

    /**
     * Año seleccionado
     */
    private int anio;

    /**
     * Mes seleccionado
     */
    private int mes;

    /**
     * Lista con los meses del año seleccionado
     */
    private ArrayList<Integer> meses;

    /**
     * Lista con las ventas por dias del mes seleccionado
     */
    private HashMap<Integer, Integer> ventasDias;

    /**
     * Variable para usar la gráfica de tipo Pie de PrimeFaces
     */
    private PieChartModel grafica;

    /**
     * Constructor de la clase
     */
    public VentasBean() {
        ventasDias = new HashMap<>();
        meses = new ArrayList<>();
        grafica = new PieChartModel();
    }

    /**
     * Devuelve todas las ventas del sistema
     *
     * @return ventas Ventas del sistema
     */
    public ArrayList<RegistroVenta> getVentas() {
        return ventas.getVentas();
    }

    /**
     * Devuelve el año seleccionado
     *
     * @return anio Año seleccionado
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Modifica el año seleccionado
     *
     * @param anio Año seleccionado
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Devuelve el mes seleccionado
     *
     * @return mes Mes seleccionado
     */
    public int getMes() {
        return mes;
    }

    /**
     * Modifica el mes seleccionado
     *
     * @param mes Mes seleccionado
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Devuelve numéro de ventas por dia en un mes
     *
     * @return ventas Ventas del sistema por dia en un mes
     */
    public HashMap<Integer, Integer> getVentasDias() {
        return ventasDias;
    }

    /**
     * Devuelve lista de años en los que han habido ventas
     *
     * @return años Lista de años del sistema
     */
    public ArrayList<Integer> getAnios() {
        return ventas.getAniosVentas();
    }

    /**
     * Devuelve lista de meses
     *
     * @return años Lista de meses del sistema
     */
    public ArrayList<Integer> getMeses() {
        return meses;
    }

    /**
     * Devuelve modelo para hacer graficas
     *
     * @return PieChartModel modelo de graficas de primefaces
     */
    public PieChartModel getGrafica() {
        return grafica;
    }

    /**
     * Devuelve lista de meses del año seleccionado
     */
    public void anioSeleccionado() {
        meses = ventas.getMesesAnio(anio);
    }

    /**
     * Devuelve lista de dias de ventas del mes seleccionado
     */
    public void mesSeleccionado() {
        ventasDias = ventas.getVentasPorDias(anio, mes);
        crearGrafica();
    }

    /**
     * Crea la gráfica del mes 
     */
    private void crearGrafica() {
        grafica = new PieChartModel();
        for (Map.Entry<Integer, Integer> entry : ventasDias.entrySet()) {
            grafica.set(entry.getKey().toString(), entry.getValue());
        }
        grafica.setTitle("Ventas del mes " + mes + " por dia");
        grafica.setLegendPosition("w");
    }

}
