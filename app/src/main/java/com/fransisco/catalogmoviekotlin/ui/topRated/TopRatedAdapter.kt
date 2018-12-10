package com.fransisco.catalogmoviekotlin.ui.topRated

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fransisco.catalogmoviekotlin.BuildConfig
import com.fransisco.catalogmoviekotlin.R
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.ui.base.BaseAppAdapter
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewHolder
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import com.fransisco.iniBolaku.utils.extension.loadImage
import kotlinx.android.synthetic.main.item_top_rated.view.*

class TopRatedAdapter constructor(private val dataItemList: MutableList<Movie>, private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider) : BaseAppAdapter() {

    private lateinit var mListener: (Movie) -> Unit

    fun setOnItemCLickListener(listener: (Movie) -> Unit) {
        this.mListener = listener
    }

    override fun getItemCount(): Int = this.dataItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            UpcomingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_top_rated, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.let {
        holder.clear()
        holder.onBind(position)
    }

    fun addUpcomingToList(movies: List<Movie>?) {
        movies?.let {
            this.dataItemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clearItems() {
        this.dataItemList.clear()
    }

    inner class UpcomingViewHolder(view: View): BaseViewHolder(view) {

        override fun clear() {
            itemView.upcoming_img.setImageDrawable(null)
            itemView.upcoming_title_tv.text = ""
        }

        override fun onBind(position: Int) {
            inflateData(dataItemList[position])
        }

        private fun inflateData(movie: Movie) {

            movie.posterPath?.let { itemView.upcoming_img.loadImage(BuildConfig.BASE_URL_POSTER_PATH_SMALL + it) }
            itemView.upcoming_title_tv.text = movie.title

            itemView.upcoming_root.setOnClickListener {
                mListener(movie)
            }
        }

    }

}