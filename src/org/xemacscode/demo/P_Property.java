
package org.xemacscode.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Malanchite
 */
public class P_Property {
    
    private int id;
    private int type;
    private int size;
    private int ownerId;
    private String price;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private int age;
    private boolean balcony;
    private boolean pool;
    private boolean backyard;
    private boolean garage;
    private String description;
    
    public P_Property(){}
    
    public P_Property(int ID,int TYPE,int SIZE,int OWNER_ID,String PRICE,String ADDRESS,
            int BEDROOMS,int BATHROOMS,int AGE,boolean BALCONY,boolean POOL,boolean BACKYARD,
            boolean GARAGE,String DESCRIPTION)
    {
        this.id = ID;
        this.type = TYPE;
        this.size = SIZE;
        this.ownerId = OWNER_ID;
        this.price = PRICE;
        this.address = ADDRESS;
        this.bedrooms = BEDROOMS;
        this.bathrooms = BATHROOMS;
        this.age = AGE;
        this.balcony = BALCONY;
        this.pool = POOL;
        this.backyard = BACKYARD;
        this.garage = GARAGE;
        this.description = DESCRIPTION;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isBackyard() {
        return backyard;
    }

    public void setBackyard(boolean backyard) {
        this.backyard = backyard;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    // Create a new function to add a new property
    public boolean addNewProperty(P_Property property)
    {
        PreparedStatement st;
        Connection con;
        String addQuery = "INSERT INTO `the_property`( `type`, `square_feet`, `ownerId`, `price`, `address`, `bedrooms`, `bathrooms`, `age`, `balcony`, `pool`, `backyard`, `garage`, `description`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            
           
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(addQuery);
            st.setInt(1,property.getType());
            st.setInt(2,property.getSize());
            st.setInt(3,property.getOwnerId());
            st.setString(4,property.getPrice());
            st.setString(5,property.getAddress());
            st.setInt(6,property.getBedrooms());
            st.setInt(7,property.getBathrooms());
            st.setInt(8,property.getAge());
            st.setBoolean(9,property.isBalcony());
            st.setBoolean(10,property.isPool());
            st.setBoolean(11,property.isBackyard());
            st.setBoolean(12,property.isGarage());
            st.setString(13,property.getDescription());
            
            
            return (st.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
    }
    // Create a new function to edit a selected property
    public boolean editProperty(P_Property property)
    {
         PreparedStatement st;
        Connection con;
        String editQuery = "UPDATE `the_property` SET `type`=?,`square_feet`=?,`ownerId`=?,`price`=?,`address`=?,`bedrooms`=?,`bathrooms`=?,`age`=?,`balcony`=?,`pool`=?,`backyard`=?,`garage`=?,`description`=? WHERE `id`=?";
        try {
            
           
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(editQuery);
            st.setInt(1,property.getType());
            st.setInt(2,property.getSize());
            st.setInt(3,property.getOwnerId());
            st.setString(4,property.getPrice());
            st.setString(5,property.getAddress());
            st.setInt(6,property.getBedrooms());
           st.setInt(7,property.getBathrooms());
            st.setInt(8,property.getAge());
            st.setBoolean(9,property.isBalcony());
            st.setBoolean(10,property.isPool());
            st.setBoolean(11,property.isBackyard());
            st.setBoolean(12,property.isGarage());
            st.setString(13,property.getDescription());
            st.setInt(14,property.getId());
            
            return (st.executeUpdate()>0);
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    // Create a new function to delete a selected property
    public boolean removeProperty(int propertyId)
    {
         PreparedStatement st;
         Connection con;
        String deleteQuery = "DELETE FROM the_property WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(deleteQuery);
            
            
            st.setInt(1,propertyId);
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // Create a new function to search a selected property by id
    public P_Property findProperty(int propertyId)
    {
        PreparedStatement st;
        ResultSet rs;
        Connection con;
        P_Property property=null;
        String searchQuery = "Select * From the_property where id=?";
        
        try {
          
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(searchQuery);
           st.setInt(1,propertyId);
            rs = st.executeQuery();
            
            if(rs.next()){
            property = new P_Property(rs.getInt("id"),
                    rs.getInt("type"),
                    rs.getInt("square_feet"),
                    rs.getInt("ownerId"),
                    rs.getString("price"),
                    rs.getString("address"),
                    rs.getInt("bedrooms"),
                    rs.getInt("bathrooms"),
                    rs.getInt("age"),
                    rs.getBoolean("balcony"),
                    rs.getBoolean("pool"),
                    rs.getBoolean("backyard"),
                    rs.getBoolean("garage"),
                    rs.getString("description"));
            }
            return property;
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
        return property;
    }
    //Create a new function to return arraylist of properties
    public ArrayList<P_Property> propertiesList()
    {
           ArrayList<P_Property> list = new ArrayList<>();
            
            Statement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM the_property";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_Property property;
            
            while(rs.next())
            {
                property = new P_Property(rs.getInt("id"),
                                        rs.getInt("type"),
                                        rs.getInt("square_feet"),
                                        rs.getInt("ownerId"),
                                        rs.getString("price"),
                                        rs.getString("address"),
                                        rs.getInt("bedrooms"),
                                        rs.getInt("bathrooms"),
                                        rs.getInt("age"),
                                        rs.getBoolean("balcony"),
                                        rs.getBoolean("pool"),
                                        rs.getBoolean("backyard"),
                                        rs.getBoolean("garage"),
                                        rs.getString("description"));
                
                list.add(property);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
    // Create a function to return a list of property depending on the selected type
     public ArrayList<P_Property> propertiesListByType(int typeId)
    {
           ArrayList<P_Property> list = new ArrayList<>();
            
            PreparedStatement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT id,address FROM the_property WHERE type=?";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(selectQuery);
            st.setInt(1,typeId);
            rs=st.executeQuery(selectQuery);
            
            P_Property property;
            
            while(rs.next())
            {
                property = new P_Property(rs.getInt("id"),
                                        rs.getInt("type"),
                                        rs.getInt("square_feet"),
                                        rs.getInt("ownerId"),
                                        rs.getString("price"),
                                        rs.getString("address"),
                                        rs.getInt("bedrooms"),
                                        rs.getInt("bathrooms"),
                                        rs.getInt("age"),
                                        rs.getBoolean("balcony"),
                                        rs.getBoolean("pool"),
                                        rs.getBoolean("backyard"),
                                        rs.getBoolean("garage"),
                                        rs.getString("description"));
                
                list.add(property);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
     
     // Create a function to return a list of owner properties
     public ArrayList<P_Property> propertiesListByOwner(int ownerId)
    {
           ArrayList<P_Property> list = new ArrayList<>();
            
            PreparedStatement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM the_property WHERE ownerId=?";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(selectQuery);
            st.setInt(1,ownerId);
            rs=st.executeQuery(selectQuery);
            
            P_Property property;
            
            while(rs.next())
            {
                property = new P_Property(rs.getInt("id"),
                                        rs.getInt("type"),
                                        rs.getInt("square_feet"),
                                        rs.getInt("ownerId"),
                                        rs.getString("price"),
                                        rs.getString("address"),
                                        rs.getInt("bedrooms"),
                                        rs.getInt("bathrooms"),
                                        rs.getInt("age"),
                                        rs.getBoolean("balcony"),
                                        rs.getBoolean("pool"),
                                        rs.getBoolean("backyard"),
                                        rs.getBoolean("garage"),
                                        rs.getString("description"));
                
                list.add(property);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
     
     
     
     
       // Create a new function to add a new image to the property
    public boolean addImage(int propertyId,String the_image_path)
    {
        PreparedStatement st;
        Connection con;
        String addQuery = "INSERT INTO property_images(property_id,the_image)VALUES(?,?)";
        try {
            
            try {
                FileInputStream propertyImage = new FileInputStream(new File(the_image_path));
                con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
                st=con.prepareStatement(addQuery);
                st.setInt(1,propertyId);
                st.setBinaryStream(2,propertyImage);
                return (st.executeUpdate()>0);
            } catch (FileNotFoundException ex) {
               // Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null,ex.getMessage()+"Invalid File","Image Error",2);
                return false;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
       
    }
    // Create a function to get the selected property images list
    public HashMap<byte[],Integer> propertyImagesList(int propertyId)
    {
            HashMap<byte[],Integer> list = new HashMap<>();
            
            PreparedStatement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM property_images WHERE property_id = ?";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(selectQuery);
            st.setInt(1,propertyId);
            rs=st.executeQuery();
            
            while(rs.next())
            {
                list.put(rs.getBytes("the_image"), rs.getInt("id"));
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
     
    // Create a function to get images by id
    public byte[] getImageById(int imageId)
    {       
            PreparedStatement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT the_image FROM property_images WHERE id = ?";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(selectQuery);
            st.setInt(1,imageId);
            rs=st.executeQuery();
            
            if(rs.next())
            {
                return rs.getBytes("the_image");
            }
            else 
            {
                return null;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
             
    }

// Create a function to remove images by id
    public boolean removePropertyImage(int imageId)
    {       
            PreparedStatement st;
            ResultSet rs;
            Connection con;
            
            String deleteQuery = "DELETE FROM property_images WHERE id=?";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(deleteQuery);
            st.setInt(1,imageId);
            
            return (st.executeUpdate()>0);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Property.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
             
    }
}

