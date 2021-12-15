package pe.com.bcp.exchangerate.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeResponse {

    private Float amount;
    private Float amountWithExchangeRate;
    private String originCurrency;
    private String destinationCurrency;
    private Float valueExchangeRate;
}
