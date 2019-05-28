/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 *
 * @author pixel
 */
public class TelPrincipal {

    public static void main(String args[]) {
//
//        try {
//            UIManager.setLookAndFeel(new MaterialLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }

        new Tela();
    }

}

class Tela {

    JFrame frame = new JFrame("Gerenciamento de Produtos");
    JButton jBtnCadProd = new JButton("Cadastrar");

    JButton jBtnConProd = new JButton("Consultar");
    JButton jBtnSair = new JButton("Sair");

    Tela() {

        Container container = frame.getContentPane();
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        //panel1
        panel.setBounds(0, 0, 200, 400);

        Color darky = new Color(84, 110, 122);
        panel.setBackground(darky);
        panel.setLayout(null);

        jBtnCadProd.setBounds(20, 50, 160, 60);
        Color btn = new Color(130, 217, 255);
        Color bord = new Color(63, 81, 181);
        jBtnCadProd.setBackground(btn);
        jBtnCadProd.setForeground(Color.black);
        Border line = new LineBorder(bord);
        Border margin = new EmptyBorder(15, 25, 15, 25);
        Border compound = new CompoundBorder(line, margin);
        jBtnCadProd.setBorder(compound);
        jBtnCadProd.setFocusPainted(false);

        jBtnConProd.setBounds(20, 150, 160, 60);
        jBtnConProd.setBackground(btn);
        jBtnConProd.setForeground(Color.black);
        jBtnConProd.setBorder(compound);
        jBtnConProd.setFocusPainted(false);

        jBtnSair.setBounds(60, 250, 80, 40);
        jBtnSair.setBackground(btn);
        jBtnSair.setForeground(Color.black);
        jBtnSair.setBorder(compound);
        jBtnSair.setFocusPainted(false);

        panel.add(jBtnCadProd);
        panel.add(jBtnConProd);
        panel.add(jBtnSair);

        //panel2
        panel2.setBounds(200, 0, 400, 400);

        Color lightBlue = new Color(179, 229, 252);
        panel2.setBackground(lightBlue);
        panel2.setLayout(null);

        ImageIcon image = new ImageIcon("/home/pixel/NetBeansProjects/TrabalhoLPC/src/img/warehouse.png");

        JLabel imagelabel = new JLabel(image);
        imagelabel.setBounds(72, 35, 256, 256);
        imagelabel.setForeground(Color.white);
        panel2.add(imagelabel);

        container.setLayout(null);

        container.add(panel);
        container.add(panel2);

        frame.setSize(new Dimension(600, 400));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jBtnCadProd.addActionListener(new FuncBot());
        jBtnConProd.addActionListener(new FuncBot());
        jBtnSair.addActionListener(new FuncBot());

    }

    class FuncBot implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jBtnCadProd) {
                new CadastroProduto();
            }
            if (e.getSource() == jBtnConProd) {
                new ConsultaProduto();
            }
            if (e.getSource() == jBtnSair) {
                System.exit(0);
            }
        }
    }
}
