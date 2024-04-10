package view;


public enum MenuPrincipal  {

    MENU_CLIENTES(Menu::menuClientes),
    MENU_VEICULOS(Menu::menuEstoque),
    MENU_ALUGEL(Menu::menuVendas),
    SAIR(Menu::sair);

    private final Runnable acao;

    MenuPrincipal(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}