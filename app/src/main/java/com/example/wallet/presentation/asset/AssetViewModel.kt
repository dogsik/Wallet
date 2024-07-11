package com.example.wallet.presentation.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.interactor.GetAssetByIdInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AssetViewModel @Inject constructor(
    private val getAssetByIdInteractor: GetAssetByIdInteractor
) : ViewModel() {
    private val _asset: MutableLiveData<Asset> = MutableLiveData()
    val asset: LiveData<Asset> get() = _asset

    fun setId(id: Int) {
        loadAsset(id)
    }

    private fun loadAsset(id: Int) {
        _asset.value = getAssetByIdInteractor.execute(id)
    }
}
