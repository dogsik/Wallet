package com.example.wallet.presentation.asset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallet.domain.entity.Asset
import com.example.wallet.domain.interactor.AssetInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.fold
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
            assetInteractor.getAssetById(id).collect { result ->
                result.fold(
                    onSuccess = { asset ->
                        _asset.value = asset
                    },
                    onFailure = { exception ->
                        _error.value = exception.message
                    }
                )
            }
        }
    }
}
