package com.moneymanager.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Record(
    @PrimaryKey var uniqueId: String = "",
    var content: String = "",
    var details: String = ""
): RealmObject() {
}