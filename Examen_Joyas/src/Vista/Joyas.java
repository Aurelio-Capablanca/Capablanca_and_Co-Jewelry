/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import Controlador.ConstructorJoyas;
import Modelo.FuncionesJoyas;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author adalb
 */
public class Joyas extends javax.swing.JFrame {

  ConstructorJoyas cj;
  FuncionesJoyas fj = new FuncionesJoyas();
  Connection cos;
  Statement orden;
  ResultSet rs;
  Conexion con = new Conexion();

  public Joyas() {
    this.cj = new ConstructorJoyas();

    initComponents();
    cos = con.conectar();
    if (cos != null) {
      this.TablaJoyas();
    }
    fj.getClasificacion();
    cmbClasif.setModel(fj.getClasificacion());
    txtId.setEnabled(false);
  }

  public void TablaJoyas() {
    String titulos[] = {"Id", "Nombres", "Color", "Joya", "Clase"};
    DefaultTableModel md = new DefaultTableModel(null, titulos);
    try {
      orden = cos.createStatement();
      rs = orden.executeQuery("Select codigoPiedra, nomPiedra, color, joyeria, nomClasif  From Piedra pr , Clasificacion cl Where pr.codigoCla=cl.codigoCla");
      while (rs.next()) {
        Object Filas[] = {rs.getString(1),
                rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5)};
        md.addRow(Filas);
      }
      jTableJoya.setModel(md);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }


