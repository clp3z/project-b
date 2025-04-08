import com.clp3z.projectb.entity.CurrencyCandle
import com.clp3z.projectb.framework.persistence.model.LocalCurrencyCandle

fun CurrencyCandle.toLocalCurrencyCandle() = LocalCurrencyCandle(
    id = id,
    openingTime = openingTime,
    openPrice = openPrice,
    closeTime = closeTime,
    closePrice = closePrice,
    highPrice = highPrice,
    lowPrice = lowPrice,
    currency = currency
)

fun LocalCurrencyCandle.toCurrencyCandle() = CurrencyCandle(
    id = id,
    openingTime = openingTime,
    openPrice = openPrice,
    closeTime = closeTime,
    closePrice = closePrice,
    highPrice = highPrice,
    lowPrice = lowPrice,
    currency = currency
)

fun List<LocalCurrencyCandle>.toCurrencyCandles(): List<CurrencyCandle> =
    this.map { it.toCurrencyCandle() }
