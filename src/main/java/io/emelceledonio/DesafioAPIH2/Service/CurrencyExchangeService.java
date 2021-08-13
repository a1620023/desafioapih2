package io.emelceledonio.DesafioAPIH2.Service;

import io.emelceledonio.DesafioAPIH2.Model.CurrencyExchange;
import io.emelceledonio.DesafioAPIH2.Repository.CurrencyExchangeRepository;
import io.emelceledonio.DesafioAPIH2.Repository.RateExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        var tipocambio = rateExchangeServiceCES.getRateExchangeService();

        var ece = currencyExchange.getEntryCurrency();
        var dce = currencyExchange.getDepartureCurrency();

        HashMap<String, Object> map = new HashMap<>();

        System.out.println("Esto es lo que mando: "+currencyExchange.getEntryCurrency());

        for (int i=0; i<tipocambio.size();i++){
            var mivar = tipocambio.get(i);
            var ect = mivar.getEntryCurrencyType();
            var dct = mivar.getDepartureCurrencyType();
            var pp = mivar.getPurchasePrice();
            var sp = mivar.getSellingPrice();

            double tc = 0.0;
            double montototal=0.0;

            if ((ect.equals(ece) && dct.equals(dce)) || (dct.equals(ece) && ect.equals(dce))){
                if (ece.equals(ect)){
                    System.out.println("el cliente quiere vender sus: "+ect);
                    System.out.println("multiplica=> es precio de compra");
                    montototal= monto*pp;
                    tc = pp;

                    map.put("monedaorigen", ect);
                    map.put("monedadestino", dct);


                }else if (ece.equals(dct)){
                    System.out.println("el cliente quiere comprar: "+ect);
                    System.out.println("divide=> es precio de venta");
                    montototal = monto/sp;
                    tc = sp;

                    map.put("monedaorigen", dct);
                    map.put("monedadestino", ect);


                }else {
                    System.out.println("No existe esta operacion");
                }

                map.put("monto", monto);
                map.put("tipodecambio", tc);
                map.put("montocontipocambio", montototal);

            }else {
                System.out.println("ninguno");
            }
        }
        return map;
    }
}
