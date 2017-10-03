/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ CatalogoBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.beans;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.TipoMueble;
import com.losalpes.servicios.IServicioCatalogoMockLocal;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * Managed bean encargado del catálogo de muebles en el sistema
 * 
 */
public class CatalogoBean implements Serializable
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Representa un nuevo mueble a ingresar
     */
    private Mueble mueble;

     /**
     * Mensaje utilizado para mostrar información importante al usuario.
     */
    private String mensaje;
    
    /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo.
     */
    @EJB
    private IServicioCatalogoMockLocal catalogo;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase principal
     */
    public CatalogoBean()
    {
        mueble=new Mueble();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el objeto mueble
     * @return mueble Objeto mueble
     */
    public Mueble getMueble()
    {
        return mueble;
    }

    /**
     * Modifica el objeto mueble
     * @param mueble Nuevo mueble
     */
    public void setMueble(Mueble mueble)
    {
        this.mueble = mueble;
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     * @return muebles Muebles del sistema
     */
    public List<Mueble> getMuebles()
    {

        return catalogo.darMuebles();
    }
    
    /**
     * Devuelve el mensaje que contiene información sobre algún tipo de estado
     * @return mensaje Mensaje a devolver
     */
    public String getMensaje()
    {
        return mensaje;
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un nuevo mueble al sistema
     */
    public void agregarMueble()
    {
        mensaje = ""; 
        try {
        catalogo.agregarMueble(mueble);
        mueble=new Mueble();
        }
        catch(Exception e){
            mensaje = "Ocurrió un error al momento de crear el mueble: "+ e.getMessage();
        }
    }

    /**
     * Elimina un mueble del sistema
     * @param evento Evento que tiene como parámetro el ID del mueble
     */
    public void eliminarMueble(ActionEvent evento)
    {
        mensaje = "";
        try {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        long inventoryId = Long.parseLong((String) map.get("muebleId"));

        catalogo.eliminarMueble(inventoryId);
        }
        catch(Exception e){
            mensaje = "Ocurrió un error al momento de eliminar el mueble: "+ e.getMessage();
        }
    }
    
    /**
     * Devuelve los tipos de muebles
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposMuebles()
    {
        TipoMueble[] tipos=  TipoMueble.values();
        SelectItem[] sitems = new SelectItem[tipos.length];
        
        for (int i = 0; i < sitems.length; i++)
        {
             sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }
    
    /**
     * Elimina la información del mueble
     */
    public void limpiar()
    {
        mensaje = "";
        mueble=new Mueble();
    }
}