  public void Limpiar() {
    txtId.setText("");
    txtNombre.setText("");
    txtColor.setText("");
    txtJoya.setText("");
    btnIngresar.setEnabled(true);
    btnActualizar.setEnabled(false);
    btnEliminar.setEnabled(false);
  }


  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    btnActualizar = new javax.swing.JButton();
    btnIngresar = new javax.swing.JButton();
    btnEliminar = new javax.swing.JButton();
    btnImprimir = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTableJoya = new javax.swing.JTable();
    txtId = new javax.swing.JTextField();
    txtNombre = new javax.swing.JTextField();
    txtColor = new javax.swing.JTextField();
    txtJoya = new javax.swing.JTextField();
    cmbClasif = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(204, 204, 204));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));

    btnActualizar.setText("Actualizar ");
    btnActualizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnActualizarActionPerformed(evt);
      }
    });

    btnIngresar.setText("Ingresar");
    btnIngresar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnIngresarActionPerformed(evt);
      }
    });

    btnEliminar.setText("Eliminar");
    btnEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarActionPerformed(evt);
      }
    });

    btnImprimir.setText("Imprimir");
    btnImprimir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnImprimirActionPerformed(evt);
      }
    });

    jButton1.setText("Limpiar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                            .addGap(19, 19, 19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jButton1)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(31, Short.MAX_VALUE))
    );

    jTableJoya.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
            },
            new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
            }
    ));
    jTableJoya.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTableJoyaMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTableJoya);

    txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtNombreKeyTyped(evt);
      }
    });

    txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtColorKeyTyped(evt);
      }
    });

    txtJoya.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyTyped(java.awt.event.KeyEvent evt) {
        txtJoyaKeyTyped(evt);
      }
    });

    cmbClasif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setText("Codigo ");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Nombre");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Clasificación");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Color ");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Joyería ");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtJoya, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(33, 33, 33)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGap(92, 92, 92)
                                                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addGap(31, 31, 31)
                                                                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(48, 48, 48)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(cmbClasif, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtJoya, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                                    .addComponent(cmbClasif))
                                            .addGap(55, 55, 55)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    if (txtNombre.getText().trim().equals("")
            || txtColor.getText().trim().equals("") || txtJoya.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(this, "Existen campos vacíos. Por favor, rellenelos", "Mensaje", JOptionPane.WARNING_MESSAGE);
    } else {
      int ids = fj.idIncremental();
      cj.setCodigo(ids);
      cj.setNombre(txtNombre.getText());
      cj.setColor(txtColor.getText());
      cj.setJoyeria(txtJoya.getText());
      int clasif = fj.obtenerClasificacion(String.valueOf(cmbClasif.getItemAt(cmbClasif.getSelectedIndex())));
      cj.setClas(clasif);
      if (fj.guardarJoya(cj)) {
        JOptionPane.showMessageDialog(null, "Datos guardados");
      } else {
        JOptionPane.showMessageDialog(null, "Error al gurdar datos");
      }
      TablaJoyas();
      Limpiar();
    }


  }//GEN-LAST:event_btnIngresarActionPerformed

  private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    if (txtId.getText().trim().equals("") || txtNombre.getText().trim().equals("")
            || txtColor.getText().trim().equals("") || txtJoya.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(this, "Existen campos vacíos. Por favor, rellenelos", "Mensaje", JOptionPane.WARNING_MESSAGE);
    } else {

      cj.setCodigo(Integer.parseInt(txtId.getText()));
      cj.setNombre(txtNombre.getText());
      cj.setColor(txtColor.getText());
      cj.setJoyeria(txtJoya.getText());
      int clasif = fj.obtenerClasificacion(String.valueOf(cmbClasif.getItemAt(cmbClasif.getSelectedIndex())));
      cj.setClas(clasif);
      if (fj.actualizarJoya(cj)) {
        JOptionPane.showMessageDialog(null, "Datos guardados");
      } else {
        JOptionPane.showMessageDialog(null, "Error al gurdar datos");
      }
      TablaJoyas();
      Limpiar();
    }

  }//GEN-LAST:event_btnActualizarActionPerformed

  private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    cj.setCodigo(Integer.parseInt(txtId.getText()));
    int eliminar = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar?", "ATENCION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (eliminar == 0) {
      if (fj.eliminarJoya(cj)) {
        JOptionPane.showMessageDialog(this, "Datos Eliminados");

      } else {
        JOptionPane.showMessageDialog(this, "Error al eliminar datos");
      }

    }
    TablaJoyas();
    Limpiar();
  }//GEN-LAST:event_btnEliminarActionPerformed

  private void jTableJoyaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableJoyaMouseClicked

    int fila = jTableJoya.getSelectedRow();
    txtId.setText(String.valueOf(jTableJoya.getValueAt(fila, 0)));
    txtNombre.setText(String.valueOf(jTableJoya.getValueAt(fila, 1)));
    txtColor.setText(String.valueOf(jTableJoya.getValueAt(fila, 2)));
    txtJoya.setText(String.valueOf(jTableJoya.getValueAt(fila, 3)));
    cmbClasif.setSelectedItem(String.valueOf(jTableJoya.getValueAt(fila, 4)));

    btnActualizar.setEnabled(true);
    btnEliminar.setEnabled(true);
    btnIngresar.setEnabled(false);

  }//GEN-LAST:event_jTableJoyaMouseClicked

  private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
    char car = evt.getKeyChar();
    if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_ENTER) && (car != (char) KeyEvent.VK_BACK_SPACE)) {
      evt.consume();
      Toolkit.getDefaultToolkit().beep();
    }
    if (txtNombre.getText().length() == 16) {
      evt.consume();
      JOptionPane.showMessageDialog(null, "Limite de caracteres");
    }
  }//GEN-LAST:event_txtNombreKeyTyped

  private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
    char car = evt.getKeyChar();
    if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_ENTER) && (car != (char) KeyEvent.VK_BACK_SPACE)) {
      evt.consume();
      Toolkit.getDefaultToolkit().beep();
    }
    if (txtColor.getText().length() == 16) {
      evt.consume();
      JOptionPane.showMessageDialog(null, "Limite de caracteres");
    }
  }//GEN-LAST:event_txtColorKeyTyped

  private void txtJoyaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJoyaKeyTyped
    char car = evt.getKeyChar();
    if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_ENTER) && (car != (char) KeyEvent.VK_BACK_SPACE)) {
      evt.consume();
      Toolkit.getDefaultToolkit().beep();
    }
    if (txtJoya.getText().length() == 16) {
      evt.consume();
      JOptionPane.showMessageDialog(null, "Limite de caracteres");
    }
  }//GEN-LAST:event_txtJoyaKeyTyped

  private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    try {
      Connection cn = new Conexion().conectar();
      JasperReport jr = JasperCompileManager.compileReport("src/Reportes/ReporteJoyas.jrxml");
      JasperPrint jp = JasperFillManager.fillReport(jr, null, cn);
      JasperViewer jv = new JasperViewer(jp);
      jv.setVisible(true);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }//GEN-LAST:event_btnImprimirActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Limpiar();
  }//GEN-LAST:event_jButton1ActionPerformed

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
      java.util.logging.Logger.getLogger(Joyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Joyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Joyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Joyas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Joyas().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnActualizar;
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnImprimir;
  private javax.swing.JButton btnIngresar;
  private javax.swing.JComboBox<String> cmbClasif;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTableJoya;
  private javax.swing.JTextField txtColor;
  private javax.swing.JTextField txtId;
  private javax.swing.JTextField txtJoya;
  private javax.swing.JTextField txtNombre;
  // End of variables declaration//GEN-END:variables
}
