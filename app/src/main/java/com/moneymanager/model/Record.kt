package com.moneymanager.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Record(
    @PrimaryKey var uniqueId : String = "",
    var account : String = "",
    var category : String = "",
    var currency : String = "",
    var amount : Float = 0.0f,
    var ref_currency_amount : Float = 0.0f,
    var type : String = "",
    var payment_type : String = "",
    var payment_type_local : String = "",
    var note : String = "",
    var date : Date = Date(),
    var gps_latitude : String = "",
    var gps_longitude : String = "",
    var gps_accuracy_in_meters : String = "",
    var warranty_in_month : Int = 0,
    var transfer : Boolean = true,
    var payee : String = "",
    var labels : String = "",
    var envelope_id : Int = 20001,
    var custom_category : Boolean = false
): RealmObject() {
}