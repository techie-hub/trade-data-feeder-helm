package com.techiehub.trade.data.feeder.controller;

import com.techiehub.trade.data.feeder.service.StockInfoService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=UTF-8")
public class TradeDataFeedController {

    @Autowired
    StockInfoService stockInfoService;

    @GetMapping(path = "stock/{symbol}")
    ResponseEntity<String> getStockInfo(@PathVariable String symbol) throws IOException, ParseException {
        String response = stockInfoService.getStockInfo(symbol);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
