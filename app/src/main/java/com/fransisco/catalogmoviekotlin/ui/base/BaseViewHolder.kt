package com.fransisco.catalogmoviekotlin.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View
import com.fransisco.catalogmoviekotlin.data.model.Movie

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun clear()

    abstract fun onBind(position: Int)
}