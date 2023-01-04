package com.techiehub.trade.data.feeder.service;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface StockInfoService {
    String getStockInfo(String symbol) throws IOException, ParseException;
}
