package com.example.appreceitas.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appreceitas.R
import com.example.appreceitas.databinding.FragmentThirdBinding
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.view.adapter.ParentAdapterRecyclerView
import com.example.appreceitas.viewmodel.ThirdFragmentViewModel


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ThirdFragmentViewModel

    private lateinit var adapterRecyclerView: ParentAdapterRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ThirdFragmentViewModel::class.java]

        // initialize parent adapter
        adapterRecyclerView = ParentAdapterRecyclerView(
            onClick = {
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
                findNavController().navigate(action)
            },
            onClickDelete = {
                model -> FakeDB.dbObject.find {
                    it.recipeInfo[0].title == model.title
            }?.let {
                modelParent -> FakeDB.deleteRecipe(modelParent)
            }
                viewModel.groupList()
            },
            onClickUpdate = {

                val actionUpdate = ThirdFragmentDirections.actionThirdFragmentToFifthFragment(it)
                findNavController().navigate(actionUpdate)

            }
        )

        setParentAdapter()

        viewModel.groupedList.observe(viewLifecycleOwner) {
            adapterRecyclerView.setList(it)
        }
        viewModel.groupList()
    }

    fun setParentAdapter() {
        binding.idRecyclerView.apply {
            adapter = adapterRecyclerView
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
