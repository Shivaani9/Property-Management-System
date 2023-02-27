

package org.xemacscode.demo;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Malanchite
 */
public class Property_Images_Window extends javax.swing.JFrame {

     P_Type type = new P_Type();
    HashMap<String,Integer> map = type.getTypesMap();
    String property_image_path="";
    int propertyId = 0;
    
    /** Creates new form Property_Images_Window */
    public Property_Images_Window() {
        initComponents();
        MatteBorder panel_border = BorderFactory.createMatteBorder(0,0,3,0,new Color(255,255,255));
        jPanel_Title.setBorder(panel_border);
        
        MatteBorder jlabel_image_border = BorderFactory.createMatteBorder(0,1,1,1,new Color(255,255,255));
        jLabel_Image.setBorder(jlabel_image_border);
        
        //Populate the combo box with type name
        bindCombo();
        
        // when the form shows up
        // populate the jtable with all the properties
        fillJtableWithPropertiesData();
        
        //change the jtable row height
        jTable_properties.setRowHeight(40);
        
        jTable_properties.setSelectionBackground(new Color(27,150,77));
        //Change the id column width
        jTable_properties.getColumnModel().getColumn(0).setPreferredWidth(25);
        //Change the address column width
        jTable_properties.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    
    public void bindCombo()
    {
        
        for(String s: map.keySet())
        {
            jComboBox_types.addItem(s);
        }
    }
    
     public void fillJtableWithPropertiesData()
    {
        P_Property property = new P_Property();
        ArrayList<P_Property> propertyList = property.propertiesList();
        
        String[] colNames = {"ID","Address"};
        
        Object[][] rows = new Object[propertyList.size()][2];
        
        for(int i=0;i<propertyList.size();i++)
        {
            rows[i][0] = propertyList.get(i).getId();
            rows[i][1] = propertyList.get(i).getAddress();
         
        }
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        jTable_properties.setModel(model);
        
        
        
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Add_Images = new javax.swing.JButton();
        jButton_Show_Images = new javax.swing.JButton();
        jButton_Remove_Images = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_types = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_properties = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton_Browse_Images = new javax.swing.JButton();
        jLabel_Image = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jPanel_Title.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Property Images");

        javax.swing.GroupLayout jPanel_TitleLayout = new javax.swing.GroupLayout(jPanel_Title);
        jPanel_Title.setLayout(jPanel_TitleLayout);
        jPanel_TitleLayout.setHorizontalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TitleLayout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_TitleLayout.setVerticalGroup(
            jPanel_TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_TitleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jButton_Add_Images.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Add_Images.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Add_Images.setText("Add");
        jButton_Add_Images.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Add_Images.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ImagesActionPerformed(evt);
            }
        });

