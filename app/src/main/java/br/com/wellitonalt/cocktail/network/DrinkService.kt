package br.com.wellitonalt.cocktail.network

import br.com.wellitonalt.cocktail.entities.DrinklDetail
import br.com.wellitonalt.cocktail.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkService {

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholic(): Call<DrinkList>

    @GET("lookup.php?i={id}")
    fun getLookup(@Path("id") id: Int): Call<DrinklDetail>

}