package com.techiehub.trade.data.feeder.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StockInfo {

    @EqualsAndHashCode.Include
    private String symbol;

    private String data;

    @Override
    public String toString() {
        return String.format("Symbol is %s and Data is %s", symbol, data);
    }
}
