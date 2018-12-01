package br.com.wellitonalt.cocktail.scenarios.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.wellitonalt.cocktail.R
import br.com.wellitonalt.cocktail.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter =
            MainPresenter(this)
        presenter.onLoadList()
    }

    override fun showList(drinks: List<Drink>) {
        val adapter = CocktailAdapter(this, drinks)
//        adapter.setOnItemClickListener {position ->
//            val openBrowser = Intent(Intent.ACTION_VIEW)
//            openBrowser.data = Uri.parse(articles.get(position).url)
//            startActivity(openBrowser)
//        }

        rvCocktail.adapter = adapter
        rvCocktail.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
