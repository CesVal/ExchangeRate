package pe.com.bcp.exchangerate.controller;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.exchangerate.dto.request.ExchangeRequest;
import pe.com.bcp.exchangerate.dto.response.BaseWebResponse;
import pe.com.bcp.exchangerate.dto.response.ExchangeResponse;
import pe.com.bcp.exchangerate.service.ExchangeService;

@RestController
@RequestMapping(value = "/api/exchange")
public class ExchangeRestController {

    @Autowired
    private ExchangeService exchangeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseWebResponse<ExchangeResponse>>> getExchangeRate(@RequestBody ExchangeRequest exchangeRequest) {
        return exchangeService.getExchangeByAmountAndOriginCurrencyAndDestinationCurrency(exchangeRequest.getAmount(),
                exchangeRequest.getOriginCurrency(), exchangeRequest.getDestinationCurrency())
                .subscribeOn(Schedulers.io())
                .map(exchangeResponse -> ResponseEntity.ok(BaseWebResponse.successWithData(toExchangeRateResponse(exchangeResponse))));
    }

    private ExchangeResponse toExchangeRateResponse(ExchangeResponse exchangeResponse) {
        ExchangeResponse response = new ExchangeResponse();
        BeanUtils.copyProperties(exchangeResponse, response);
        return response;
    }
}
