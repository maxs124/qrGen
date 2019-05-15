package com.mshmelev.qrapp.qrappfull.web

import com.mshmelev.qrapp.qrappfull.service.QrCodeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


    @RestController
    class ApiController(private val qrCodeService: QrCodeService) {
        @GetMapping(value = ["/time"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
        fun getVersionId(httpResponse: HttpServletResponse) =
                "{\"currentTime\":\"${LocalDateTime.now()}\"}"

    @GetMapping(value = ["/qr"], produces = [MediaType.IMAGE_PNG_VALUE])
    fun getQrCode(httpResponse: HttpServletResponse) =
            qrCodeService.makeQr(UUID.randomUUID().toString())

//    @GetMapping(value = ["/reg"], produces = [MediaType.TEXT_HTML_VALUE])
//    fun registry(@RequestParam(name = "code", required = true) qrcode: String,
//                 @RequestHeader(name = "X-FORWARDED-FOR", required = false) clientIp: String?,
//                 httpResponse: HttpServletResponse,
//                 httpRequest: HttpServletRequest) =
//            qrCodeService.registerCode(qrcode, clientIp ?: httpRequest.remoteAddr)


}