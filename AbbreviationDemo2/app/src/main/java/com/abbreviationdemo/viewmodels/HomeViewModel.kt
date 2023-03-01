package com.abbreviationdemo.viewmodels

import androidx.lifecycle.ViewModel
import com.abbreviationdemo.models.AbbreviationManager
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val abbreviationManager: AbbreviationManager) : ViewModel() {

    fun getFullFormsSingle(abbreviation: String) =
        abbreviationManager.getFullFormsSingle(abbreviation).subscribeOn(
            Schedulers.io()
        )
}
