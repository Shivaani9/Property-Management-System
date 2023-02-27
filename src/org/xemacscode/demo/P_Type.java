
package org.xemacscode.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Malanchite
 */
public class P_Type {
    
    private int id;
    private String name;
    private String description;
    
    public Integer getId()
    {
        return id;
    
    }
    public void setId(Integer ID)
    {
        this.id = ID;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String NAME)
    {
        this.name = NAME;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String DESCRIPTION)
    {
        this.description = DESCRIPTION;
    }
    
    public P_Type(){}
    
    public P_Type(Integer ID, String NAME, String DESCRIPTION)
    {
        this.id = ID;
        this.name = NAME;
        this.description = DESCRIPTION;
    }
    
    public boolean execTypeQuery(String queryType,P_Type type)
    {
        PreparedStatement st;
        Connection con;
        
        if(queryType.equals("add"))
        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
                st=con.prepareStatement("INSERT INTO property_type(name,description)values(?,?)");
                st.setString(1,type.getName());
                st.setString(2,type.getDescription());
                
                return (st.executeUpdate()>0);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }
        
        
        else if(queryType.equals("edit"))
        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
                st=con.prepareStatement("UPDATE property_type SET name=?,description=? WHERE id=?");
                st.setString(1,type.getName());
                st.setString(2,type.getDescription());
                st.setInt(3,type.getId());
                
                return (st.executeUpdate()>0);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }
        
         else if(queryType.equals("remove"))
        {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
                st=con.prepareStatement("DELETE from property_type WHERE id=?");
               
                st.setInt(1,type.getId());
                
                return (st.executeUpdate()>0);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
           
        }
         else {
             JOptionPane.showMessageDialog(null,"Enter the correct Query (add,edit,remove)","Invalid Operation",2);
             return false;
         }
    }
    // Create a function to return a list of all types using a hashmap
    public HashMap<String,Integer> getTypesMap()
    {
        HashMap<String,Integer> map = new HashMap<>();
        Statement st;
        ResultSet rs;
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.createStatement();
            rs = st.executeQuery("Select * FROM property_type");
            
            P_Type type;
            while(rs.next())
            {
                type = new P_Type(rs.getInt(1),rs.getString(2),rs.getString(3));
                map.put(type.getName(),type.getId());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return map;
    }
    
    //create a function to get the type data by id
    public P_Type getTypeById(Integer id)
    {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        P_Type type = new P_Type();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement("SELECT * FROM property_type WHERE id=?");
            st.setInt(1,id);
            rs = st.executeQuery();
            
            if(rs.next())
            {
                type.setId(id);
                   type.setName(rs.getString(2));
                   type.setDescription(rs.getString(3));
                
            }
            
            
            } catch (SQLException ex) {
            Logger.getLogger(P_Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        return type;
    }
}
