package com.adematici.turkcesozlukveatasozleri.adapter.result

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.databinding.RecyclerRowAtasozleriBinding
import com.adematici.turkcesozlukveatasozleri.model.Atasozu

class KelimeAtasozuRecyclerAdapter(private val mContext: Context, private val atasozuListesi: ArrayList<Atasozu>)
    : RecyclerView.Adapter<KelimeAtasozuRecyclerAdapter.KelimeAtasozuViewHolder>() {

    class KelimeAtasozuViewHolder(val itemBinding: RecyclerRowAtasozleriBinding)
        : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelimeAtasozuViewHolder {
        val binding = RecyclerRowAtasozleriBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KelimeAtasozuViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: KelimeAtasozuViewHolder, position: Int) {
        holder.itemBinding.textViewAtasozu.text = "${position+1}- ${atasozuListesi[position].madde}"
    }

    override fun getItemCount(): Int {
        return atasozuListesi.size
    }


}