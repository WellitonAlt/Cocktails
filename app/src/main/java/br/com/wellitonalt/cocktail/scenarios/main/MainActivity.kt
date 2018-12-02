package br.com.wellitonalt.cocktail.scenarios.main

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.wellitonalt.cocktail.R
import br.com.wellitonalt.cocktail.entities.Drink
import br.com.wellitonalt.cocktail.scenarios.drink.DrinkActivity
import br.com.wellitonalt.cocktail.scenarios.main.MainActivity.AppConstants.DRINK_ID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    object AppConstants{
        const val DRINK_ID: String = "DrinkID"
    }

    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        dialog = ProgressDialog(this, R.style.ProgressDialogStyle) //Inicia o Progress Dialog
        dialog.setMessage("Carregando...")


        val presenter : MainContract.Presenter =
            MainPresenter(this)
        progressWheel(true)
        presenter.onLoadList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.menuAleatorio -> drinkAleatorio()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showList(drinks: List<Drink>) {
        val adapter = CocktailAdapter(this, drinks)
        adapter.setOnItemClickListener {position ->
            val openDetail = Intent(this, DrinkActivity::class.java)
            openDetail.putExtra(DRINK_ID, drinks[position].idDrink)
            startActivity(openDetail)
        }
        rvCocktail.adapter = adapter
        rvCocktail.layoutManager = LinearLayoutManager(this)
        progressWheel(false)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private fun drinkAleatorio() {
        val openDetail = Intent(this, DrinkActivity::class.java)
        startActivity(openDetail)
    }

    private fun progressWheel(enabled: Boolean) {
        if (enabled)
            dialog.show()
        else
            dialog.dismiss()
    }
}
