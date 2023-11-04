/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import BussinessObject.ProductoBO;
import DataTransferObject.ProductoDTO;
import Implementacion.IDaoGeneral;
import static Presentacion.DashBoard.content;
import Type.BaseDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class FrmProducto1 extends javax.swing.JPanel {

    BaseDatos Gestor;
    IDaoGeneral ProductoDao;
    ProductoBO Bo;
    DefaultTableModel dtm = new DefaultTableModel();
    public FrmProducto1() {
        initComponents();
         ProductoDao = FrmLogin.dao;
        Gestor =FrmLogin.base;
        Bo = new ProductoBO(ProductoDao.ProductoClass(Gestor));
        //Componentes Table
        
        tbProducto.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD ,12));
        tbProducto.getTableHeader().setOpaque(false);
        tbProducto.getTableHeader().setForeground(new Color(70, 50, 36));
        tbProducto.getTableHeader().setBackground(new Color(235, 224, 179));
        tbProducto.setRowHeight(25);
        txtCategoria.setText(FrmParametro.IdParametro);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Text10 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        Text12 = new javax.swing.JLabel();
        Text13 = new javax.swing.JLabel();
        Text14 = new javax.swing.JLabel();
        Text15 = new javax.swing.JLabel();
        Text16 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();
        txtCategoria = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnNuevoCl2 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelarCl2 = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnEliminarCl2 = new javax.swing.JButton();
        btnSalirCl2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Text10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text10.setForeground(new java.awt.Color(255, 255, 255));
        Text10.setText("CÓDIGO");
        add(Text10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        txtCodigoProducto.setEditable(false);
        txtCodigoProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigoProducto.setText("INGRESE EL CÓDIGO");
        txtCodigoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCodigoProductoMousePressed(evt);
            }
        });
        add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 230, -1));

        Text12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text12.setForeground(new java.awt.Color(255, 255, 255));
        Text12.setText("NOMBRE");
        add(Text12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        Text13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text13.setForeground(new java.awt.Color(255, 255, 255));
        Text13.setText("CATEGORÍA");
        add(Text13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        Text14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text14.setForeground(new java.awt.Color(255, 255, 255));
        Text14.setText("ESTADO");
        add(Text14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        Text15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text15.setForeground(new java.awt.Color(255, 255, 255));
        Text15.setText("STOCK");
        add(Text15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        Text16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Text16.setForeground(new java.awt.Color(255, 255, 255));
        Text16.setText("PRECIO");
        add(Text16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jcbEstado.setForeground(new java.awt.Color(255, 255, 255));
        jcbEstado.setText("ACTIVO");
        add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        txtCategoria.setEditable(false);
        txtCategoria.setForeground(new java.awt.Color(102, 102, 102));
        txtCategoria.setText("INGRESE EL PARAMETRO");
        txtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCategoriaMousePressed(evt);
            }
        });
        add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 200, -1));

        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("INGRESE EL NOMBRE");
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreMousePressed(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 340, -1));

        txtStock.setEditable(false);
        txtStock.setForeground(new java.awt.Color(102, 102, 102));
        txtStock.setText("0");
        txtStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtStockMousePressed(evt);
            }
        });
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 160, -1));

        jButton1.setText("Clik");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, -1, -1));

        txtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        txtPrecio.setText("INGRESE EL PRECIO");
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPrecioMousePressed(evt);
            }
        });
        add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 230, -1));

        jPanel13.setBackground(new java.awt.Color(167, 144, 131));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevoCl2.setBackground(new java.awt.Color(199, 192, 165));
        btnNuevoCl2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnNuevoCl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/7871254_box_apple_package_product_icon (1).png"))); // NOI18N
        btnNuevoCl2.setText("ACTUALIZAR");
        btnNuevoCl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCl2ActionPerformed(evt);
            }
        });
        jPanel13.add(btnNuevoCl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        btnAgregar.setBackground(new java.awt.Color(199, 192, 165));
        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/285657_floppy_guardar_save_icon (1).png"))); // NOI18N
        btnAgregar.setText("GUARDAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel13.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 90, -1, 41));

        btnCancelarCl2.setBackground(new java.awt.Color(199, 192, 165));
        btnCancelarCl2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnCancelarCl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/9004715_cross_delete_remove_cancel_icon (1).png"))); // NOI18N
        btnCancelarCl2.setText("CANCELAR");
        jPanel13.add(btnCancelarCl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 31, 125, 41));

        btnListar.setBackground(new java.awt.Color(199, 192, 165));
        btnListar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/6071808_folder_progress_task_update_update task progress_icon.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        jPanel13.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 90, 100, 41));

        btnEliminarCl2.setBackground(new java.awt.Color(199, 192, 165));
        btnEliminarCl2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnEliminarCl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/6217227_bin_fly_garbage_trash_icon.png"))); // NOI18N
        btnEliminarCl2.setText("ELIMINAR");
        btnEliminarCl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCl2ActionPerformed(evt);
            }
        });
        jPanel13.add(btnEliminarCl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 31, -1, 41));

        btnSalirCl2.setBackground(new java.awt.Color(199, 192, 165));
        btnSalirCl2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnSalirCl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/5172972_arrow_entrance_exit_internet_log_icon.png"))); // NOI18N
        btnSalirCl2.setText("SALIR");
        jPanel13.add(btnSalirCl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 90, 115, 41));

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 460, 150));

        tbProducto.setBackground(new java.awt.Color(243, 243, 243));
        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Categoría", "Estado", "Stock", "Precio U."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProducto.setFocusable(false);
        tbProducto.setGridColor(new java.awt.Color(153, 153, 153));
        tbProducto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbProducto.setRowHeight(50);
        tbProducto.setSelectionBackground(new java.awt.Color(179, 152, 112));
        tbProducto.setShowGrid(true);
        tbProducto.setShowVerticalLines(false);
        tbProducto.getTableHeader().setReorderingAllowed(false);
        tbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbProductoMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbProducto);
        if (tbProducto.getColumnModel().getColumnCount() > 0) {
            tbProducto.getColumnModel().getColumn(0).setPreferredWidth(120);
            tbProducto.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbProducto.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbProducto.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbProducto.getColumnModel().getColumn(4).setPreferredWidth(35);
        }

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 590, 300));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Product.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1075, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoProductoMousePressed
        txtCodigoProducto.setText(this.Codigo());
        if (String.valueOf(txtCodigoProducto.getText()).equals("INGRESE EL CÓDIGO")) {
            txtCodigoProducto.setText("");
            txtCodigoProducto.setForeground(Color.black);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("INGRESE EL NOMBRE");
            txtNombre.setForeground(Color.gray);
        }
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("INGRESE EL STOCK");
            txtStock.setForeground(Color.gray);
        }
        if (txtPrecio.getText().isEmpty()) {
            txtPrecio.setText("INGRESE EL PRECIO");
            txtPrecio.setForeground(Color.gray);
        }
        if (txtCategoria.getText().isEmpty()) {
            txtCategoria.setText("INGRESE EL PARAMETRO");
            txtCategoria.setForeground(Color.gray);
        }
   
    }//GEN-LAST:event_txtCodigoProductoMousePressed

    private void txtNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMousePressed
        // TODO add your handling code here:
        if (String.valueOf(txtNombre.getText()).equals("INGRESE EL NOMBRE")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
        if (txtCodigoProducto.getText().isEmpty()) {
            txtCodigoProducto.setText("INGRESE EL CÓDIGO");
            txtCodigoProducto.setForeground(Color.gray);
        }
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("INGRESE EL STOCK");
            txtStock.setForeground(Color.gray);
        }
        if (txtPrecio.getText().isEmpty()) {
            txtPrecio.setText("INGRESE EL PRECIO");
            txtPrecio.setForeground(Color.gray);
        }
        if (txtCategoria.getText().isEmpty()) {
            txtCategoria.setText("INGRESE EL PARAMETRO");
            txtCategoria.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtNombreMousePressed

    private void txtStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStockMousePressed
     
    }//GEN-LAST:event_txtStockMousePressed

    private void txtPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMousePressed
        // TODO add your handling code here:
        if (String.valueOf(txtPrecio.getText()).equals("INGRESE EL PRECIO")) {
            txtPrecio.setText("");
            txtPrecio.setForeground(Color.black);
        }
        if (txtCodigoProducto.getText().isEmpty()) {
            txtCodigoProducto.setText("INGRESE EL CÓDIGO");
            txtCodigoProducto.setForeground(Color.gray);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("INGRESE EL NOMBRE");
            txtNombre.setForeground(Color.gray);
        }
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("INGRESE EL STOCK");
            txtStock.setForeground(Color.gray);
        }
        if (txtCategoria.getText().isEmpty()) {
            txtCategoria.setText("INGRESE EL PARAMETRO");
            txtCategoria.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPrecioMousePressed

    private void txtCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCategoriaMousePressed
        // TODO add your handling code here:
        if (String.valueOf(txtCategoria.getText()).equals("INGRESE EL PARAMETRO")) {
            txtCategoria.setText("");
            txtCategoria.setForeground(Color.black);
        }
        if (txtCodigoProducto.getText().isEmpty()) {
            txtCodigoProducto.setText("INGRESE EL CÓDIGO");
            txtCodigoProducto.setForeground(Color.gray);
        }
        if (txtNombre.getText().isEmpty()) {
            txtNombre.setText("INGRESE EL NOMBRE");
            txtNombre.setForeground(Color.gray);
        }
        if (txtStock.getText().isEmpty()) {
            txtStock.setText("INGRESE EL STOCK");
            txtStock.setForeground(Color.gray);
        }
        if (txtPrecio.getText().isEmpty()) {
            txtPrecio.setText("INGRESE EL PRECIO");
            txtPrecio.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCategoriaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       FrmParametro p1 = new FrmParametro();
        p1.setSize(1070, 630);
        p1.setLocation(0,0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
      this.limpiarTabla();
        this.Listar();
    }//GEN-LAST:event_btnListarActionPerformed

    private void tbProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductoMousePressed
 int fila = tbProducto.getSelectedRow();
      if(fila ==-1){
          JOptionPane.showMessageDialog(null, "seleccionar correctamente");
      }else{
          txtCodigoProducto.setText(tbProducto.getValueAt(fila, 0).toString());
          txtNombre.setText(tbProducto.getValueAt(fila, 1).toString().trim());
          txtCategoria.setEditable(false);
          txtCategoria.setText(tbProducto.getValueAt(fila, 2).toString());
          jcbEstado.setSelected(tbProducto.getValueAt(fila, 3).equals("Activo"));
          txtStock.setText(tbProducto.getValueAt(fila, 4).toString());
          txtPrecio.setText(tbProducto.getValueAt(fila, 5).toString());
      }
    }//GEN-LAST:event_tbProductoMousePressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
           String x = this.Agregar();
           JOptionPane.showMessageDialog(null,x, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoCl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCl2ActionPerformed
        String x;
        try {
            x = this.Actualizar();
            JOptionPane.showMessageDialog(null, x, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNuevoCl2ActionPerformed

    private void btnEliminarCl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCl2ActionPerformed
            try {
            String x = this.Eliminar();
            JOptionPane.showMessageDialog(null, x, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarCl2ActionPerformed
    private void limpiarTabla() {
        dtm = (DefaultTableModel) tbProducto.getModel();
        dtm.getDataVector().removeAllElements();
        tbProducto.removeAll();
    }
      private void Listar() {  //venta
        dtm = (DefaultTableModel) tbProducto.getModel();
        Object[] obj = new Object[6];
        for (ProductoDTO a : Bo.listar()) {
            obj[0] = a.getIdProducto().trim();
            obj[1] = a.getNombre().trim();
            obj[2] = a.getIdParametro().trim();
            obj[3] = a.getEstadoTxt();
            obj[4] = a.getStock();
            obj[5] = a.getPrecioV();          
            dtm.addRow(obj);
        }
    }
      private String Agregar(){
          String Mensaje;
          Mensaje = Bo.Agregar(txtCodigoProducto.getText(), txtNombre.getText(), jcbEstado.isSelected(), Integer.parseInt(txtStock.getText()), Float.parseFloat(txtPrecio.getText()),txtCategoria.getText());
          return Mensaje;
          
      }
         private String Actualizar()throws Exception{
          String Mensaje;
          Mensaje = Bo.Actualizar(txtCodigoProducto.getText(), txtNombre.getText(), jcbEstado.isSelected(), Integer.parseInt(txtStock.getText()), Float.parseFloat(txtPrecio.getText()),txtCategoria.getText());
          return Mensaje;
          
      }
        private String Codigo() {
        return Bo.CodigoProducto();
    }
           private String Eliminar()throws Exception{
        String Mensaje;
        Mensaje= Bo.Eliminar(txtCodigoProducto.getText().trim());
        return Mensaje;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text10;
    private javax.swing.JLabel Text12;
    private javax.swing.JLabel Text13;
    private javax.swing.JLabel Text14;
    private javax.swing.JLabel Text15;
    private javax.swing.JLabel Text16;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelarCl2;
    private javax.swing.JButton btnEliminarCl2;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNuevoCl2;
    private javax.swing.JButton btnSalirCl2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JCheckBox jcbEstado;
    private javax.swing.JTable tbProducto;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
