package com.example.tugasmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class DataAdapter(private val dataList: List<DataModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = dataList[position]
            holder.bind(data)
        }

        override fun getItemCount(): Int {
            return dataList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val textViewId: TextView = itemView.findViewById(R.id.textViewId)
            private val textViewType: TextView = itemView.findViewById(R.id.textViewType)
            private val textViewSetup: TextView = itemView.findViewById(R.id.textViewSetup)
            private val textViewPunchline: TextView = itemView.findViewById(R.id.textViewPunchline)

            fun bind(data: DataModel) {
                textViewId.text = data.id.toString()
                textViewType.text = data.type
                textViewSetup.text = data.setup
                textViewPunchline.text = data.punchline
            }
        }
    }
