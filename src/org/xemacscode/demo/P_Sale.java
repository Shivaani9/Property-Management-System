
package org.xemacscode.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malanchite
 */
public class P_Sale {
    
    private int id;
    private int propertyId;
    private int clientId;
    private String finalPrice;
    private String sellingDate;
    
    public P_Sale(){}
    
    public P_Sale(int ID,int PROPERTY_ID,int CLIENT_ID,String FINAL_PRICE,String SELLING_DATE)
    {
        this.id = ID;
        this.propertyId = PROPERTY_ID;
        this.clientId = CLIENT_ID;
        this.finalPrice = FINAL_PRICE;
        this.sellingDate = SELLING_DATE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(String sellingDate) {
        this.sellingDate = sellingDate;
    }
    
     //Create a function to add new sale
       public boolean addNewSale(P_Sale sale){
         PreparedStatement st;
         Connection con;
        String addQuery = "INSERT INTO sale (property_id,client_id,final_price,sale_date) VALUES (?,?,?,?)";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(addQuery);
            
            st.setInt(1,sale.getPropertyId());
            st.setInt(2,sale.getClientId());
            st.setString(3,sale.getFinalPrice());
            st.setString(4,sale.getSellingDate());
            
           
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Sale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    // Create a function to edit the client data
    public boolean editSale(P_Sale sale)
    {
         PreparedStatement st;
         Connection con;
        String editQuery = "UPDATE sale SET property_id=?, client_id=?, final_price=?, sale_date=? WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(editQuery);
            
            st.setInt(1,sale.getPropertyId());
            st.setInt(2,sale.getClientId());
            st.setString(3,sale.getFinalPrice());
            st.setString(4,sale.getSellingDate());
            st.setInt(5,sale.getId());
            
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Sale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //Create a function to delete the selected sale
    public boolean deleteSale(int saleId)
    {
         PreparedStatement st;
         Connection con;
        String deleteQuery = "DELETE FROM sale WHERE id=?";
        
        try {
           
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.prepareStatement(deleteQuery);
            
            
            st.setInt(1,saleId);
            return (st.executeUpdate() > 0);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(P_Sale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<P_Sale> salesList()
    {
        
            ArrayList<P_Sale> list = new ArrayList<>();
            
            Statement st;
            ResultSet rs;
            Connection con;
            
            String selectQuery = "SELECT * FROM sale";
            try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            st=con.createStatement();
            rs=st.executeQuery(selectQuery);
            
            P_Sale sale;
            
            while(rs.next())
            {
                sale = new P_Sale(rs.getInt(1),
                                   rs.getInt(2),
                                   rs.getInt(3),
                                   rs.getString(4),
                                   rs.getString(5));
                
                list.add(sale);
            }
            
           
        } catch (SQLException ex) {
            Logger.getLogger(P_Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    }
}
