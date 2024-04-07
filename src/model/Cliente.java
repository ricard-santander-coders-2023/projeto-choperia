package model;

import java.util.Objects;

public class Cliente {
    private static int contador = 0;
    protected int id;
    protected String nome;
    protected String documento;

    protected String tipo;

    public Cliente(String nome, String documento) {
        this.id = ++contador;
        this.documento = documento;
        this.nome = nome;
        this.tipo = documento.length() == 14? "PJ" : "PF";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = documento.length() == 14? "PJ" : "PF";
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente pessoa = (Cliente) obj;
        return Objects.equals(documento, pessoa.documento);
    }

    @Override
    public String toString() {
        return "\n=== Cliente ===" +
                "\nid: " + id +
                "\nnome: " + nome +
                "\ndocumento: " + documento +
                "\ntipo: " + tipo;
    }
}

