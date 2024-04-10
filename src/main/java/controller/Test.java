package controller;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import com.google.gson.JsonObject;

import ultis.Config;

public class Test {

	public static void main(String[] args) {

		String vnp_RequestId = Config.getRandomNumber(8);
		String vnp_Version = "2.1.0";
		String vnp_Command = "querydr";
		String vnp_TmnCode = Config.vnp_TmnCode;
		String vnp_TxnRef = "123";
		String vnp_OrderInfo = "Kiem tra ket qua GD OrderId";
		String vnp_Amount = "1806000";
		String vnp_Locale="vn";
		// String vnp_TransactionNo = req.getParameter("transactionNo");
		String vnp_TransDate = "2024-4-09";
		String vnp_CurrCode = "VND";
		String vnp_OrderType= "other";
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());

		String vnp_IpAddr = "192.168.7.16";

		JsonObject vnp_Params = new JsonObject();

		vnp_Params.addProperty("vnp_RequestId", vnp_RequestId);
		vnp_Params.addProperty("vnp_Version", vnp_Version);
		vnp_Params.addProperty("vnp_Command", vnp_Command);
		vnp_Params.addProperty("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.addProperty("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.addProperty("vnp_OrderInfo", vnp_OrderInfo);
		// vnp_Params.put("vnp_TransactionNo", vnp_TransactionNo);
		vnp_Params.addProperty("vnp_TransactionDate", vnp_TransDate);
		vnp_Params.addProperty("vnp_CreateDate", vnp_CreateDate);
		vnp_Params.addProperty("vnp_IpAddr", vnp_IpAddr);

		String hash_Data = String.join("|", vnp_Amount, vnp_Command, vnp_CreateDate, vnp_CurrCode,vnp_IpAddr,vnp_Locale,vnp_OrderInfo,vnp_OrderType,URLEncoder.encode("http://localhost:8080/cinemastar/"),vnp_TmnCode,vnp_TxnRef,vnp_Version);
		String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hash_Data.toString());

		String url = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?" + "vnp_Amount=1806000" + "&vnp_Command=pay"
				+ "&vnp_CreateDate=" + vnp_CreateDate + "&vnp_CurrCode=VND&vnp_IpAddr=" + vnp_IpAddr + "&vnp_Locale=vn"
				+ "&vnp_OrderInfo=" + vnp_OrderInfo.replace(" ", "+") + "&vnp_OrderType=other&" + "vnp_ReturnUrl="
				+ URLEncoder.encode("http://localhost:8080/cinemastar/") + "&vnp_TmnCode=" + Config.vnp_TmnCode
				+ "&vnp_TxnRef=" + vnp_TxnRef + "&vnp_Version=2.1.0" + "&vnp_SecureHash=" + vnp_SecureHash;

		System.out.println(url);
	}
}
