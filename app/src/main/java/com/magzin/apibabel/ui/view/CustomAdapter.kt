package com.magzin.apibabel.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.magzin.apibabel.R
import com.magzin.apibabel.data.model.ResultsRickMortyModel

class CustomAdapter(private var mList: List<ResultsRickMortyModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.tvName.text = "Name: " + itemsViewModel.name
        holder.tvEpisode.text = "Episode: " + itemsViewModel.episode
        holder.tvAirDate.text = "Air Date: " + itemsViewModel.airDate
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEpisode: TextView = itemView.findViewById(R.id.tvEpisode)
        val tvAirDate: TextView = itemView.findViewById(R.id.tvAirDate)
    }

    fun updateSearch(mList: List<ResultsRickMortyModel>) {
        this.mList = mList
        notifyDataSetChanged()
    }

}