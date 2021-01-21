package de.digitalfrontiers.spring.encoder

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "sample", url = "http://localhost:8888")
interface SampleFeignClient {

    @PostMapping("/upload", consumes = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun uploadAsByteArray(@RequestBody body: ByteArray)

    @PostMapping("/upload", consumes = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun uploadAsSpringResource(@RequestBody body: Resource)
}