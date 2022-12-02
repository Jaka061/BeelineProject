package com.example.beelineproject.data.storage


import androidx.room.TypeConverter
import com.example.beelineproject.data.models.Address
import com.example.beelineproject.data.models.Company
import com.example.beelineproject.data.models.Geo
import com.google.gson.Gson

class TypeListConv {

    @TypeConverter
    fun listToJson(value : List<String>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value,Array<String>::class.java).toList()

    @TypeConverter
    fun addressToJson(value : Address) = Gson().toJson(value)

    @TypeConverter
    fun jsonToAddress(value: String) = Gson().fromJson(value,Address::class.java)

    @TypeConverter
    fun geoToJson(value : Geo) = Gson().toJson(value)

    @TypeConverter
    fun jsonToGeo(value: String) = Gson().fromJson(value,Geo::class.java)

    @TypeConverter
    fun companyToJson(value : Company) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCompany(value: String) = Gson().fromJson(value,Company::class.java)

}