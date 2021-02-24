package com.adematici.turkcesozlukveatasozleri.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.adematici.turkcesozlukveatasozleri.databinding.FragmentResultBinding
import com.adematici.turkcesozlukveatasozleri.viewmodel.ResultViewModel

class ResultFragment : Fragment() {

    private lateinit var viewModel: ResultViewModel
    private lateinit var binding: FragmentResultBinding
    private var gelenKelime: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            gelenKelime = ResultFragmentArgs.fromBundle(it).kelime
        }

        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        viewModel.verileriAl(gelenKelime!!)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.veriler.observe(viewLifecycleOwner, Observer { veri ->
            veri?.let {
                binding.textViewErrorMessage.visibility = View.INVISIBLE
                binding.progressBar.visibility = View.INVISIBLE
                binding.recyclerView.visibility = View.VISIBLE

                /*for(i in 0..veri.size){
                    for(j in 0..veri[i].anlamlarListe.size){
                        println(veri[i].anlamlarListe[j].anlam)
                    }
                }*/
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