package com.example.wallet.presentation.asset_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.data.defaults.Asset
import com.example.wallet.data.defaults.AssetData

class AssetListViewModel : ViewModel() {
    private val _assets: MutableLiveData<List<Asset>> = MutableLiveData()
    val assets: LiveData<List<Asset>> get() = _assets

    init {
        loadAssets()
    }

    private fun loadAssets() {
        _assets.value = AssetData.getAssets()
    }
}
