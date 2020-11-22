package com.moneymanager.model

data class Record(
    val id: String,
    val content: String,
    val details: String) {

    override fun toString(): String = content
}