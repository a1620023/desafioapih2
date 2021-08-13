package io.emelceledonio.DesafioAPIH2.Controller;

import io.emelceledonio.DesafioAPIH2.Model.CurrencyExchange;
import io.emelceledonio.DesafioAPIH2.Service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/currencyexchange")
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping()
    public ArrayList<CurrencyExchange> getCurrencyExchange() {
        return currencyExchangeService.getCurrencyExchangeService();
    }

    @PostMapping()
    public CurrencyExchange saveCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
        return this.currencyExchangeService.saveCurrencyExchangeService(currencyExchange);
    }

    @PostMapping(path = "/cce")
    public Object conferCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
        return this.currencyExchangeService.conferCurrencyExchange(currencyExchange);
    }
}
