package model;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
    private String id;
    private String nomeProduto;
    private String lote;
    private LocalDate validade;
    private String quantidade;

    public Produto(String id, String nomeProduto, String lote, LocalDate validade, String quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.lote = lote;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public String getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getLote() {
        return lote;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public int getQuantidade() {
        return Integer.parseInt(quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "===== Produto ===== \n" +
                "id: " + id + '\n' +
                "Nome Produto='" + nomeProduto + '\n' +
                "lote: " + lote + '\n' +
                "validade: " + validade;
    }
}
