/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kholis
 */
public class koneksi {
    
    public static  Connection konek ()
    {
    Connection con = null;
    String url="jdbc:mysql://localhost/belajar";
    String id="root";
    String pass="";
    
    if (con==null)
    {
            try {
                con=DriverManager.getConnection(url,id,pass);
               // JOptionPane.showMessageDialog(null, "sukses");
                
            } catch (SQLException ex) {
                
                Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
                
                JOptionPane.showMessageDialog(null, "gagal"+ex);
            }
        
    }
    return con;
    }
    
    
    public static ResultSet ambilquery(String sql)
    {
        ResultSet hasil=null;
        try {
            Statement st = konek().createStatement();
            hasil= st.executeQuery(sql);
          //JOptionPane.showMessageDialog(null, "Sukses");
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null, "Gagal"+ex);
        }
    return hasil;
    }
         
   
    public static  int jalankanquery(String sql)
    {
        int hasil=0;
        try {
            Statement st = konek().createStatement();
            hasil=st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Sukses"); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal"+ex);
        }
        return hasil;
    }
}
