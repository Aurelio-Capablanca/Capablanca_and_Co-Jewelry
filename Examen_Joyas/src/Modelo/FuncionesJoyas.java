/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Conexion;
import Controlador.ConstructorJoyas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

/**
 * @author adalb
 */
public class FuncionesJoyas extends Conexion {

  public Connection cn;

  public FuncionesJoyas() {
    Conexion sn = new Conexion();
    cn = sn.conectar();
  }

  public Integer obtenerClasificacion(String tipo) {
    Integer ids = 0;

    try {
      String sql = "SELECT codigoCla FROM Clasificacion WHERE nomClasif = ?";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setString(1, tipo);

      ResultSet rs = cmd.executeQuery();

      while (rs.next()) {
        ids = rs.getInt(1);
      }
    } catch (SQLException e) {
      System.out.println("Error combo" + e.toString());
    }
    return ids;
  }


  public String seleccionarItemClasificacion(ConstructorJoyas cj) {
    String item = "";
    try {
      String sql = "SELECT nomClasif FROM Clasificacion tc, Piedra cl WHERE tc.codigoCla = cl.codigoCla AND cl.codigoPiedra = ?";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setInt(1, cj.getCodigo());
      ResultSet rs = cmd.executeQuery();

      while (rs.next()) {
        item = rs.getString(1);
      }

    } catch (SQLException e) {
      System.out.println("Error Select " + e.toString());
    }
    return item;

  }

  public DefaultComboBoxModel<String> getClasificacion() {
    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
    try {
      Connection cn = this.conectar();
      String sql = "SELECT nomClasif FROM Clasificacion";
      Statement st = cn.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        modelo.addElement(rs.getString(1));
      }
      cn.close();
      rs.close();
    } catch (SQLException e) {
      System.out.println("error de obtención de combo\n" + e);
    }
    return modelo;
  }


  public boolean guardarJoya(ConstructorJoyas cj) {
    boolean resp = false;
    try {
      String sql = "INSERT INTO Piedra(codigoPiedra,nomPiedra,color,joyeria,codigoCla) VALUES(?,?,?,?,?)";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setInt(1, cj.getCodigo());
      cmd.setString(2, cj.getNombre());
      cmd.setString(3, cj.getColor());
      cmd.setString(4, cj.getJoyeria());
      cmd.setInt(5, cj.getClas());

      if (!cmd.execute()) {
        resp = true;
      }
    } catch (SQLException e) {

      System.out.println("Error de inserción" + e.toString());
    }
    return resp;
  }

  public boolean actualizarJoya(ConstructorJoyas cj) {
    boolean resp = false;
    try {
      String sql = "UPDATE Piedra SET nomPiedra=?, color=?, joyeria=?,codigoCla=? WHERE codigoPiedra=? ";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setString(1, cj.getNombre());
      cmd.setString(2, cj.getColor());
      cmd.setString(3, cj.getJoyeria());
      cmd.setInt(4, cj.getClas());
      cmd.setInt(5, cj.getCodigo());

      if (!cmd.execute()) {
        resp = true;
      }


    } catch (SQLException e) {
      System.out.println(e.toString());
    }
    return resp;
  }


  public boolean eliminarJoya(ConstructorJoyas cj) {
    boolean resp = false;
    try {
      String sql = "DELETE FROM Piedra WHERE codigoPiedra = ?";
      PreparedStatement cmd = cn.prepareStatement(sql);
      cmd.setInt(1, cj.getCodigo());
      if (!cmd.execute()) {
        resp = true;
      }
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
    return resp;
  }

  public int idIncremental() {
    int ids = 1;
    try {
      String sql = "SELECT Max(codigoPiedra) FROM Piedra";
      PreparedStatement cmd = cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      while (rs.next()) {
        ids = rs.getInt(1) + 1;
      }

    } catch (SQLException e) {
      System.out.println(e.toString());
    }
    return ids;
  }


}
