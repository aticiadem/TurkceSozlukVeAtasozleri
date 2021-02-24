package com.adematici.turkcesozlukveatasozleri.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.adematici.turkcesozlukveatasozleri.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var kelime: String? = null

        binding.buttonAra.setOnClickListener {
            if(binding.editTextArama.text.isNotEmpty()){
                kelime = binding.editTextArama.text.toString()
                val action = SearchFragmentDirections.actionSearchFragmentToResultFragment(kelime!!)
                Navigation.findNavController(it).navigate(action)
            } else {
                Toast.makeText(activity,"Lütfen bir kelime giriniz!",Toast.LENGTH_SHORT).show()
            }
        }
    }

}