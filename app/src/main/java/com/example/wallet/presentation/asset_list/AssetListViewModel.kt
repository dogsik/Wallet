package com.example.wallet.presentation.asset_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.interactor.GetAssetListInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetListViewModel @Inject constructor(
    private val getAssetListInteractor: GetAssetListInteractor
) : ViewModel() {
    private val _assets: MutableLiveData<List<Asset>> = MutableLiveData()
    val assets: LiveData<List<Asset>> get() = _assets

    init {
        loadAssets()
    }

    private fun loadAssets() {
        _assets.value = getAssetListInteractor.execute()
    }
}
