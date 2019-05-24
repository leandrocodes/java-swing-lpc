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
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

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

        Container c = getContentPane();
        c.setLayout(new GridLayout(8, 2));

        c.add(l1);
        c.add(t1);

        c.add(l2);
        c.add(t2);

        c.add(l3);
        c.add(t3);

        c.add(l4);
        c.add(t4);

        c.add(l5);
        c.add(t5);

        c.add(l6);
        c.add(t6);

        c.add(l7);
        c.add(t7);

        c.add(b1);
        c.add(b2);

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

}
