package model;

import java.time.LocalDate;
import java.util.Objects;

public class Produto {
    private String id;
    private String fabricante;
    private String lote;
    private LocalDate validade;

    public Produto(String id, String fabricante, String lote, LocalDate validade) {
        this.id = id;
        this.fabricante = fabricante;
        this.lote = lote;
        this.validade = validade;
    }

    public String getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getLote() {
        return lote;
    }

    public LocalDate getValidade() {
        return validade;
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
        return "Produto{" +
                "id='" + id + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", lote='" + lote + '\'' +
                ", validade=" + validade +
                '}';
    }
}
