package com.adematici.turkcesozlukveatasozleri.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.databinding.RecyclerRowKelimeAnlamlariBinding
import com.adematici.turkcesozlukveatasozleri.model.AnlamlarListe

class KelimeAnlamlariRecyclerAdapter(private val mContext: Context, private val kelimeAnlamListesi: ArrayList<AnlamlarListe>):
        RecyclerView.Adapter<KelimeAnlamlariRecyclerAdapter.KelimeAnlamViewHolder>() {

    class KelimeAnlamViewHolder(val itemBinding: RecyclerRowKelimeAnlamlariBinding): RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelimeAnlamViewHolder {
        val binding = RecyclerRowKelimeAnlamlariBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KelimeAnlamViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: KelimeAnlamViewHolder, position: Int) {
        holder.itemBinding.textViewAnlam.text = "${kelimeAnlamListesi[position].anlamSira}- "+kelimeAnlamListesi[position].anlam
    }

    override fun getItemCount(): Int {
        return kelimeAnlamListesi.size
    }


}