package pe.com.bcp.exchangerate.service;

import io.reactivex.Single;
import pe.com.bcp.exchangerate.dto.response.ExchangeResponse;

public interface ExchangeService {

    Single<ExchangeResponse> getExchangeByAmountAndOriginCurrencyAndDestinationCurrency(Float amount,
                                                                                        String originCurrency,
                                                                                        String destinationCurrency);
}
