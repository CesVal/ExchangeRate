package pe.com.bcp.exchangerate.service;

import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bcp.exchangerate.dto.response.ExchangeResponse;
import pe.com.bcp.exchangerate.entity.Exchange;
import pe.com.bcp.exchangerate.repository.ExchangeRepository;

import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    ExchangeRepository exchangeRepository;

    @Override
    public Single<ExchangeResponse> getExchangeByAmountAndOriginCurrencyAndDestinationCurrency(Float amount,
                                                                                               String originCurrency,
                                                                                               String destinationCurrency) {
        return obtainExchangeRateFromRepository(amount, originCurrency, destinationCurrency);
    }

    private Single<ExchangeResponse> obtainExchangeRateFromRepository(Float amount,
                                                                      String originCurrency,
                                                                      String destinationCurrency) {
        return Single.create(singleSubscriber -> {

            List<Exchange> exchangeList = exchangeRepository.findAll();

            ExchangeResponse exchangeResponse = new ExchangeResponse();
            exchangeResponse.setAmount(amount);
            exchangeResponse.setOriginCurrency(originCurrency);
            exchangeResponse.setDestinationCurrency(destinationCurrency);

            exchangeList.forEach(exchange ->
            {
                if (originCurrency.equals(exchange.getOriginCurrency())
                        && destinationCurrency.equals(exchange.getDestinationCurrency())) {
                    exchangeResponse.setAmountWithExchangeRate(amount * exchange.getValueExchangeRate());
                    exchangeResponse.setValueExchangeRate(exchange.getValueExchangeRate());
                } else if (originCurrency.equals(exchange.getDestinationCurrency())
                        && destinationCurrency.equals(exchange.getOriginCurrency())) {
                    exchangeResponse.setAmountWithExchangeRate(amount / exchange.getValueExchangeRate());
                    exchangeResponse.setValueExchangeRate(exchange.getValueExchangeRate());
                }
            });
            singleSubscriber.onSuccess(exchangeResponse);
        });
    }
}
