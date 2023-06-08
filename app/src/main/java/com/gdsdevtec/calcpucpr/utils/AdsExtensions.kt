package com.gdsdevtec.calcpucpr.utils

import androidx.appcompat.app.AppCompatActivity
import com.gdsdevtec.calcpucpr.application.CalcApplication
import com.gdsdevtec.calcpucpr.application.OnShowAdCompleteListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


fun AppCompatActivity.showAdsFullScreen(
    result:()->Unit
) {
    val application = application as? CalcApplication
    if (application == null) {
        finish()
    }
    application?.showAdIfAvailable(
        this,
        object : OnShowAdCompleteListener {
            override fun onShowAdComplete() {
                result.invoke()
            }
        }
    )
}

fun AppCompatActivity.startAds(adView: AdView){
    val adRequest = AdRequest.Builder().build()
    adView.loadAd(adRequest)
}
