/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMockTest.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;

import com.losalpes.entities.Mueble;
import com.losalpes.entities.Vendedor;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase encargada de realizar pruebas unitarias
 * 
 */
public class ServicioCatalogoMockTest {
    
     //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Interface con referencia al servicio de catalogo en el sistema
     */
    private IServicioCatalogoMockRemote servicio;

    //-----------------------------------------------------------
    // Métodos de inicialización y terminación
    //-----------------------------------------------------------

    /**
     * Método que se ejecuta antes de comenzar la prueba unitaria
     * Se encarga de inicializar todo lo necesario para la prueba
     */
    @Before
    public void setUp() throws Exception
    {
        try
        {
            Properties env = new Properties();
            env.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            env.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");
            InitialContext contexto;
            contexto = new InitialContext(env);
            servicio = (IServicioCatalogoMockRemote) contexto.lookup("com.losalpes.servicios.IServicioCatalogoMockRemote");
        } 
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    //-----------------------------------------------------------
    // Métodos de prueba
    //-----------------------------------------------------------
    
    /**
     * Método de prueba para agregar un mueble al sistema
     */
    @Test
    public void testAgregarMueble() throws Exception
    {
        Mueble mueble = null;
        servicio.agregarMueble(mueble);
    }

    /**
     * Método de prueba para eliminar un mueble al sistema
     */
    @Test
    public void testEliminarMueble() throws Exception
    {
        servicio.eliminarMueble(1L);
    }
        
    /**
     * Método de prueba para remover un ejemplar de un mueble del sistema
     */
    @Test
    public void testRemoverEjemplarMueble() throws Exception
    {
        servicio.removerEjemplarMueble(2L);
    }
}
