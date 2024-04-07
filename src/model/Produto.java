package model;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
    private String id;
    private String nomeProduto;
    private String lote;
    private LocalDate validade;
    private String quantidade;// Define the maximum quantity per lot


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

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    public LocalDate getValidade() {
        return validade;
    }

    public int getQuantidade() {
        return Integer.parseInt(quantidade);
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
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
        return "\n===== Produto =====" +
                "\nid: " + id +
                "\nNome Produto=" + nomeProduto +
                "\nlote: " + lote +
                "\nvalidade: " + validade;
    }

}
