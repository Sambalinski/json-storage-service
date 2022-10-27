package com.sambalinski.jsonstorageservice.controller

import com.sambalinski.jsonstorageservice.dto.Json
import com.sambalinski.jsonstorageservice.service.JsonStorageService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("json")
class JsonStorageController(
    private val service: JsonStorageService
) {
    @GetMapping("/all", APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    fun getJsons() =
        ResponseEntity.ok(service.allJsons())

    @PostMapping("/new")
    fun newJson(@RequestBody json: Json) =
        service.newJson(json)?.let { ResponseEntity.ok(it) }

    @GetMapping("/{key}", APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    fun findJson(@PathVariable key: String) =
        service.findJson(key)?.let { ResponseEntity.ok(it) }

    @DeleteMapping("/{key}")
    fun removeJson(@PathVariable key: String) = service.removeJson(key)

    @DeleteMapping("/clearAll")
    fun clearAll() = service.clearAll()
}