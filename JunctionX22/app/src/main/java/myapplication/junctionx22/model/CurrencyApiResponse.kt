package myapplication.junctionx22.model

//For some reason it doesn't work when we want to convert the response to this...
//Only works if we expect the a list of CurrencyConvertion's
data class CurrencyApiResponse (
    var convertion: List<CurrencyConvertion>
)