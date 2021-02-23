package com.adematici.turkcesozlukveatasozleri.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.databinding.GecmisRecyclerRowBinding
import com.adematici.turkcesozlukveatasozleri.model.ArananKelimelerModel

class GecmisRecyclerAdapter(private val context: Context,private val gecmisKelimeler: ArrayList<ArananKelimelerModel>): RecyclerView.Adapter<GecmisRecyclerAdapter.GecmisViewHolder>() {

    class GecmisViewHolder(val itemBinding: GecmisRecyclerRowBinding): RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun getItemCount(): Int {
        return gecmisKelimeler.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GecmisViewHolder {
        val binding = GecmisRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GecmisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GecmisViewHolder, position: Int) {
        holder.itemBinding.textViewKelime.text = gecmisKelimeler[position].kelime
        holder.itemBinding.imageViewDelete.setOnClickListener {
            Toast.makeText(context,"Bastın",Toast.LENGTH_SHORT).show()
        }
    }
}