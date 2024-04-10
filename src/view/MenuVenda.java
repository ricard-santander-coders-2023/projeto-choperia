package view;

import view.GerenciaMenu.MenuVendas;

public enum MenuVenda implements OpcaoMenu {

    LANCAR_VENDA(MenuVendas::lancarVenda),
    BUSCAR_VENDA(MenuVendas::buscarVenda),
    LISTAR_VENDAS(MenuVendas::listarVendas);

    private final Runnable acao;

    MenuVenda(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
