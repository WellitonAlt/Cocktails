package br.com.wellitonalt.cocktail.scenarios.drink

import br.com.wellitonalt.cocktail.entities.Drink

interface DrinkContract {

    interface View{
        fun showMessage(msg: String)
        fun showDrinkDetail(drinks: List<Drink>)
    }

    interface Presenter {
        fun onLoadDrink(id: Int)
        fun onLoadRandomDrink()
    }

}