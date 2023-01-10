package com.king.knightsra.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*

import com.facebook.applinks.AppLinkData

import com.king.knightsra.constans.ConstanceAppClass.DEEPL
import com.king.knightsra.data.CountryCodeJS
import com.king.knightsra.data.GeoDev
import com.king.knightsra.repo.Repository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RaptorViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val countryCodeJS : MutableLiveData<Response<CountryCodeJS>> = MutableLiveData()
    val geoDev : MutableLiveData<Response<GeoDev>> = MutableLiveData()






    fun getData() {
        viewModelScope.launch {
            countryCodeJS.value = repository.getData()

        }
    }


    fun getDataDev() {
        viewModelScope.launch {
            geoDev.value = repository.getDataDev()

        }
    }


    fun deePP(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params = appLinkData.targetUri.host.toString()
                 val sharedDeepl = context.getSharedPreferences(DEEPL,Application.MODE_PRIVATE)
                sharedDeepl.edit().putString(DEEPL,params).apply()
            }
            if (appLinkData == null) {

            }
        }
    }

}