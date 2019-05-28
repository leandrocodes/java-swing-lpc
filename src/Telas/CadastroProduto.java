/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import mdlaf.MaterialLookAndFeel;

/**
 *
 * @author pixel
 */
public class CadastroProduto extends JFrame {

    private JLabel l1, l2, l3, l4, l5, l6, l7;
    private JTextField t1, t2, t3, t4, t5, t6, t7;
    private JButton b1, b2, b3, b4;

    public CadastroProduto() {
//        try {
//            UIManager.setLookAndFeel(new MaterialLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }

        l1 = new JLabel("Código: ");
        l2 = new JLabel("Nome: ");
        l3 = new JLabel("Valor Pago: ");
        l4 = new JLabel("Valor de Venda: ");
        l5 = new JLabel("Quantidade no Estoque: ");
        l6 = new JLabel("Unidade Medida");
        l7 = new JLabel("Categoria");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);

        b1 = new JButton("Cadastrar");
        b2 = new JButton("Fechar");
        b1.addActionListener(new Evento());
        b2.addActionListener(new Evento());

        Container frame = getContentPane();
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(8, 2));
        panel.setBounds(0, 0, 500, 300);
        Color lightBlue = new Color(179, 229, 252);
        panel.setBackground(lightBlue);

        panel.add(l1);
        panel.add(t1);

        panel.add(l2);
        panel.add(t2);

        panel.add(l3);
        panel.add(t3);

        panel.add(l4);
        panel.add(t4);

        panel.add(l5);
        panel.add(t5);

        panel.add(l6);
        panel.add(t6);

        panel.add(l7);
        panel.add(t7);

        panel.add(b1);
        panel.add(b2);

        frame.add(panel);
        
        setSize(500, 300);
        setTitle("Cadastro de Produtos");
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        CadastroProduto janela = new CadastroProduto();
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public class Evento implements ActionListener {

        String url = "jdbc:postgresql://localhost:5432/mercadinho";
        String driver = "org.postgresql.Driver";
        String login = "postgres";
        String passwd = "root";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                String url = "jdbc:postgresql://localhost:5432/mercadinho";
                Connection con;
                String query = "INSERT INTO produto ("
                        + " codigo_produto, valor_pago, valor_venda, qtde_estoque, unidade_medida, categoria, nome_produto"
                        + ") VALUES ('"
                        + t1.getText().trim() + " ', '" + t3.getText().trim() + " ', '"
                        + t4.getText().trim() + " ', '" + t5.getText().trim() + " ', '" + t6.getText().trim() + " ', '" + t7.getText().trim() + " ', '" + t2.getText().trim() + " ')";
                Statement stmt;
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (java.lang.ClassNotFoundException e1) {
                    System.err.print("ClassNotFoundException: ");
                    System.err.println(e1.getMessage());
                }

                try {
                    con = DriverManager.getConnection(url, "postgres", "root");
                    stmt = con.createStatement();
                    int rs = stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Inserção do produto feita com sucesso!");

                    stmt.close();
                    con.close();
                } catch (SQLException ex) {
                    System.err.print("SQLException: ");
                    System.err.println(ex.getMessage());
                }

            } // Fim do Bot�o 1
            else if (e.getSource() == b2) {
                /* 0  = YES_OPTION
		               1  = NO_OPTION
		               2  = CANCEL_OPTION
                 */
                int x = JOptionPane.showConfirmDialog(null, "Deseja fechar a janela?");
                if (x == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Fechando a Janela de Cadastro de Funcionario");
                    dispose();
                }
            }
        }

    }

}
