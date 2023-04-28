/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equiposdefutbol.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NatanaelManzaneda
 */
public class DatabaseManager {
    

    private Connection connection = null;


    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
        }
    }
}
