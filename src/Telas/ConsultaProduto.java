/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author pixel
 */
public class ConsultaProduto extends JFrame {

    JTextArea t1;
    JButton fechar, BotCarregarDados, Limpar;
    JLabel lNomeProd;
    JTextField jTxtValorVenda;

    Connection conexao = null;

    ConsultaProduto() {

        Color btn = new Color(76, 175, 80);
        Color lightBlue = new Color(179, 229, 252);
        Color btnRed = new Color(229, 57, 53);
        Color btnOrange = new Color(255, 112, 67);
        Color bord = new Color(0, 150, 136);
        Border line = new LineBorder(bord);
        Border margin = new EmptyBorder(15, 25, 15, 25);
        Border compound = new CompoundBorder(line, margin);

        t1 = new JTextArea(15, 25);

        fechar = new JButton("Fechar");
        fechar.setBackground(btnRed);
        fechar.setForeground(Color.white);
        fechar.setBorder(compound);

        BotCarregarDados = new JButton("Carregar Dados");
        BotCarregarDados.setBackground(btn);
        BotCarregarDados.setForeground(Color.black);
        BotCarregarDados.setBorder(compound);

        Limpar = new JButton("Limpar");
        Limpar.setForeground(Color.black);
        Limpar.setBackground(btnOrange);
        Limpar.setBorder(compound);

        lNomeProd = new JLabel("Valor de Venda:");
        jTxtValorVenda = new JTextField(10);

        String url = "jdbc:postgresql://localhost:5432/mercadinho";
        String driver = "org.postgresql.Driver";
        String login = "postgres";
        String passwd = "root";

        Container c = getContentPane();

        FlowLayout layout = new FlowLayout();
        c.setLayout(layout);
        c.setBackground(lightBlue);
        layout.setAlignment(FlowLayout.CENTER);

        fechar.addActionListener(new TrataBotaoFechar());
        BotCarregarDados.addActionListener(new Proc());
        Limpar.addActionListener(new TrataBotaoLimpar());

        c.add(lNomeProd);
        c.add(jTxtValorVenda);
        c.add(t1);

        c.add(Limpar);
        c.add(BotCarregarDados);
        c.add(fechar);

        setTitle("Consulta de Produtos");
        setSize(350, 500);
        setVisible(true);

        //conexao banco de dados  
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, login, passwd);
        } catch (java.lang.Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        ConsultaProduto janela = new ConsultaProduto();
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class TrataBotaoFechar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class TrataBotaoLimpar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            t1.setText("");
            t1.requestFocus();
        }
    }

    class Proc implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String lista = "", filtro = "";

            if (jTxtValorVenda.getText().equals("") == false) {
                filtro += "where valor_venda = '" + (jTxtValorVenda.getText()) + "'";
            }

            try {
                Statement sent = conexao.createStatement();
                ResultSet result = sent.executeQuery("select * from produto " + filtro + " order by codigo_produto");

                while (result.next()) {
                    lista += "Código: " + result.getString("codigo_produto");
                    lista += "\nNome: " + result.getString("nome_produto");
                    lista += "\nValor Pago: " + result.getString("valor_pago");
                    lista += "\nQuantidade: " + result.getString("qtde_estoque");
                    lista += "\nUnidade Medida: " + result.getString("unidade_medida");
                    lista += "\nCategoria: " + result.getString("categoria");
                    lista += "\n\n";
                }
                sent.close();
            } catch (SQLException ex) {
                System.out.println("Erro de consulta");
            }

            t1.setText(lista);
        }
    }
}
