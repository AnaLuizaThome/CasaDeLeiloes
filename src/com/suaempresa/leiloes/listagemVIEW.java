/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.suaempresa.leiloes;

/**
 *
 * @author victo
 */
public class listagemVIEW extends javax.swing.JFrame {

    public listagemVIEW() {
        initComponents();
        carregarProdutos();
    }

    private void carregarProdutos() {
        try {
            ProdutosDAO produtodao = new ProdutosDAO();
            List<ProdutosDTO> lista = produtodao.listarProdutos();

            DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
            modelo.setRowCount(0);

            for (ProdutosDTO produto : lista) {
                modelo.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getValor(),
                    produto.getStatus()
                });
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    // Aqui você adiciona o restante do código da interface, incluindo o initComponents()
}
