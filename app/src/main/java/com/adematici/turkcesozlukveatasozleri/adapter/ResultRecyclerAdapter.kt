package com.adematici.turkcesozlukveatasozleri.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.databinding.RecyclerRowResultGenelBinding
import com.adematici.turkcesozlukveatasozleri.model.KelimeModel

class ResultRecyclerAdapter(private val kelimeModel: KelimeModel,private val mContext: Context): RecyclerView.Adapter<ResultRecyclerAdapter.ResultViewHolder>() {

    class ResultViewHolder(val itemBinding: RecyclerRowResultGenelBinding):
            RecyclerView.ViewHolder(itemBinding.root){
    }

    override fun getItemCount(): Int {
        return kelimeModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = RecyclerRowResultGenelBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ResultViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.itemBinding.textViewKelime.text = "${position+1}- ${kelimeModel[position].madde}"
    }

}