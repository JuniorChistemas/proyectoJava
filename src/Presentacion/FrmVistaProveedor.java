/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import BussinessObject.ProveedorBO;
import DataTransferObject.ProveedorDTO;
import Implementacion.IDaoGeneral;
import static Presentacion.DashBoard.content;
import Type.BaseDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmVistaProveedor extends javax.swing.JPanel {
     DefaultTableModel dtm = new DefaultTableModel();
     BaseDatos Gestor;
     IDaoGeneral ClienteDao;
    ProveedorBO Bo;
   public static String IdProveedor; 
    public FrmVistaProveedor() {
        ClienteDao = FrmLogin.dao;
        Gestor = FrmLogin.base;
        Bo = new ProveedorBO(ClienteDao.ProveedorClass(Gestor));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProveedor2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProveedor2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.Usuario", "Cod.Persona", "Nombre", "Tip.Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProveedor2.setGridColor(new java.awt.Color(51, 255, 51));
        tbProveedor2.setOpaque(false);
        tbProveedor2.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tbProveedor2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 500, 440));

        jButton1.setBackground(new java.awt.Color(163, 149, 126));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/115695_magnifying glass_zoom_find_search_icon.png"))); // NOI18N
        jButton1.setText("Listar");
        jButton1.setAlignmentY(0.0F);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 110, 30));

        buscar.setForeground(new java.awt.Color(102, 102, 102));
        buscar.setText("Search...");
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarMousePressed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 290, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/32379_add_plus_icon.png"))); // NOI18N
        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VistaPr.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.limpiarTabla();
            Listar();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Accion no permetida", "Advertencia", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMousePressed
        // TODO add your handling code here:
        if (String.valueOf(buscar.getText()).equals("Search...")) {
            buscar.setText("");
            buscar.setForeground(Color.black);
        }
    }//GEN-LAST:event_buscarMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            int fila =tbProveedor2.getSelectedRow();
         IdProveedor = tbProveedor2.getValueAt(fila,0).toString();
           FrmPedido1 p1 = new FrmPedido1();
           p1.setSize(1070, 630);
           p1.setLocation(0, 0);

           content.removeAll();
           content.add(p1, BorderLayout.CENTER);
           content.revalidate();
           content.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed
 private void Listar()throws Exception{  //venta
        dtm = (DefaultTableModel) tbProveedor2.getModel();
        Object[] obj = new Object[5];
        for (ProveedorDTO a : Bo.listarProveedor()) {
            obj[0] = a.getIdProveedor().trim();
            obj[1] = a.getIdPersona().trim();
            obj[2] = a.getObservaciones().trim();
            obj[3] = a.getReferencias().trim();
            obj[4] = a.isEstado();
            dtm.addRow(obj);
        }
    }
         private void hola(){
       FrmCliente p1 = new FrmCliente();
        p1.setSize(1070, 630);
        p1.setLocation(0,0);

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    private void limpiarTabla() {
        dtm = (DefaultTableModel) tbProveedor2.getModel();
        dtm.getDataVector().removeAllElements();
        tbProveedor2.removeAll();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProveedor2;
    // End of variables declaration//GEN-END:variables
}
