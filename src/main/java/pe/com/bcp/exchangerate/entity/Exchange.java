package pe.com.bcp.exchangerate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchange")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exchange {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "ORIGINCURRENCY")
    private String originCurrency;

    @Column(name = "DESTINATIONCURRENCY")
    private String destinationCurrency;

    @Column(name = "VALUE")
    private Float valueExchangeRate;
}
