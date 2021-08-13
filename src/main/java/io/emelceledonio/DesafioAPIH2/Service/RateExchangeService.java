package io.emelceledonio.DesafioAPIH2.Service;

import io.emelceledonio.DesafioAPIH2.Model.RateExchange;
import io.emelceledonio.DesafioAPIH2.Repository.RateExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RateExchangeService {

    @Autowired
    RateExchangeRepository rateExchangeRepository;

    public ArrayList<RateExchange> getRateExchangeService(){
        return (ArrayList<RateExchange>) rateExchangeRepository.findAll();
    }

    public RateExchange saveRateExchangeService(RateExchange rateExchange){
        return rateExchangeRepository.save(rateExchange);
    }

    public Optional<RateExchange> getByIdService(Long id){
        return rateExchangeRepository.findById(id);
    }

    public boolean deleteRateExchangeService(Long id){
        try {
            rateExchangeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
