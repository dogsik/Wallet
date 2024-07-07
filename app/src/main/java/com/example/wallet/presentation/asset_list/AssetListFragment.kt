package com.example.wallet.presentation.asset_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.wallet.R
import com.example.wallet.databinding.FragmentAssetListBinding
import com.example.wallet.presentation.asset_list.vh.AssetListAdapter

class AssetListFragment : Fragment() {

    private var _binding: FragmentAssetListBinding? = null
    private val binding get() = _binding!!
    private val assetListViewModel: AssetListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssetListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AssetListAdapter()

        adapter.onClick = { asset ->
            findNavController().navigate(R.id.action_assetListFragment_to_assetFragment, bundleOf(Pair("asset_id", asset.id)))
        }

        binding.recycler.adapter = adapter
        assetListViewModel.assets.observe(viewLifecycleOwner, Observer { assets ->
            adapter.submit(assets)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}