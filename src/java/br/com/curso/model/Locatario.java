package br.com.curso.model;

public class Locatario {
    private int idLocatario;
    private String nome;
    private String cpfCnpj;

    public Locatario() {
        idLocatario = 0;
        nome = "";
        cpfCnpj = "";
    }

    public Locatario(int idLocatario, String nome, String cpfCnpj) {
        this.idLocatario = idLocatario;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public int getIdLocatario() {
        return idLocatario;
    }

    public void setIdLocatario(int idLocatario) {
        this.idLocatario = idLocatario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
       
}
