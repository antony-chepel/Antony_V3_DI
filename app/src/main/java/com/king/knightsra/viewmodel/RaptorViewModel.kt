package com.king.knightsra.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.appsflyer.AppsFlyerConversionListener
import com.facebook.applinks.AppLinkData
import com.king.knightsra.constans.ConstanceAppClass.C1
import com.king.knightsra.constans.ConstanceAppClass.DEEPL
import com.king.knightsra.data.CountryCodeJS
import com.king.knightsra.data.GeoDev
import com.king.knightsra.repo.Repository
import com.orhanobut.hawk.Hawk
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RaptorViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val countryCodeJS : MutableLiveData<Response<CountryCodeJS>> = MutableLiveData()
    val geoDev : MutableLiveData<Response<GeoDev>> = MutableLiveData()



    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1, dataGotten)
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0" );
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }



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
                Hawk.put(DEEPL, params)
            }
            if (appLinkData == null) {

            }
        }
    }

}