package vista;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class VFichero extends JFrame {

    public JFileChooser seleccionar = new JFileChooser();
    public FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
    public File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VFichero frame = new VFichero();
                frame.setVisible(true);
            } catch (Exception e) {
            }
        });
    }

    public VFichero() {
        initComponents();
    }

    public String abrirArchivo(File archivo) {
        String doc = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while (((ascci = entrada.read()) != -1)) {
                char caracter = (char) ascci;
                doc += caracter;
            }
        } catch (IOException e) {
            System.out.println("¡Archivo corrompido!");
        }
        return doc;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbBuscar = new javax.swing.JButton();
        txDirArchivo = new javax.swing.JTextField();
        jSPnTupla = new javax.swing.JScrollPane();
        txTupla = new javax.swing.JTextArea();
        jbContinuar = new javax.swing.JButton();
        jTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        txTupla.setColumns(20);
        txTupla.setLineWrap(true);
        txTupla.setRows(5);
        jSPnTupla.setViewportView(txTupla);

        jbContinuar.setText("Continuar");

        jTitulo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jSPnTupla, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(96, 96, 96))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txDirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbContinuar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSPnTupla, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        seleccionar.setFileFilter(filtro);
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            txDirArchivo.setText(archivo.getAbsolutePath());
            if (archivo.getName().endsWith("txt")) {
                String documento = abrirArchivo(archivo);
                txTupla.setText(documento);
                JOptionPane.showMessageDialog(this, "¡Información copiada con éxito!");
                jbContinuar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "¡Extensión no compatible, ingrese un archivo de extensión .txt!");
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jSPnTupla;
    public javax.swing.JLabel jTitulo;
    public javax.swing.JButton jbBuscar;
    public javax.swing.JButton jbContinuar;
    public javax.swing.JTextField txDirArchivo;
    public javax.swing.JTextArea txTupla;
    // End of variables declaration//GEN-END:variables
}
