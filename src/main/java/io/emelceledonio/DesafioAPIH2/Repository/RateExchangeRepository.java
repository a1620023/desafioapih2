package io.emelceledonio.DesafioAPIH2.Repository;

import io.emelceledonio.DesafioAPIH2.Model.RateExchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RateExchangeRepository extends CrudRepository<RateExchange, Long> {

    //public abstract ArrayList<RateExchange> findByCurrencyTypeRepository(String currencyType);
}
