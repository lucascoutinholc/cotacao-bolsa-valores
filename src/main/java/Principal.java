/**
 * Classe principal que mostra como obter a cotação de empresas da bolsa de valores
 * utilizando 3 serviços diferentes: Yahoo Finance, AlphaVantage e Quandl.
 * Os métodos implementados tem todo o código para utilizar as bibliotecas
 * que implementam o acesso a tais serviços.
 * Mas como podem ver, o código dos 3 métodos é totalmente diferente um do outro.
 * Ou seja, a forma de usar cada uma das bibliotecas é diferente.
 * Por isso, é preciso criar um adapter para padronizar a utilização das bibliotecas
 * e permitir trocar uma pela outra sem alterar o código do projeto.
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println();

        AlphaVantageAdapter adapterAlphaVantage = new AlphaVantageAdapter();
        QuandlAdapter adapterQuandl = new QuandlAdapter();
        YahooFinanceAdapter adapterYahooFinance = new YahooFinanceAdapter();

        //No Yahoo Finance, as empresas brasileiras terminam com ".sa"
        adapterAlphaVantage.usandoCotacaoServico("MGLU3.SA"); //MGLU3 = Magazine Luiza
        adapterQuandl.usandoCotacaoServico("WIKI/INTL"); //INTL = Intel
        adapterYahooFinance.usandoCotacaoServico("AAPL"); //AAPL = Apple
    }
}
