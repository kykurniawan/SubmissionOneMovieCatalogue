package com.rizky.submissiononemoviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movies = arrayListOf<Movie>()
    override fun getCount(): Int = movies.size
    override fun getItem(i: Int): Any = movies[i]
    override fun getItemId(i: Int): Long = i.toLong()
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    private inner class ViewHolder constructor(private val view: View) {
        fun bind(movie: Movie) {
            with(view){
                txt_name.text = movie.title
                txt_description.text = movie.description
                img_photo.setImageResource(movie.photo)
            }
        }
    }
}