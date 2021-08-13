package io.emelceledonio.DesafioAPIH2.Service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.emelceledonio.DesafioAPIH2.Model.CurrencyExchange;
import io.emelceledonio.DesafioAPIH2.Model.RateExchange;
import io.emelceledonio.DesafioAPIH2.Repository.CurrencyExchangeRepository;
import io.emelceledonio.DesafioAPIH2.Repository.RateExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    RateExchangeRepository rateExchangeRepositoryCES;

    @Autowired
    RateExchangeService rateExchangeServiceCES;

    public ArrayList<CurrencyExchange> getCurrencyExchangeService(){
        return (ArrayList<CurrencyExchange>) currencyExchangeRepository.findAll();
    }

    public CurrencyExchange saveCurrencyExchangeService(CurrencyExchange currencyExchange){
        return currencyExchangeRepository.save(currencyExchange);
    }

    public Optional<CurrencyExchange> getByIdService(Long id){
        return currencyExchangeRepository.findById(id);
    }

    public boolean deleteCurrencyExchangeService(Long id){
        try {
            currencyExchangeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public HashMap<String, Object> conferCurrencyExchange(CurrencyExchange currencyExchange){
        var monto = currencyExchange.getAmount();
        var tipocambio = rateExchangeServiceCES.getByIdService(1L);//.get().getCurrencyType();
        var monedaorigen = tipocambio.get().getCurrencyType();
        var preciocompra = tipocambio.get().getPurchasePrice();
        var montoresultante = monto*tipocambio.get().getPurchasePrice();


        HashMap<String, Object> map = new HashMap<>();
        map.put("monto", monto);
        map.put("monedaorigen", monedaorigen);
        map.put("monedadestino", currencyExchange.getDepartureCurrency());
        map.put("tipodecambio", preciocompra);
        map.put("montocontipocambio", montoresultante);

        return map;
    }
}
