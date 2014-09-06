package easyQRCodeExample;

import java.io.FileNotFoundException;

import com.google.zxing.NotFoundException;

import br.com.luizhleme.easyQRCodes.exception.QrCodeConverterException;
import br.com.luizhleme.easyQRCodes.exception.QrCodeDomainException;
import br.com.luizhleme.easyQRCodes.model.qrcode.IQrCode;
import br.com.luizhleme.easyQRCodes.model.qrcode.IQrCodeConverter.FileExtension;
import br.com.luizhleme.easyQRCodes.model.qrcode.QrCode;
import br.com.luizhleme.easyQRCodes.model.qrcode.QrCodeConverter;

public class Example {

	public static void main(String[] args) {
		
		generateQRCode();
		readingQRCode();
	}

	private static void readingQRCode() {
		System.out.println("Reading a QRCode using EasyQRCodes...");
		try {
			String qrCode = QrCodeConverter.readQrCode("C:\\easyQRCodes\\sample.jpg");
			System.out.println("The QRCode value is: " + qrCode);
		} catch (QrCodeConverterException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void generateQRCode() {
		System.out.println("Generating a QRCode using EasyQRCodes...");
		IQrCode qrCode;
		try {
			qrCode = QrCode.valueOf("EasyQRCodes a Simple QRCode example");
			QrCodeConverter.writeQrCode(qrCode, FileExtension.JPG, "C:\\easyQRCodes\\", "sample");
		} catch (QrCodeDomainException e) {
			e.printStackTrace();
		} catch (QrCodeConverterException e) {
			e.printStackTrace();
		}
	}
}
