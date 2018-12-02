package br.com.wellitonalt.cocktail.scenarios.main

import android.content.Context
import android.support.v4.widget.CircularProgressDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.wellitonalt.cocktail.R
import br.com.wellitonalt.cocktail.entities.Drink
import br.com.wellitonalt.cocktail.utils.GlideApp
import kotlinx.android.synthetic.main.cocktail_item.view.*

class CocktailAdapter(val context: Context, val drinks: List<Drink>)
    : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cocktail_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, cocktail: Drink, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.tvNome.text = cocktail.strDrink

            val circularProgressDrawable = CircularProgressDrawable(itemView.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()

            GlideApp.with(context)
                .load(cocktail.strDrinkThumb)
                .placeholder(circularProgressDrawable)
                .centerCrop()
                .into(itemView.imgCocktail)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}