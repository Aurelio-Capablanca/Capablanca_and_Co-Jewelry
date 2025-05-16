/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author adalb
 */
public class Conexion {
    
     public Connection conectar() {
        Connection cn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            cn = DriverManager.getConnection("jdbc:sqlserver://SUN\\MSSQLSERVER;"
                 +"databaseName=DB_Joyas;IntegratedSecurity=true;");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cn;

    }
    
}
