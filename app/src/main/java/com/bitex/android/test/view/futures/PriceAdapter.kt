package com.bitex.android.test.view.futures

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bitex.android.test.R
import com.bitex.android.test.data.model.PriceModel
import kotlinx.android.synthetic.main.items.view.*


class PriceAdapter(private val items: List<PriceModel>) :
    RecyclerView.Adapter<PriceAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View, private val context: Context) : RecyclerView.ViewHolder(view) {
        fun bindView(priceModel: PriceModel) {


            when (adapterPosition) {
                0 -> {
                    itemView.price_tv.text = context.getString(R.string.price_usdt)
                    itemView.amount_tv.text = context.getString(R.string.amount_btc)
                    itemView.price_tv.setTextColor(
                        ContextCompat.getColor(context, android.R.color.darker_gray)
                    )
                    itemView.amount_tv.setTextColor(
                        ContextCompat.getColor(context, android.R.color.darker_gray)
                    )
                }
                else -> {
                    itemView.price_tv.text = priceModel.price
                    itemView.amount_tv.text = priceModel.amount
                    if (adapterPosition > 6) {
                        itemView.price_tv.setTextColor(
                            ContextCompat.getColor(context, R.color.green_text)
                        )
                    }
                }
            }
        }
    }

}