package com.fransisco.catalogmoviekotlin.ui.trending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fransisco.catalogmoviekotlin.BuildConfig
import com.fransisco.catalogmoviekotlin.R
import com.fransisco.catalogmoviekotlin.data.DataManager
import com.fransisco.catalogmoviekotlin.data.model.Movie
import com.fransisco.catalogmoviekotlin.ui.base.BaseAppAdapter
import com.fransisco.catalogmoviekotlin.ui.base.BaseViewHolder
import com.fransisco.catalogmoviekotlin.utils.SchedulerProvider
import com.fransisco.iniBolaku.utils.extension.loadImage
import kotlinx.android.synthetic.main.item_trending_list.view.*

class TrendingAdapter constructor(private val dataItemList: MutableList<Movie>, private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider) : BaseAppAdapter() {

    private lateinit var mListener: (Movie) -> Unit

    fun setOnItemCLickListener(listener: (Movie) -> Unit) {
        this.mListener = listener
    }

    override fun getItemCount(): Int = this.dataItemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            NowPlayingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_trending_list, parent, false))


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.let {
        holder.clear()
        holder.onBind(position)
    }

    fun addNowPlayingToList(movies: List<Movie>?) {
        movies?.let {
            this.dataItemList.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun clearItems() {
        this.dataItemList.clear()
    }

    inner class NowPlayingViewHolder(view: View) : BaseViewHolder(view) {

        override fun clear() {
            itemView.trending_img.setImageDrawable(null)
            itemView.trending_title.text = ""
        }

        override fun onBind(position: Int) {
            inflateData(dataItemList[position])
        }

        private fun inflateData(movie: Movie) {

            movie.posterPath?.let { itemView.trending_img.loadImage(BuildConfig.BASE_URL_POSTER_PATH_SMALL + it) }
            itemView.trending_title.text = movie.title
            itemView.now_playing_goto_detail_btn.setOnClickListener {
                mListener(movie)
            }
        }
    }
}