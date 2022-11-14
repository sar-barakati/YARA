package com.yara.android.batman.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yara.android.batman.R
import com.yara.android.batman.domain.model.Movie
import kotlinx.android.synthetic.main.vertical_card.view.*


class BatmanListAdapter :
    RecyclerView.Adapter<BatmanListAdapter.ViewHolder>() {

    private lateinit var context: Context
    var onItemClick: ((Movie) -> Unit)? = null
    var movies: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.vertical_card, parent, false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class ViewHolder(view: View, private val context: Context) :
        RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(movies[adapterPosition])
            }
        }

        fun bindView(movie: Movie) {
            itemView.firstTv.text = movie.title
            itemView.secondTv.text = movie.year
            Glide.with(context).load(movie.poster).into(itemView.coverIv)
        }
    }
}