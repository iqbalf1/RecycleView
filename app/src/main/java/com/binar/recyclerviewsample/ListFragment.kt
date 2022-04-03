package com.binar.recyclerviewsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binar.recyclerviewsample.binar.UserAdapter
import com.binar.recyclerviewsample.databinding.ActivityMainBinding
import com.binar.recyclerviewsample.databinding.FragmentListBinding
import java.util.zip.Inflater


class ListFragment : Fragment() {
    private lateinit var binding  : FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userList = listOf(
            Contacts("Iqbal Fadillah",85601005817),
            Contacts("Ahmad Sopian",8574371936),
            Contacts("Iqbal Fadillah",85601005817),
            Contacts("Iqbal Fadillah",85601005817),
            )
        val userAdapter = UserAdapter(userList,onItemClick = {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.recycleview.layoutManager = layoutManager
        binding.recycleview.adapter = userAdapter
    }


}