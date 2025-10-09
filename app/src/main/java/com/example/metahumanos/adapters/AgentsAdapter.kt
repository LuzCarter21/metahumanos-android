package com.example.metahumanos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.metahumanos.data.Agent
import com.example.metahumanos.databinding.ItemActivityMainBinding
import com.squareup.picasso.Picasso

class AgentsAdapter (var items: List<Agent>, val OnClickListener: (Int) -> Unit): RecyclerView.Adapter<AgentsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityMainBinding.inflate(layoutInflater, parent, false)
        return AgentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
       val item = items[position]
        holder.render(item)
        holder.itemView.setOnClickListener {
            OnClickListener(position)
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<Agent>){
        this.items = items
        notifyDataSetChanged()
    }

}

class AgentsViewHolder(val binding: ItemActivityMainBinding): RecyclerView.ViewHolder(binding.root){

    fun render (agents: Agent){
        binding.nameAgent.text = agents.name
        Picasso.get().load(agents.mainImageAgentView).into(binding.imageAgent)
    }

}