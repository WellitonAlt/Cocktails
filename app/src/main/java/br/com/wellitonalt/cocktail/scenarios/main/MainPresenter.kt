package br.com.wellitonalt.cocktail.scenarios.main

import br.com.wellitonalt.cocktail.scenarios.main.MainContract
import br.com.wellitonalt.cocktail.entities.DrinkList
import br.com.wellitonalt.cocktail.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){

        val drinkService = RetrofitInicializer().createDrinkService()

        val call = drinkService.getAlcoholic()

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if(response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else {
                    view.showMessage("Sem coqueteis para hoje")
                }
            }
        })

    }

}