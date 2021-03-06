package com.sambalinski.jsonstorageservice.repository

import com.sambalinski.jsonstorageservice.dto.Json
import org.springframework.stereotype.Repository

@Repository
class JsonStorageRepository {
    private val mapJsons: MutableMap<String, String> = HashMap()

    fun allJsons() = mapJsons

    fun putJson(json: Json) = mapJsons.put(json.key, json.json)

    fun findJson(key: String) = mapJsons[key]

    fun removeJson(key: String) = mapJsons.remove(key)

    fun clearAll() = mapJsons.clear()
}