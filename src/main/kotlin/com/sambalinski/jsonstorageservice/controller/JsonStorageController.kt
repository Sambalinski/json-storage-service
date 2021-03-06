package com.sambalinski.jsonstorageservice.controller

import com.sambalinski.jsonstorageservice.dto.Json
import com.sambalinski.jsonstorageservice.service.JsonStorageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonStorageController(
    private val service: JsonStorageService
) {
    @GetMapping("/jsons")
    fun getJsons() =
        ResponseEntity.ok(service.allJsons())

    @PostMapping("/json/new")
    fun newJson(@RequestBody json: Json) =
        service.newJson(json)?.let { ResponseEntity.ok(it) }

    @GetMapping("json")
    fun findJson(@RequestParam key: String) =
        service.findJson(key)?.let { ResponseEntity.ok(it) }

    @DeleteMapping("json/{key}")
    fun removeJson(@PathVariable key: String) = service.removeJson(key)

    @DeleteMapping("jsons/clear")
    fun clearAll() = service.clearAll()
}