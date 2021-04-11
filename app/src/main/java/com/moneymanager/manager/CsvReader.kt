package com.moneymanager.manager

import android.content.Context
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader

class CsvReader {

    companion object Methods {

        private const val fileNameDefault  = "RawData.csv"

        fun getData(context: Context, fileName : String = fileNameDefault) : List<Map<String,String>>{

            val inputStream = context.assets.open(fileName)

            val csvReader = csvReader{
                delimiter = ';'
            }

            val recordList = mutableListOf<Map<String,String>>()

            csvReader.open(inputStream){
                readAllWithHeaderAsSequence().forEach { row: Map<String,String> ->
                    recordList.add(row)
                }
            }

            return recordList
        }
    }
}