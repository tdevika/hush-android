package com.hush.data.model


data class Portfolio(
        val avg_cost: String,
        val close_price: String,
        val eps: String,
        val hi_52_wk: String,
        val index: String,
        val lo_52_wk: String,
        val pe: String,
        val quantity: String,
        val sector: String,
        val security: String,
        val symbol: String,
        val lo_52_wk_pct: Int
) {
    fun getDownPct(): Int = (((close_price.toFloat() - lo_52_wk.toFloat()) * 100 )/ (hi_52_wk.toFloat() - lo_52_wk.toFloat())).toInt()
}

data class CorporateAction(
        val ex_dt: String,
        val purpose: String
)

data class HistoricalData(
        val close_price: String,
        val date: String,
        val net_trd_qty: String
)


