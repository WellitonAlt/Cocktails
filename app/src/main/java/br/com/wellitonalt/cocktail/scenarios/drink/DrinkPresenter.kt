package br.com.wellitonalt.cocktail.scenarios.drink

import android.util.Log
import br.com.wellitonalt.cocktail.entities.DrinkDetail
import br.com.wellitonalt.cocktail.entities.DrinkList
import br.com.wellitonalt.cocktail.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkPresenter(val view : DrinkContract.View) : DrinkContract.Presenter {

    val drinkService = RetrofitInicializer().createDrinkService()

    override fun onLoadDrink(id : Int) {
        val call = drinkService.getLookup(id)

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if(response.body() != null){
                    Log.d("RETORNO", response.body()!!.drinks.toString())
                    view.showDrinkDetail(response.body()!!.drinks)
                }else {
                    view.showMessage("Ops!!! aconteceu um erro")
                }
            }
        })
    }

    override fun onLoadRandomDrink() {
        val call = drinkService.getRandom()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if(response.body() != null){
                    view.showDrinkDetail(response.body()!!.drinks)
                }else {
                    view.showMessage("Ops!!! aconteceu um erro")
                }
            }
        })

    }
}