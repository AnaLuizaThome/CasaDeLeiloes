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

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedRow = tabelaProdutos.getSelectedRow();
    if (selectedRow != -1) {
        int id = (int) tabelaProdutos.getValueAt(selectedRow, 0);
        ProdutosDAO produtodao = new ProdutosDAO();
        produtodao.venderProduto(id);

        carregarProdutos();  // Atualiza a listagem após a venda
        javax.swing.JOptionPane.showMessageDialog(this, "Produto vendido com sucesso!");
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto para vender.");
    }
}

}
