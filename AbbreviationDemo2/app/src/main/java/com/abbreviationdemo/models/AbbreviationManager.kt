package com.abbreviationdemo.models

import com.abbreviationdemo.AbbreviationAPIs
import javax.inject.Inject

class AbbreviationManager @Inject constructor(
    private val abbreviationAPIs: AbbreviationAPIs
){

    fun getFullFormsSingle(abbreviation: String) = abbreviationAPIs.getFullForms(abbreviation)
}