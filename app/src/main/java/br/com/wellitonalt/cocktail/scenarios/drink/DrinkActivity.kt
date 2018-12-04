package br.com.wellitonalt.cocktail.scenarios.drink

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.CircularProgressDrawable
import android.view.MenuItem
import android.widget.Toast
import br.com.wellitonalt.cocktail.R
import br.com.wellitonalt.cocktail.entities.Drink
import br.com.wellitonalt.cocktail.scenarios.main.MainActivity.AppConstants.DRINK_ID
import br.com.wellitonalt.cocktail.utils.GlideApp
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity(), DrinkContract.View{

    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dialog = ProgressDialog(this, R.style.ProgressDialogStyle)
        dialog.setMessage("Carregando...")

        val drinkID = intent.getStringExtra(DRINK_ID)

        progressWheel(true)
        val presenter : DrinkContract.Presenter =
            DrinkPresenter(this)
        if (drinkID != null){
            presenter.onLoadDrink(drinkID.toInt())
        } else {
            presenter.onLoadRandomDrink()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    @SuppressLint("SetTextI18n")
    override fun showDrinkDetail(drinks: List<Drink>) {
        val circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        GlideApp.with(this)
            .load(drinks[0].strDrinkThumb)
            .placeholder(circularProgressDrawable)
            .centerCrop()
            .into(imgCocktail)

         tvNome.text = "Nome do Coquetel: ${drinks[0].strDrink}"
         tvCategoria.text = "Categoria: ${drinks[0].strCategory}"
         tvCopo.text = "Copo: ${drinks[0].strGlass}"
         tvInstrucoes.text = "Instrucoes: ${drinks[0].strInstructions}"
         tvIBA.text = "IBA: ${drinks[0].strIBA}"
         tvIngredientes.text = montaIngredientes(drinks[0])
         progressWheel(false)
    }

    private fun montaIngredientes(drink: Drink): String{
        var ingredientes = "Ingredientes - Qtd: \n"
        if (drink.strIngredient1 != "")
            ingredientes = "$ingredientes ${drink.strIngredient1} - ${drink.strMeasure1} \n"
        else
            return ingredientes

        if (drink.strIngredient2 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient2} - ${drink.strMeasure2} \n"
        else
            return ingredientes

        if (drink.strIngredient3 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient3} - ${drink.strMeasure3} \n"
        else
            return ingredientes

        if (drink.strIngredient4 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient4} - ${drink.strMeasure4} \n"
        else
            return ingredientes

        if (drink.strIngredient5 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient5} - ${drink.strMeasure5} \n"
        else
            return ingredientes

        if (drink.strIngredient6 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient6} - ${drink.strMeasure6} \n"
        else
            return ingredientes

        if (drink.strIngredient7 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient7} - ${drink.strMeasure7} \n"
        else
            return ingredientes

        if (drink.strIngredient8 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient8} - ${drink.strMeasure8} \n"
        else
            return ingredientes

        if (drink.strIngredient9 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient9} - ${drink.strMeasure9} \n"
        else
            return ingredientes

        if (drink.strIngredient10 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient10} - ${drink.strMeasure10} \n"
        else
            return ingredientes

        if (drink.strIngredient11 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient11} - ${drink.strMeasure11} \n"
        else
            return ingredientes

        if (drink.strIngredient12 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient12} - ${drink.strMeasure12} \n"
        else
            return ingredientes

        if (drink.strIngredient13 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient13} - ${drink.strMeasure13} \n"
        else
            return ingredientes

        if (drink.strIngredient14 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient14} - ${drink.strMeasure14} \n"
        else
            return ingredientes

        if (drink.strIngredient15 != "")
            ingredientes = "$ingredientes  ${drink.strIngredient15} - ${drink.strMeasure15} \n"
        else
            return ingredientes

        return ingredientes
    }

    private fun progressWheel(enabled: Boolean) {
        if (enabled)
            dialog.show()
        else
            dialog.dismiss()
    }

}
