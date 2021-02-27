package com.adematici.turkcesozlukveatasozleri.adapter.result

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.R
import com.adematici.turkcesozlukveatasozleri.databinding.RecyclerRowResultGenelBinding
import com.adematici.turkcesozlukveatasozleri.model.AnlamlarListe
import com.adematici.turkcesozlukveatasozleri.model.Atasozu
import com.adematici.turkcesozlukveatasozleri.model.KelimeModel

class ResultRecyclerAdapter(private val kelimeModel: KelimeModel,private val mContext: Context)
    : RecyclerView.Adapter<ResultRecyclerAdapter.ResultViewHolder>() {

    lateinit var adapterAnlam: KelimeAnlamlariRecyclerAdapter
    lateinit var adapterAtasozleri: KelimeAtasozuRecyclerAdapter

    class ResultViewHolder(val itemBinding: RecyclerRowResultGenelBinding)
        : RecyclerView.ViewHolder(itemBinding.root)

    override fun getItemCount(): Int {
        return kelimeModel.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding = RecyclerRowResultGenelBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ResultViewHolder(binding)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.itemBinding.textViewKelime.text = "${position+1}- ${kelimeModel[position].madde}"

        adapterAnlam = KelimeAnlamlariRecyclerAdapter(mContext, kelimeModel[position].anlamlarListe as ArrayList<AnlamlarListe>)

        if(kelimeModel[position].atasozu?.isNotEmpty() == true){
            holder.itemBinding.recyclerViewAtasozleri.layoutManager = LinearLayoutManager(mContext)
            adapterAtasozleri = KelimeAtasozuRecyclerAdapter(mContext,kelimeModel[position].atasozu as ArrayList<Atasozu>)
            holder.itemBinding.recyclerViewAtasozleri.adapter = adapterAtasozleri
        } else {
            holder.itemBinding.recyclerViewAtasozleri.visibility = View.INVISIBLE
        }
        /*holder.itemBinding.imageViewKaydet.setOnClickListener {
            holder.itemBinding.imageViewKaydet.setBackgroundColor(R.color.redVisne)
        }*/
        holder.itemBinding.recyclerViewAnlamlar.layoutManager = LinearLayoutManager(mContext)
        holder.itemBinding.recyclerViewAnlamlar.adapter = adapterAnlam
    }

}