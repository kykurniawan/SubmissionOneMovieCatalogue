package com.rizky.submissiononemoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvTitle: TextView = findViewById(R.id.tv_title)
        val tvRelease: TextView = findViewById(R.id.tv_release)
        val tvSutradara: TextView = findViewById(R.id.tv_sutradara)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val photoView: ImageView = findViewById(R.id.photoView)
        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie

        photoView.setImageResource(movie.photo)
        val title = "Judul: ${movie.title}"
        tvTitle.text = title
        val release = "Release: ${movie.release}"
        tvRelease.text = release
        val sutradara = "Sutradara: ${movie.sutradara}"
        tvSutradara.text = sutradara
        val description = movie.description
        tvDescription.text = description

        val actionbar = supportActionBar
        actionbar!!.title = movie.title
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
