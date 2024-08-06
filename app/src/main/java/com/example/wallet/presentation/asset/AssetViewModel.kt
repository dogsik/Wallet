package com.example.wallet.presentation.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.interactor.AssetInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssetViewModel @Inject constructor(
    private val assetInteractor: AssetInteractor
) : ViewModel() {
    private val _asset: MutableLiveData<Asset> = MutableLiveData()
    val asset: LiveData<Asset> get() = _asset

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun loadAssetById(id: Int) {
        viewModelScope.launch {
            val result = assetInteractor.getAssetById(id)
            result.fold(
                onSuccess = { myObject ->
                    _asset.value = myObject
                },
                onFailure = { exception ->
                    _error.value = exception.message
                }
            )
        }
    }
}
