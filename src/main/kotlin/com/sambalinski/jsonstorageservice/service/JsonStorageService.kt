package com.sambalinski.jsonstorageservice.service

import com.sambalinski.jsonstorageservice.dto.Json
import com.sambalinski.jsonstorageservice.repository.JsonStorageRepository
import org.springframework.stereotype.Service

@Service
class JsonStorageService(
    private val repo: JsonStorageRepository
) {

    fun allJsons() = repo.allJsons()

    fun newJson(json: Json) = repo.putJson(json)

    fun findJson(key: String) = repo.findJson(key)

    fun removeJson(key: String) = repo.removeJson(key)

    fun clearAll() = repo.clearAll()
}