package de.digitalfrontiers.spring.encoder

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UploadController {

    var lastUploaded: ByteArray? = null

    @PostMapping("/upload", consumes = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun storeUploaded(@RequestBody body: ByteArray) {
        lastUploaded = body
    }
}