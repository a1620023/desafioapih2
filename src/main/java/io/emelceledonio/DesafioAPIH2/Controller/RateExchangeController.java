package io.emelceledonio.DesafioAPIH2.Controller;

import io.emelceledonio.DesafioAPIH2.Model.RateExchange;
import io.emelceledonio.DesafioAPIH2.Service.RateExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rateexchange")
public class RateExchangeController {

    @Autowired
    RateExchangeService rateExchangeService;

    @GetMapping()
    public ArrayList<RateExchange> getRateExchange() {
        return rateExchangeService.getRateExchangeService();
    }

    @PostMapping()
    public RateExchange saveRateExchange(@RequestBody RateExchange rateExchange) {
        return this.rateExchangeService.saveRateExchangeService(rateExchange);
    }

    @GetMapping(path = "/{id}")
    public Optional<RateExchange> getRateExchangeById(@PathVariable("id") Long id) {
        return this.rateExchangeService.getByIdService(id);
    }

    public String deleteRateExchangeById(@PathVariable("id") Long id) {
        boolean ok = this.rateExchangeService.deleteRateExchangeService(id);
        if (ok) {
            return "The rate exchange with id: " + id + " has been deleted";
        } else {
            return "The rate exchange with id: " + id + " has not deleted !!!";
        }
    }
}
