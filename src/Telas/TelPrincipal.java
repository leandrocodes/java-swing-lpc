/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mdlaf.*;
import mdlaf.animation.*;
import mdlaf.utils.*;

/**
 *
 * @author pixel
 */
public class TelPrincipal {

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        new Tela();
    }

}

class Tela {

    JFrame frame = new JFrame("Gerenciamento de Produtos");
    JButton jBtnCadProd = new JButton("Cadastrar Produtos");

    JButton jBtnConProd = new JButton("Consultar Produtos");
    JButton jBtnSair = new JButton("Sair");

    Tela() {

        MaterialUIMovement.add(jBtnCadProd, MaterialColors.DARKLY_RED);
        MaterialUIMovement.add(jBtnConProd, MaterialColors.RED_100);
        MaterialUIMovement.add(jBtnSair, MaterialColors.RED_100);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(3, 1));
        container.add(jBtnCadProd);
        container.add(jBtnConProd);
        container.add(jBtnSair);

        frame.setMinimumSize(new Dimension(600, 400));
        frame.setBounds(150, 200, 200, 150);
        frame.setVisible(true);
        

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
                //new ConsultaFuncionario();
            }
            if (e.getSource() == jBtnSair) {
                System.exit(0);
            }
        }
    }
}
