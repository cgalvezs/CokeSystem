package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.UsuariosDAO;
import cl.ciisa.cokedb.dao.interfaces.IUsuariosDAO;
import cl.ciisa.cokedb.model.UsuarioBeans;


public class TestConnectionsOfUsuarios {
   static String bd = "CokeDb";
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost/"+bd;

   public static void main(String[] args) throws Exception {
	   Connection conn = null;

	   try {
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		   conn = DriverManager.getConnection(url,login,password);
		   if (conn != null){
			   System.out.println("Conexion a base de datos "+url+" ... Ok");
			   
			   UsuariosDAO invListDAO = new UsuariosDAO(conn);
			   
			   //Insertar Usuario
			   
			   UsuarioBeans ulist = new UsuarioBeans(); 

			   
			   
			   ulist.setNombreUsuario("Series_Pepito2");
			   ulist.setNombre("Pepito2");
			   ulist.setApellidos("Series2");
			   ulist.setPassword("pepito_la_lleva2");
			   ulist.setActivo(1);
			   ulist.setTipoUsuario(2);
			   
			   
			   //long pk = invListDAO.insert(ulist);
			  
			   //Listar usuarios
			   
			   ArrayList<UsuarioBeans> lstUserlist = invListDAO.getAll();
			   
			   for(UsuarioBeans tu : lstUserlist)
				   System.out.println("id = " + tu.getIdUsuario() + " Nombre Usuario = " + tu.getNombreUsuario() + " Nombre = " + tu.getNombre() + " Apellido = " + tu.getApellidos() + " Password = " + tu.getPassword()+ " Tipo Usuario = " + tu.getTipoUsuario() +  " Activo? = " + tu.getActivo());
			   
			   //Borrar
			   //usuarioDAO.delete(1);
			   //Update
			   
			   ulist.setIdUsuario(2);
			   
			   invListDAO.update(ulist);
			   
			   //userListDAO.update(ulist);
			   
			   //usuario.setNombre("Tomas");
			   //usuarioDAO.update(usuario);
		   
		   }
	   } catch(SQLException ex){
		   System.out.println(ex);
	   } catch(ClassNotFoundException ex){
		   System.out.println(ex);
	   } finally {
    	  conn.close();
	   }
   }
   
   
}
