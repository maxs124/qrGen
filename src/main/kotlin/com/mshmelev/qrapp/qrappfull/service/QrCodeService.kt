package com.mshmelev.qrapp.qrappfull.service

import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
//import com.mshmelev.qrapp.qrappfull.db.domain.QrCode
//import com.mshmelev.qrapp.qrappfull.db.repository.QrCodeRepository
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*


@Service
class QrCodeService {
    companion object {
        private const val MY_FORMAT = "PNG"
        private const val HEIGHT = 1000
        private const val WIDTH = 1000
    }

    @Throws(WriterException::class, IOException::class)
//    fun getQrCode(): ByteArray {
////        val qrcode = qrCodeRepository.save(QrCode(name = UUID.randomUUID().toString(), managedBy = "mshmelev"))
//        return makeQr("${UUID.randomUUID()}")
//    }

    fun makeQr(content: String) =
            ByteArrayOutputStream(WIDTH * HEIGHT).apply {
                MatrixToImageWriter.writeToStream(QRCodeWriter().encode(
                        content,
                        BarcodeFormat.QR_CODE,
                        WIDTH, HEIGHT
                ), MY_FORMAT, this)
            }.toByteArray()

//    fun registerCode(codeId: String, clientIp:String): String {
//        val optionalQrCode = qrCodeRepository.findOneByExtId(codeId)
//        return if (optionalQrCode.isPresent) {
//            val qrCode = optionalQrCode.get()
//            qrCode.managedBy = clientIp
//            qrCodeRepository.save(qrCode)
//            "<html>it worked!</html>"
//        } else {
//            "<html>didn't work</html>"
//        }
//    }
}