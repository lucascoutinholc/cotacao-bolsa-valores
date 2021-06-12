//YahooFinance
import io.github.mainstringargs.yahooFinance.*;
import io.github.mainstringargs.yahooFinance.domain.FinancialData;

public class YahooFinanceAdapter implements CotacaoBolsaServico {

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://finance.yahoo.com">Yahoo Finance</a>
     * por meio da biblioteca <a href="https://github.com/mainstringargs/yahoo-finance-scraper">Yahoo Finance Scrapper</a>.
     * @param codigoEmpresa
     * @see <a href="http://meumobi.github.io/stocks%20apis/2016/03/13/get-realtime-stock-quotes-yahoo-finance-api.html">Get realtime stock quotes yahoo finance API</a>
     */
    @Override
    public void usandoCotacaoServico(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Yahoo Finance: https://finance.yahoo.com%n", codigoEmpresa);
        YahooFinanceUrlBuilder builder =
                new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codigoEmpresa);

        YahooFinanceRequest request = new YahooFinanceRequest();
        YahooFinanceData financeData = request.getFinanceData(request.invoke(builder));

        FinancialData financials = financeData.getFinancialData();
        if (financials != null) {
            System.out.printf("Data: Preço: %s %s%n", financials.getFinancialCurrency(), financials.getCurrentPrice().getRaw());
        }

        System.out.println(builder.getURL());
        System.out.println("https://query1.finance.yahoo.com/v8/finance/chart/" + codigoEmpresa + "?period1=1546311600&period2=1556593200&interval=1d&includePrePost=False");
        System.out.println("---------------------------------------------------------------------");
    }
}
