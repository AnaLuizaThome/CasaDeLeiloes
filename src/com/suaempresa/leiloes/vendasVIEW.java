/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.suaempresa.leiloes;

/**
 *
 * @author victo
 */
public class vendasVIEW {
    public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        carregarProdutosVendidos();
    }

    private void carregarProdutosVendidos() {
        try {
            ProdutosDAO produtodao = new ProdutosDAO();
            List<ProdutosDTO> lista = produtodao.listarProdutosVendidos();

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
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar produtos vendidos: " + e.getMessage());
        }
    }

    // Inclua o código para inicializar componentes e demais configurações da tela
}

}
