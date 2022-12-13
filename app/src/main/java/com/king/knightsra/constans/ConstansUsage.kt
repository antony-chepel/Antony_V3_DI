package com.king.knightsra.constans

import android.os.Build
import com.king.knightsra.InMainClass
import com.king.knightsra.constans.ConstanceAppClass.C1
import com.king.knightsra.constans.ConstanceAppClass.DEEPL
import com.king.knightsra.constans.ConstanceAppClass.MAIN_ID
import com.king.knightsra.constans.ConstanceAppClass.link
import com.orhanobut.hawk.Hawk

object ConstansUsage {

    val pack = "com.king.knightsra"

    val cpOne:String? = Hawk.get(C1, "null")
    val mainId: String? = Hawk.get(MAIN_ID, "null")
    val dpOne: String? = Hawk.get(DEEPL, "null")



    val af_id = "deviceID="
    val subOne = "sub_id_1="
    val adid = "ad_id="
    val sub4 = "sub_id_4="
    val sub5 = "sub_id_5="
    val sub6 = "sub_id_6="


    val naming = "naming"
    val depp = "deeporg"

    val kiokjjlikjhmkij = Build.VERSION.RELEASE

    val linkAB = Hawk.get(link, "null")
}