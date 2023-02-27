
package org.xemacscode.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malanchite
 */
public class P_Client {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int ID)
    {
        this.id = ID;
    }
    public String getFname()
    {
        return this.firstName;
    }
    public void setFname(String FNAME)
    {
        this.firstName = FNAME;
    }
     public String getLname()
    {
        return this.lastName;
    }
    public void setLname(String LNAME)
    {
        this.lastName = LNAME;
    }
     public String getPhone()
    {
        return this.phone;
    }
    public void setPhone(String PHONE)
    {
        this.phone = PHONE;
    }
     public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String EMAIL)
    {
        this.email = EMAIL;
    }
     public String getAddress()
    {
        return this.address;
    }
    public void setAddress(String ADDRESS)
    {
        this.address = ADDRESS;
    }
    
    public P_Client(){}
    
    public P_Client(int ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS)
    {
        this.id = ID;
        this.firstName = FNAME;
        this.lastName = LNAME;
        this.phone = PHONE;
        this.email = EMAIL;
        this.address = ADDRESS;
    }

        //Create a function to add Client
        //Create the client
    
       public boolean addNewClient(P_Client client){
         PreparedStatement st;
         Connection con;
        String addQuery = "INSERT INTO `property_client`( `fname`, `lname`, `phone`, `email`, `address`) VALUES (?,?,?,?,?)";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(addQuery);
            
            st.setString(1,client.getFname());
            st.setString(2,client.getLname());
            st.setString(3,client.getPhone());
            st.setString(4,client.getEmail());
            st.setString(5,client.getAddress());
           
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // Create a function to edit the client data
    public boolean editClientData(P_Client client)
    {
         PreparedStatement st;
         Connection con;
        String editQuery = "UPDATE property_client SET fname=?, lname=?, phone=?, email=?, address=? WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(editQuery);
            
            st.setString(1,client.getFname());
            st.setString(2,client.getLname());
            st.setString(3,client.getPhone());
            st.setString(4,client.getEmail());
            st.setString(5,client.getAddress());
            st.setInt(6,client.getId());
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //Create a function to delete the selected client
    public boolean deleteClient(int clientId)
    {
         PreparedStatement st;
         Connection con;
        String deleteQuery = "DELETE FROM property_client WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(deleteQuery);
            
            
            st.setInt(1,clientId);
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //Create a function to return an arraylist of clients
    public ArrayList<P_Client> clientsList()
    {
        
            ArrayList<P_Client> list = new ArrayList<>();
            
            Statement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM property_client";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_Client client;
            
            while(rs.next())
            {
                client = new P_Client(rs.getInt(1),rs.getString(2),
                                        rs.getString(3),rs.getString(4),
                                        rs.getString(5),rs.getString(6));
                
                list.add(client);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
}
