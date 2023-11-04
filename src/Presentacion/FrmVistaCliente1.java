package Presentacion;

import BussinessObject.ClienteBO;
import DataTransferObject.ClienteView;
import Implementacion.IDaoGeneral;
import static Presentacion.DashBoard.content;
import Type.BaseDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RENZO
 */
public class FrmVistaCliente1 extends javax.swing.JPanel {

     DefaultTableModel dtm = new DefaultTableModel();
     BaseDatos Gestor;
     IDaoGeneral ClienteDao;
     ClienteBO Bo;
     public static String IdPersona;
     public static String IdCliente;
     public static String TipoD;
     public static String IdCliente2;
    public FrmVistaCliente1() {
        ClienteDao = FrmLogin.dao;
        Gestor = FrmLogin.base;
        Bo = new ClienteBO(ClienteDao.ClienteClass(Gestor));
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

        buscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setForeground(new java.awt.Color(102, 102, 102));
        buscar.setText("Search...");
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buscarMousePressed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 240, 30));

        jButton1.setBackground(new java.awt.Color(163, 149, 126));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/115695_magnifying glass_zoom_find_search_icon.png"))); // NOI18N
        jButton1.setText("MOSTRAR");
        jButton1.setAlignmentY(0.0F);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.Cliente", "Cos.Persona", "Nombre", "Tipo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.setGridColor(new java.awt.Color(153, 153, 153));
        tbCliente.setOpaque(false);
        tbCliente.setShowHorizontalLines(false);
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);
        if (tbCliente.getColumnModel().getColumnCount() > 0) {
            tbCliente.getColumnModel().getColumn(0).setPreferredWidth(200);
            tbCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbCliente.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbCliente.getColumnModel().getColumn(3).setPreferredWidth(350);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 560, 440));

        jPanel1.setBackground(new java.awt.Color(129, 94, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 410, 50));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/32379_add_plus_icon.png"))); // NOI18N
        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VistaC (2).png"))); // NOI18N
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
       int fila = tbCliente.getSelectedRow();
       IdCliente2 = tbCliente.getValueAt(fila,0).toString();
           FrmNuevaVenta p1 = new FrmNuevaVenta();
           p1.setSize(1070, 630);
           p1.setLocation(0, 0);

           content.removeAll();
           content.add(p1, BorderLayout.CENTER);
           content.revalidate();
           content.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMousePressed
      int fila = tbCliente.getSelectedRow();
      int x =  JOptionPane.showConfirmDialog(null, "Desea actualizar la informacion?", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
      if(x==0){
          IdCliente = tbCliente.getValueAt(fila, 0).toString();
          IdPersona =tbCliente.getValueAt(fila, 1).toString();
          TipoD = tbCliente.getValueAt(fila, 3).toString();
          System.out.println(IdCliente);
         this.hola();
      }else{
          System.out.println("hola por aqui");
      }
    }//GEN-LAST:event_tbClienteMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    // End of variables declaration//GEN-END:variables
     private void Listar()throws Exception{  //venta
        dtm = (DefaultTableModel) tbCliente.getModel();
        Object[] obj = new Object[7];
        for (ClienteView a : Bo.listar()) {
            obj[0] = a.getIdCliente().trim();
            obj[1] = a.getNombre().trim();
            obj[2] = a.getApellido().trim();
            obj[3] = a.getNumeroD().trim();
            obj[4] = a.getGenero().trim();
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
        dtm = (DefaultTableModel) tbCliente.getModel();
        dtm.getDataVector().removeAllElements();
        tbCliente.removeAll();
    }
}
