
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
public class P_Owner {
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
    
    public P_Owner(){}
    
    public P_Owner(int ID,String FNAME,String LNAME,String PHONE,String EMAIL,String ADDRESS)
    {
        this.id = ID;
        this.firstName = FNAME;
        this.lastName = LNAME;
        this.phone = PHONE;
        this.email = EMAIL;
        this.address = ADDRESS;
    }

//Create a function to add Owner
    //Create the owner
    
    public boolean addNewOwner(P_Owner owner){
         PreparedStatement st;
         Connection con;
        String addQuery = "INSERT INTO `property_owner`( `fname`, `lname`, `phone`, `email`, `address`) VALUES (?,?,?,?,?)";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(addQuery);
            
            st.setString(1,owner.getFname());
            st.setString(2,owner.getLname());
            st.setString(3,owner.getPhone());
            st.setString(4,owner.getEmail());
            st.setString(5,owner.getAddress());
           
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // Create a function to edit the owner data
    public boolean editOwnerData(P_Owner owner)
    {
         PreparedStatement st;
         Connection con;
        String editQuery = "UPDATE property_owner SET fname=?, lname=?, phone=?, email=?, address=? WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(editQuery);
            
            st.setString(1,owner.getFname());
            st.setString(2,owner.getLname());
            st.setString(3,owner.getPhone());
            st.setString(4,owner.getEmail());
            st.setString(5,owner.getAddress());
            st.setInt(6,owner.getId());
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //Create a function to delete the selected owner 
    public boolean deleteOwner(int ownerId)
    {
         PreparedStatement st;
         Connection con;
        String deleteQuery = "DELETE FROM property_owner WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(deleteQuery);
            
            
            st.setInt(1,ownerId);
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //Create a function to return an arraylist of owners
    public ArrayList<P_Owner> ownersList()
    {
        
            ArrayList<P_Owner> list = new ArrayList<>();
            
            Statement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM property_owner";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_Owner owner;
            
            while(rs.next())
            {
                owner = new P_Owner(rs.getInt(1),rs.getString(2),
                                        rs.getString(3),rs.getString(4),
                                        rs.getString(5),rs.getString(6));
                
                list.add(owner);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Owner.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
}
