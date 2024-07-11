package com.example.wallet.presentation.asset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.wallet.databinding.FragmentAssetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssetFragment : Fragment() {
    private var _binding: FragmentAssetBinding? = null
    private val binding get() = _binding!!
    val args: AssetFragmentArgs by navArgs()
    private val assetViewModel: AssetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assetViewModel.setId(args.assetId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}