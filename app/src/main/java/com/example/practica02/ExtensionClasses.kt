package com.example.practica02

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.imageUrl(url: String) {
    Glide.with(this).load(url).into(this)
}