package pe.com.bcp.exchangerate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.bcp.exchangerate.entity.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, String> {
}
