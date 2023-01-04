package com.techiehub.trade.data.feeder.service;

import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.*;

@Component
public class StockInfoServiceImpl implements StockInfoService{

    @Value("${marketaux.url}")
    private String externalAPIURL;

    @Value("${marketaux.magicLetters}")
    private String magicLetters;

    @Override
    public String getStockInfo(String symbol) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        HttpUrl.Builder httpBuilder = HttpUrl.parse(externalAPIURL).newBuilder();
        httpBuilder.addQueryParameter("api_token", giveMeMagicLetters());
        httpBuilder.addQueryParameter("symbols", symbol);
        httpBuilder.addQueryParameter("limit", "10");
        Request request = new Request.Builder().url(httpBuilder.build()).build();
        Response response = client.newCall(request).execute();
        return filterAPIResponse(response, symbol);
    }

    // TODO: 12/20/22  Refactor the below code, See if you can generate the pojos and use them instead of generic types
    private String filterAPIResponse(Response response, String symbol) throws IOException, ParseException {
        String jsonData = response.body().string();
        JSONParser parser = new JSONParser(jsonData);
        LinkedHashMap<String, Object> data = parser.parseObject();
        List<LinkedHashMap<String, Object>> listOfSymbolsWithData = (List<LinkedHashMap<String, Object>>) ((LinkedHashMap)((ArrayList)data.get("data")).get(0)).get("entities");
        LinkedHashMap<String, Object> symbolData = listOfSymbolsWithData.stream().filter(entity -> entity.get("symbol").equals(symbol)).toList().get(0);
        return new Gson().toJson(symbolData, Map.class);
    }

    // TODO: 12/20/22 Store this in volumes
    private String giveMeMagicLetters() {
        return new String(Base64.getDecoder().decode(magicLetters));
    }

}
