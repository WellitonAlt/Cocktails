package br.com.wellitonalt.cocktail.network

import br.com.wellitonalt.cocktail.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholic(): Call<DrinkList>

    @GET("lookup.php?")
    fun getLookup(@Query("i") i: Int): Call<DrinkList>

    @GET("random.php")
    fun getRandom(): Call<DrinkList>

}