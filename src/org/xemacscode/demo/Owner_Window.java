
package org.xemacscode.demo;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malanchite
 */
public class Owner_Window extends javax.swing.JFrame {

    /**
     * Creates new form Owner_Window
     */
    public Owner_Window() {
        initComponents();
        
        MatteBorder panel_border = BorderFactory.createMatteBorder(0,0,3,0,new Color(60,70,200));
        jPanel_Title.setBorder(panel_border);
        
        MatteBorder button_border = BorderFactory.createMatteBorder(3,3,3,3, new Color(255,255,255));
        jButton_Add_Owner.setBorder(button_border);
        jButton_Edit_Owner.setBorder(button_border);
        jButton_Remove_Owner.setBorder(button_border);
        jButton_Refresh_Owner.setBorder(button_border);
        jButton_Owner_Properties.setBorder(button_border);
        
        fillJtableWithOwnersData();
    }

    // we will create a function to populate jtable with all the owners data
    public void fillJtableWithOwnersData()
    {
        P_Owner owner = new P_Owner();
        ArrayList<P_Owner> ownersList = owner.ownersList();
        
        String[] colNames = {"ID","First Name","Last Name","Phone","Email","Address"};
        
        Object[][] rows = new Object[ownersList.size()][6];
        
        for(int i=0;i<ownersList.size();i++)
        {
            rows[i][0] = ownersList.get(i).getId();
            rows[i][1] = ownersList.get(i).getFname();
            rows[i][2] = ownersList.get(i).getLname();
            rows[i][3] = ownersList.get(i).getPhone();
            rows[i][4] = ownersList.get(i).getEmail();
            rows[i][5] = ownersList.get(i).getAddress();
        }
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        jTable2.setModel(model);
        
        //change the jtable row height
        jTable2.setRowHeight(40);
        
        jTable2.setSelectionBackground(new Color(235,47,6));
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(25);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(150);
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_Fname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Address = new javax.swing.JTextArea();
        jButton_Add_Owner = new javax.swing.JButton();
        jButton_Edit_Owner = new javax.swing.JButton();
        jButton_Remove_Owner = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField_Lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton_Refresh_Owner = new javax.swing.JButton();
        jButton_Owner_Properties = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel_Title.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Owners");

        javax.swing.GroupLayout jPanel_TitleLayout = new javax.swing.GroupLayout(jPanel_Title);
        jPanel_Title.setLayout(jPanel_TitleLayout);
        jPanel_TitleLayout.setHorizontalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TitleLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_TitleLayout.setVerticalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TitleLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Address");

        jTextField_Id.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jTextField_Fname.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jTextArea_Address.setColumns(20);
        jTextArea_Address.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        jTextArea_Address.setRows(5);
        jScrollPane1.setViewportView(jTextArea_Address);

        jButton_Add_Owner.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Add_Owner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Add_Owner.setText("Add");
        jButton_Add_Owner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Add_Owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_OwnerActionPerformed(evt);
            }
        });

        jButton_Edit_Owner.setBackground(new java.awt.Color(0, 153, 0));
        jButton_Edit_Owner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Edit_Owner.setText("Edit");
        jButton_Edit_Owner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Edit_Owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Edit_OwnerActionPerformed(evt);
            }
        });

        jButton_Remove_Owner.setBackground(new java.awt.Color(204, 0, 102));
        jButton_Remove_Owner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Remove_Owner.setText("Remove");
        jButton_Remove_Owner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remove_Owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Remove_OwnerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Last Name");

        jTextField_Lname.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Phone");

        jTextField_Phone.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Email");

        jTextField_Email.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton_Refresh_Owner.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Refresh_Owner.setText("Refresh");
        jButton_Refresh_Owner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Refresh_OwnerActionPerformed(evt);
            }
        });

        jButton_Owner_Properties.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Owner_Properties.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Owner_Properties.setText("Owner Properties");
        jButton_Owner_Properties.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Owner_Properties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Owner_PropertiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(11, 11, 11))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Owner_Properties, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_Add_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton_Edit_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jButton_Remove_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jButton_Refresh_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Add_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Edit_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Remove_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Refresh_Owner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_Owner_Properties, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Add_OwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_OwnerActionPerformed
        //add a new owner
        //get owner details
        String fname = jTextField_Fname.getText();
        String lname = jTextField_Lname.getText();
        String phone = jTextField_Phone.getText();
        String email = jTextField_Email.getText();
        String address = jTextArea_Address.getText();
        
        P_Owner owner = new P_Owner();
        if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
        {
         
            JOptionPane.showMessageDialog(null,"Enter the required Information","Add Owner",2);
        }
        else 
        {
            if(owner.addNewOwner(new P_Owner(0,fname,lname,phone,email,address)))
        {
            JOptionPane.showMessageDialog(null,"New Owner added to the system","Add Owner",1);
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Owner Not added to the system","Add Owner",2);
        }
        }
        
    }//GEN-LAST:event_jButton_Add_OwnerActionPerformed

    private void jButton_Edit_OwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_OwnerActionPerformed
       // edit the owner data
       // get the owner data
        
        String fname = jTextField_Fname.getText();
        String lname = jTextField_Lname.getText();
        String phone = jTextField_Phone.getText();
        String email = jTextField_Email.getText();
        String address = jTextArea_Address.getText();
        P_Owner owner = new P_Owner();
        
        try{
            int ownerId = Integer.valueOf(jTextField_Id.getText());
              if(fname.trim().equals("") || lname.trim().equals("") || phone.trim().equals("") || email.trim().equals("") || address.trim().equals(""))
        {
         
            JOptionPane.showMessageDialog(null,"Enter the required Information","Edit Owner",2);
        }
        else 
        {
            if(owner.editOwnerData(new P_Owner(ownerId,fname,lname,phone,email,address)))
        {
            JOptionPane.showMessageDialog(null,"Owner data edited","Edit Owner",1);
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Owner data Not edited","Edit Owner",2);
        }
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage()+"Enter a valid owner id","Invalid id",0);
        }
       
        
    }//GEN-LAST:event_jButton_Edit_OwnerActionPerformed

    private void jButton_Remove_OwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Remove_OwnerActionPerformed
       // deleting the selected owner from the system 
       try
       {
            int ownerId = Integer.valueOf(jTextField_Id.getText());
            P_Owner owner = new P_Owner();
            if(jTextField_Id.getText().trim().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter the Owner ID","Empty ID",2);
            }
            else 
            {
                //show confirmation message
                int yes_or_no = JOptionPane.showConfirmDialog(null,"Do you want to delete this type?","Delete type",JOptionPane.YES_NO_OPTION);
                if(yes_or_no == JOptionPane.YES_OPTION)
                {
                    if(owner.deleteOwner(ownerId))
                    {
                        JOptionPane.showMessageDialog(null,"Owner Data Deleted","Delete Owner",1);
                        //Clear textfields after delete
                        jTextField_Id.setText("");
                        jTextField_Fname.setText("");
                        jTextField_Lname.setText("");
                        jTextField_Phone.setText("");
                        jTextField_Email.setText("");
                        jTextArea_Address.setText("");
                                                
                    }
                    else 
                    {
                       JOptionPane.showMessageDialog(null,"Operation Failed","Delete Owner",2);
                    }
                }
            }
       }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage()+"Enter a valid owner id","Invalid id",0);
        }
      
       
    }//GEN-LAST:event_jButton_Remove_OwnerActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
        int selectedRowIndex = jTable2.getSelectedRow();
        jTextField_Id.setText(jTable2.getValueAt(selectedRowIndex,0).toString());
        jTextField_Fname.setText(jTable2.getValueAt(selectedRowIndex,1).toString());
        jTextField_Lname.setText(jTable2.getValueAt(selectedRowIndex,2).toString());
        jTextField_Phone.setText(jTable2.getValueAt(selectedRowIndex,3).toString());
        jTextField_Email.setText(jTable2.getValueAt(selectedRowIndex,4).toString());
        jTextArea_Address.setText(jTable2.getValueAt(selectedRowIndex,5).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton_Refresh_OwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Refresh_OwnerActionPerformed
        
        fillJtableWithOwnersData();
    }//GEN-LAST:event_jButton_Refresh_OwnerActionPerformed

    private void jButton_Owner_PropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Owner_PropertiesActionPerformed
        
        try
        {
           
            
            int selectedRowIndex = jTable2.getSelectedRow();
            int id = Integer.valueOf(jTable2.getValueAt(selectedRowIndex,0).toString());
            
             Owner_Properties_Form ownerPropertiesform = new Owner_Properties_Form(id);
            ownerPropertiesform.setVisible(true);
            ownerPropertiesform.pack();
            ownerPropertiesform.setLocationRelativeTo(null);
            ownerPropertiesform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null," Select the owner from the table first","No Owner Selected",2);
        }
    }//GEN-LAST:event_jButton_Owner_PropertiesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Owner_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Owner_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Owner_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Owner_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Owner_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_Owner;
    private javax.swing.JButton jButton_Edit_Owner;
    private javax.swing.JButton jButton_Owner_Properties;
    private javax.swing.JButton jButton_Refresh_Owner;
    private javax.swing.JButton jButton_Remove_Owner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea_Address;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_Fname;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_Lname;
    private javax.swing.JTextField jTextField_Phone;
    // End of variables declaration//GEN-END:variables
}
