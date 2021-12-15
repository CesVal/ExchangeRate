package pe.com.bcp.exchangerate.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeRequest {

    private Float amount;
    private String originCurrency;
    private String destinationCurrency;
}