        jButton_Show_Images.setBackground(new java.awt.Color(0, 153, 0));
        jButton_Show_Images.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Show_Images.setText("Show this property images");
        jButton_Show_Images.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Show_Images.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Show_ImagesActionPerformed(evt);
            }
        });

        jButton_Remove_Images.setBackground(new java.awt.Color(204, 0, 102));
        jButton_Remove_Images.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Remove_Images.setText("Remove");
        jButton_Remove_Images.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remove_Images.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Remove_ImagesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select a Type");

        jComboBox_types.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBox_types.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_typesActionPerformed(evt);
            }
        });

        jTable_properties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_properties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_propertiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_properties);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Image");

        jButton_Browse_Images.setBackground(new java.awt.Color(255, 255, 0));
        jButton_Browse_Images.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton_Browse_Images.setText("Browse");
        jButton_Browse_Images.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Browse_ImagesActionPerformed(evt);
            }
        });

        jLabel_Image.setOpaque(true);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<html>*this table contains properties id and address<BR>"
            + "                     click on the button to show images slider.</html>");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("<html>*this list contains the images id<BR> of the selected property<BR> (Select the property from the table)</html>");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("<html>*select an item from the list to display<BR>"
            + " or browse an image from your computer.</html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel2))
                            .addComponent(jButton_Show_Images, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jButton_Remove_Images, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Browse_Images))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Add_Images, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_types, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton_Browse_Images))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Show_Images, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_Add_Images, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(jButton_Remove_Images, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Add_ImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ImagesActionPerformed
           //add images to the property
           //you can add multiple images to a property
           P_Property property = new P_Property();
          // property.addImage(propertyId,property_image_path);
         if(propertyId!=0)
         {
            if(property.addImage(propertyId,property_image_path))
            {
                JOptionPane.showMessageDialog(null,"Image Added to this Property","Add Image",1);
            }
            else 
            {
                 JOptionPane.showMessageDialog(null,"Image Not Added to this Property","Add Image",2);
            }
         }
         else 
         {
             JOptionPane.showMessageDialog(null,"Select the property first","Property not selected",2);
         }
           
    }//GEN-LAST:event_jButton_Add_ImagesActionPerformed

    private void jButton_Show_ImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Show_ImagesActionPerformed

        try {
             //Set the property id
            int rowIndex = jTable_properties.getSelectedRow();//selected jtable row index 
            int id = Integer.valueOf(jTable_properties.getValueAt(rowIndex,0).toString());//get the id from jtable
            //imagesSliderform.propertyId = id;//set the id to the slider 
            
            //first check if the property contains images
            //we will use the jlist to do that
            if(jList1.getModel().getSize() > 0)
            {
                //Show the selected property images in a slider
                Property_Images_Slider imagesSliderform = new Property_Images_Slider(id);

                imagesSliderform.setVisible(true);
                imagesSliderform.pack();
                imagesSliderform.setLocationRelativeTo(null);
                imagesSliderform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"This property doesnt have any images to show","No Images Found",2);
            }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Select the property first","Property Not selected",2);
        }
        
        
    }//GEN-LAST:event_jButton_Show_ImagesActionPerformed

    private void jButton_Remove_ImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Remove_ImagesActionPerformed
        //remove the selected images 
        try
        {
            String selectedListItem = String.valueOf(jList1.getSelectedValue());
            Integer imageId  = Integer.valueOf(selectedListItem);

           int yes_or_no = JOptionPane.showConfirmDialog(null,"Do you want to delete this image?","Delete image",JOptionPane.YES_NO_OPTION);
           if(yes_or_no == JOptionPane.YES_OPTION){ 
            if(new P_Property().removePropertyImage(imageId))
             {
                 JOptionPane.showMessageDialog(null,"Property Image Deleted","Delete Image",1);
                 jLabel_Image.setIcon(null);
             }
             else 
             {
                 JOptionPane.showMessageDialog(null,"Operatiion Failed,Image not deleted","Delete Image",2);
             }
         }
        }
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null,"No Image selected","Delete Image",2);
            
        }
       
    }//GEN-LAST:event_jButton_Remove_ImagesActionPerformed
    
    // Create a function to resize the images to fit label
    public ImageIcon resizeImage(String path,byte[] byteImage)
    {
        ImageIcon pic;
        if(byteImage != null) pic =  new ImageIcon(byteImage);
        else pic = new ImageIcon(path);
        Image img = pic.getImage().getScaledInstance(jLabel_Image.getWidth(), jLabel_Image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    
    }
    
    private void jButton_Browse_ImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Browse_ImagesActionPerformed
        // browse images from the computer 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select The Property Image");
        fileChooser.setCurrentDirectory(new File("E:\\Downloads\\Java Project\\images"));
        
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Images",".jpg",".png",".jpeg");
        fileChooser.addChoosableFileFilter(fileFilter);
        
        int fileState = fileChooser.showSaveDialog(null);
        
        if(fileState == JFileChooser.APPROVE_OPTION)
        {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            jLabel_Image.setIcon(resizeImage(path,null));
            property_image_path = path;
        }
        
    }//GEN-LAST:event_jButton_Browse_ImagesActionPerformed

    private void jComboBox_typesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_typesActionPerformed
        // show properties in the jtables depending on the selected type
        int typeId = map.get(jComboBox_types.getSelectedItem().toString());
         P_Property property = new P_Property();
        ArrayList<P_Property> propertyList = property.propertiesListByType(typeId);
        
        String[] colNames = {"ID","Address"};
        
        Object[][] rows = new Object[propertyList.size()][2];
        
        for(int i=0;i<propertyList.size();i++)
        {
            rows[i][0] = propertyList.get(i).getId();
            rows[i][1] = propertyList.get(i).getAddress();
         
        }
        DefaultTableModel model = new DefaultTableModel(rows,colNames);
        jTable_properties.setModel(model);
        
    }//GEN-LAST:event_jComboBox_typesActionPerformed

    private void jTable_propertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_propertiesMouseClicked
       
        // get the property id
        int rowIndex = jTable_properties.getSelectedRow();
        propertyId = Integer.valueOf(jTable_properties.getValueAt(rowIndex,0).toString());
        
        // display the selected property images list in the jlist
        //HashMap<byte[],Integer> imagesList = new P_Property().propertyImagesList(propertyId);
        fillTypeList();
    }//GEN-LAST:event_jTable_propertiesMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
      //try and catch if the list is empty
        
        try{
            // display the selected images from the list to jlabel
            // we can use the hashmap if we want like in the "property_window"
            String selectedListItem = String.valueOf(jList1.getSelectedValue());
            Integer imageId  = Integer.valueOf(selectedListItem);
            byte[] image = new P_Property().getImageById(imageId);
            jLabel_Image.setIcon(resizeImage("",image));
        }catch(Exception ex)
        {
            
        }
    }//GEN-LAST:event_jList1MouseClicked

    // Create a function to populate the JList with the Selected property images id
    public void fillTypeList()
    {
        
        HashMap<byte[],Integer> imagesListMap = new P_Property().propertyImagesList(propertyId);
        
        DefaultListModel listModel = new DefaultListModel();
        
        int i=0;
        
        for(Integer id:imagesListMap.values())
        {
            listModel.add(i,id);
            i++;
        }
        jList1.setModel(listModel);
    }
    
    
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
            java.util.logging.Logger.getLogger(Property_Images_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Property_Images_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Property_Images_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Property_Images_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Property_Images_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_Images;
    private javax.swing.JButton jButton_Browse_Images;
    private javax.swing.JButton jButton_Remove_Images;
    private javax.swing.JButton jButton_Show_Images;
    private javax.swing.JComboBox<String> jComboBox_types;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Image;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_properties;
    // End of variables declaration//GEN-END:variables

}
