package br.com.wellitonalt.cocktail.scenarios.main

import br.com.wellitonalt.cocktail.entities.Drink

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(drinks: List<Drink>)
    }

    interface Presenter {
        fun onLoadList()
    }

}