/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equiposdefutbol.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NatanaelManzaneda
 */
public class Main {
    
    public static void main(String [] args){
        ///se ejecuta
         Connection connection = null;
         Statement sentencia = null;
         ResultSet resultadoEquipos = null;
         ResultSet resultadoJugadores = null;
         try {
            // Cargar el driver JDBC para MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Conectar a la base de datos
            String url = "jdbc:mysql://localhost:3306/tpfjava?serverTimezone=UTC";
            String usuario = "root";
            String password = "123456.sa";
            connection = DriverManager.getConnection(url, usuario, password);
            
            sentencia = connection.createStatement();
            
            // 3. Ejecutar la consulta SQL
            resultadoEquipos = sentencia.executeQuery("SELECT NOMBRE, DT, PUNTOS, PARTIDOS_JUGADOS FROM tpfjava.EQUIPO");
            
            // 4. Procesar los resultados de la consulta
            String nombre= "";
            String dt="";
            int puntos = 0;
            int partidosJugados = 0;
            while (resultadoEquipos.next()) {
                 nombre = resultadoEquipos.getString("NOMBRE");
                 dt = resultadoEquipos.getString("DT");
                 puntos = resultadoEquipos.getInt("PUNTOS");
                 partidosJugados = resultadoEquipos.getInt("PARTIDOS_JUGADOS");                
            }
            
            resultadoJugadores = sentencia.executeQuery("SELECT NOMBRE,EDAD FROM tpfjava.JUGADORES");
            
            // 4. Procesar los resultados de la consulta
            String nombreJ= "";
            int edad = 0;
            while (resultadoJugadores.next()) {
                 nombreJ = resultadoJugadores.getString("NOMBRE");
                 edad = resultadoJugadores.getInt("EDAD");
            }

            System.out.println("Conexión exitosa a la base de datos MySQL");
            System.out.println("Equipo :"+nombre);
            System.out.println("Director Tecnico : "+dt);
            System.out.println(String.valueOf(puntos));
            System.out.println(String.valueOf(partidosJugados));
             System.out.println(nombreJ);
             System.out.println(String.valueOf(edad));
             
            

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    
}
