package io.emelceledonio.DesafioAPIH2.Repository;

import io.emelceledonio.DesafioAPIH2.Model.CurrencyExchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchange, Long> {
}
