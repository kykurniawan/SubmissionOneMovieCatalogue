package com.rizky.submissiononemoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataRelease: Array<String>
    private lateinit var dataSutradara: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MovieAdapter(this)
        lv_list.adapter = adapter
        prepare()
        addItem()
        lv_list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val movie = Movie(
                movies[position].photo,
                movies[position].title,
                movies[position].release,
                movies[position].sutradara,
                movies[position].description
            )
            val moveToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            moveToDetail.putExtra(DetailActivity.EXTRA_MOVIE, movie)
            startActivity(moveToDetail)
        }
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataRelease = resources.getStringArray(R.array.data_release)
        dataSutradara = resources.getStringArray(R.array.data_sutradara)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPhoto.getResourceId(position, -1),
                dataTitle[position],
                dataRelease[position],
                dataSutradara[position],
                dataDescription[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
