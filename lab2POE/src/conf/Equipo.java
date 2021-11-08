/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author andyg
 */
public class Equipo {
      private int id_equipo;
    private String nombre_equipo;

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String toString() {
        return this.nombre_equipo;
    }

    public Vector<Equipo> mostrarEquipo() {

        conexion conn = new conexion();
        Connection conet = conn.getConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement ps = null;

        Vector<Equipo> datos = new Vector<Equipo>();
        Equipo dat = null;
        try {
            String sql = "SELECT * FROM equipo";
            ps = conet.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Equipo();
            dat.setId_equipo(0);
            dat.setNombre_equipo("CONSULAR JUGADORES POR EQUIPO");
            datos.add(dat);

            while (rs.next()) {
                dat = new Equipo();
                dat.setId_equipo(rs.getInt("id_equipo"));
                dat.setNombre_equipo(rs.getString("nombre_equipo"));
                datos.add(dat);
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return datos;
    }
    
}
