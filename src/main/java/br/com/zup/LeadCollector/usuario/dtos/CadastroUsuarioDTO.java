package br.com.zup.LeadCollector.usuario.dtos;

public class CadastroUsuarioDTO {
    private String email;
    private String senha;

    public CadastroUsuarioDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
