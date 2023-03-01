package com.abbreviationdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abbreviationdemo.models.AbbreviationManager
import com.abbreviationdemo.viewmodels.HomeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(val abbreviationManager: AbbreviationManager): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(abbreviationManager) as T
        }

        throw IllegalArgumentException("Cannot find viewmodel")
    }
}