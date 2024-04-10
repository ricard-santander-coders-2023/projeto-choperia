package view;

import view.GerenciaMenu.MenuEstoques;

public enum MenuEstoque implements OpcaoMenu {
    CADASTRAR_PRODUTO(MenuEstoques::cadastraProduto),
    REMOVER_PRODUTO(MenuEstoques::removerProduto),
    RENOMEAR_PRODUTO(MenuEstoques:: renomearProduto),
    BUSCAR_PRODUTO(MenuEstoques::buscarProduto),
    ALTERAR_PRODUTO(MenuEstoques::alterarQuantidadeProduto),
    LISTAR_PRODUTO(MenuEstoques::listarProdutos),
    REMOVER_PRODUTOS_VENCIDOS(MenuEstoques::removerProdutosVencidos),
    ZERAR_PRODUTO(MenuEstoques::zerarEstoque);



    private final Runnable acao;

    MenuEstoque(Runnable acao) {
        this.acao = acao;
    }

    public void executar() {
        acao.run();
    }
}
