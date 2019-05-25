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
import mdlaf.*;
import mdlaf.animation.*;
import mdlaf.utils.*;

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

        Color darkBlue = new Color(55, 71, 79);
        panel.setBackground(darkBlue);
        panel.setLayout(null);

        jBtnCadProd.setBounds(20, 50, 160, 60);
        jBtnConProd.setBounds(20, 150, 160, 60);
        jBtnSair.setBounds(60, 250, 80, 40);

        panel.add(jBtnCadProd);
        panel.add(jBtnConProd);
        panel.add(jBtnSair);

        //panel2
        panel2.setBounds(200, 0, 400, 400);

        Color dark = new Color(33, 33, 33);
        panel2.setBackground(dark);
        panel2.setLayout(null);

        GridBagLayout layout = new GridBagLayout();
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
