package com.adematici.turkcesozlukveatasozleri.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.adematici.turkcesozlukveatasozleri.database.GecmisDao
import com.adematici.turkcesozlukveatasozleri.database.VeritabaniYardimcisi
import com.adematici.turkcesozlukveatasozleri.databinding.RecyclerRowGecmisBinding
import com.adematici.turkcesozlukveatasozleri.model.ArananKelimelerModel
import com.adematici.turkcesozlukveatasozleri.ui.fragment.HistoryFragmentDirections
import com.adematici.turkcesozlukveatasozleri.ui.fragment.ResultFragmentArgs

class GecmisRecyclerAdapter(private val context: Context,private var gecmisKelimeler: ArrayList<ArananKelimelerModel>): RecyclerView.Adapter<GecmisRecyclerAdapter.GecmisViewHolder>() {

    private val vt = VeritabaniYardimcisi(context)

    class GecmisViewHolder(val itemBinding: RecyclerRowGecmisBinding): RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun getItemCount(): Int {
        return gecmisKelimeler.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GecmisViewHolder {
        val binding = RecyclerRowGecmisBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GecmisViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GecmisViewHolder, position: Int) {
        holder.itemBinding.textViewKelime.text = gecmisKelimeler[position].kelime
        holder.itemBinding.imageViewDelete.setOnClickListener {
            GecmisDao().kelimeSil(vt,gecmisKelimeler[position].kelime_id)
            gecmisKelimeler = GecmisDao().tumKelimeler(vt)
            notifyDataSetChanged()
        }
        holder.itemBinding.layout.setOnClickListener {
            val action = HistoryFragmentDirections.actionHistoryFragmentToResultFragment(gecmisKelimeler[position].kelime)
            Navigation.findNavController(it).navigate(action)
        }
    }
}