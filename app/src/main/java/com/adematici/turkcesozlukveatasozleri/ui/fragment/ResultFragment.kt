package com.adematici.turkcesozlukveatasozleri.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.turkcesozlukveatasozleri.adapter.result.ResultRecyclerAdapter
import com.adematici.turkcesozlukveatasozleri.database.GecmisDao
import com.adematici.turkcesozlukveatasozleri.database.VeritabaniYardimcisi
import com.adematici.turkcesozlukveatasozleri.databinding.FragmentResultBinding
import com.adematici.turkcesozlukveatasozleri.model.ArananKelimelerModel
import com.adematici.turkcesozlukveatasozleri.viewmodel.ResultViewModel

class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel
    private lateinit var binding: FragmentResultBinding
    private var gelenKelime: String? = null
    private lateinit var adapter: ResultRecyclerAdapter
    private lateinit var vt: VeritabaniYardimcisi
    private var deger: Boolean? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            gelenKelime = ResultFragmentArgs.fromBundle(it).kelime
        }

        vt = VeritabaniYardimcisi(requireContext())

        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        viewModel.verileriAl(gelenKelime!!)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.veriler.observe(viewLifecycleOwner, Observer { veri ->
            veri?.let {
                binding.textViewErrorMessage.visibility = View.INVISIBLE
                binding.progressBar.visibility = View.INVISIBLE
                binding.recyclerView.visibility = View.VISIBLE

                GecmisDao().kelimeEkle(vt, gelenKelime!!)

                adapter = ResultRecyclerAdapter(it, requireActivity())
                binding.recyclerView.adapter = adapter
            }
        })
        viewModel.errorMessage.observe(viewLifecycleOwner,Observer{ error ->
            error?.let {
                if (it){
                    binding.textViewErrorMessage.visibility = View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.textViewErrorMessage.visibility = View.GONE
                }
            }
        })
        viewModel.progressBar.observe(viewLifecycleOwner, Observer { message ->
            message?.let {
                if (it){
                    binding.textViewErrorMessage.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.GONE
                }
            }
        })
    }

}