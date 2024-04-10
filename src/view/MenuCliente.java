package view;

import view.GerenciaMenu.MenuClientes;

public enum MenuCliente implements OpcaoMenu {

    CADASTRAR_CLIENTE(MenuClientes::cadastraPessoa),
    ALTERAR_CLIENTE(MenuClientes::alteraCliente),
    BUSCAR_CLIENTE(MenuClientes::buscaCliente),
    LISTAR_CLIENTES(MenuClientes::listaPessoas);

    private final Runnable acao;

    MenuCliente(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
