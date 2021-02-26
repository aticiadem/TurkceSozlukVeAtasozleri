package com.adematici.turkcesozlukveatasozleri.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.turkcesozlukveatasozleri.R
import com.adematici.turkcesozlukveatasozleri.adapter.GecmisRecyclerAdapter
import com.adematici.turkcesozlukveatasozleri.database.GecmisDao
import com.adematici.turkcesozlukveatasozleri.database.VeritabaniYardimcisi
import com.adematici.turkcesozlukveatasozleri.databinding.FragmentHistoryBinding
import com.adematici.turkcesozlukveatasozleri.model.ArananKelimelerModel

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: GecmisRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        //binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        //adapter = GecmisRecyclerAdapter(requireActivity(),gecmisKelimeler)
        //binding.recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.history_fragment_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_tumunu_sil -> {
                Toast.makeText(activity,"Bastın",Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return true
    }

}