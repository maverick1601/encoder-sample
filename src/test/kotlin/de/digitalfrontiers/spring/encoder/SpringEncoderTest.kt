package de.digitalfrontiers.spring.encoder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.Resource

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = ["server.port=8888"]
)
class SpringEncoderTest @Autowired constructor(
        val sampleFeignClient: SampleFeignClient,
        val uploadController: UploadController,
        @Value("classpath:dummy.pdf") val dummyPdf: Resource
) {


    @Test
    fun `upload binary content unaltered as byte array`() {
        val bytes = dummyPdf.inputStream.readAllBytes()
        sampleFeignClient.uploadAsByteArray(bytes)

        assertThat(uploadController.lastUploaded).`as`("binary content preserved").isEqualTo(bytes)
    }

    @Test
    fun `upload binary content unaltered as spring resource`() {
        sampleFeignClient.uploadAsSpringResource(dummyPdf)

        assertThat(uploadController.lastUploaded).`as`("binary content preserved").isEqualTo(dummyPdf.inputStream.readAllBytes())
    }
}