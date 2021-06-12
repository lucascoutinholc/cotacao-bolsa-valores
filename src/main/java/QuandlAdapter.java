//Quandl
import com.jimmoores.quandl.*;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

import java.time.format.DateTimeFormatter;

public class QuandlAdapter implements CotacaoBolsaServico {

    /**
     * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://www.quandl.com">Quandl</a>
     * por meio da biblioteca <a href="http://quandl4j.org">quandl4j</a>.
     * @param codigoEmpresa
     */
    @Override
    public void usandoCotacaoServico(String codigoEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Quandl: http://quandl.com/%n", codigoEmpresa);
        ClassicQuandlSession session = ClassicQuandlSession.create();
        DataSetRequest request = DataSetRequest.Builder
                .of(codigoEmpresa)
                .withMaxRows(1)
                .build();
        TabularResult result = session.getDataSet(request);
        if(result.size() > 0) {
            Row row = result.get(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = formatter.format(row.getLocalDate("Date"));
            System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));
            //System.out.println(result.toPrettyPrintedString());
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
