/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.upeu.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.upeu.config.Conexion;

/**
 *
 * @author alum.fial8
 */
public class UsuarioDAO {
    private Connection cx;
    private Statement st;
    private ResultSet rs;
    private String sql;
    private int op=0;
    public int validarUsuario(String user, String clave){
        sql ="SELECT * FROM usuario WHERE usuario='"+user+"' AND clave='"+clave+"'";  
        try
        {
            cx= Conexion.getConexion();
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                op=1;
            }else{
                op=2;
            }
        }catch(SQLException e){
        }
        return op;
    }
    
}
