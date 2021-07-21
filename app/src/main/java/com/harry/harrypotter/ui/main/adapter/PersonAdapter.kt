package com.harry.harrypotter.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harry.harrypotter.databinding.ItemPersonBinding
import com.harry.harrypotter.model.Person
import com.squareup.picasso.Picasso

class PersonAdapter :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var list: List<Person> = ArrayList()
    private lateinit var binding: ItemPersonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.name.text = list[position].name
        Picasso.get().load(list[position].image).into(binding.image)
    }

    override fun getItemCount() = list.size

    fun setData(listOfPerson: List<Person>) {
        list = listOfPerson
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}