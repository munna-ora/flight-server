package com.orastays.flightserver.helper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.orastays.flightserver.dao.BookingVsPaymentDAO;
import com.orastays.flightserver.entity.BookingEntity;
import com.orastays.flightserver.entity.BookingVsPaymentEntity;
import com.orastays.flightserver.exceptions.FormExceptions;
import com.orastays.flightserver.model.BookingModel;
import com.orastays.flightserver.model.PaymentModel;
import com.orastays.flightserver.model.cashfree.RefundModel;

@Component
@RefreshScope
public class CashFreeApi {
	private static final Logger logger = LogManager.getLogger(CashFreeApi.class);

	@Autowired
	protected RestTemplate restTemplate;

	@Value("${appId}")
	private String appId;

	@Value("${secretKey}")
	private String secretKey;

	@Value("${createOrderUrl}")
	private String createOrderUrl;

	@Value("${returnUrl}")
	private String returnUrl;

	@Value("${notifyUrl}")
	private String notifyUrl;

	@Value("${initiateRefundUrl}")
	private String initiateRefundUrl;

	@Value("${generic.error.code}")
	protected String genericErrorCode;

	@Value("${generic.error.message}")
	protected String genericErrorMessage;

	@Value("${cashfreecreateorder.error.code}")
	protected String cashfreeCreateOrderErrorCode;

	@Value("${cashfreecreateorder.error.message}")
	protected String cashfreeCreateOrderErrorMessage;

	@Value("${cashfreerefundorder.error.code}")
	protected String cashfreeReundOrderErrorCode;

	@Value("${cashfreerefundorder.error.message}")
	protected String cashfreeReundOrderErrorMessage;

	@Autowired
	protected BookingVsPaymentDAO bookingVsPaymentDAO;

	public PaymentModel getPaymentLink(BookingModel bm, BookingEntity be, BookingVsPaymentEntity bookingVsPaymentEntity)
			throws FormExceptions {
		logger.debug("getPaymentLink -- Start");

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		// generate payment link
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add(FlightConstant.appId, appId);
		map.add(FlightConstant.secretKey, secretKey);
		map.add(FlightConstant.orderId, bookingVsPaymentEntity.getOrderId());
		map.add(FlightConstant.orderAmount, bookingVsPaymentEntity.getOrderAmount());
		//map.add(FlightConstant.orderCurrency, bm.getFormOfPayment().getCurrency());
		map.add(FlightConstant.customerEmail, bm.getReviewJsonModel().getUserParamsModel().getEmailId());
		map.add(FlightConstant.customerName, bm.getReviewJsonModel().getUserParamsModel().getFirstName()+ " "+
				bm.getReviewJsonModel().getUserParamsModel().getLastName());
		map.add(FlightConstant.customerPhone, bm.getReviewJsonModel().getUserParamsModel().getMobileNo());
		map.add(FlightConstant.returnUrl, returnUrl);
		map.add(FlightConstant.notifyUrl, notifyUrl);

		ResponseEntity<PaymentModel> response;
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		try {
			response = restTemplate.exchange(createOrderUrl, HttpMethod.POST, request, PaymentModel.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				if (response.getBody().getStatus().equalsIgnoreCase(FlightConstant.CASHFREE_ERROR)) {
					exceptions.put(cashfreeCreateOrderErrorCode, new Exception(cashfreeCreateOrderErrorMessage));
					throw new FormExceptions(exceptions);
				} else if (response.getBody().getStatus().equalsIgnoreCase(FlightConstant.CASHFREE_OK)) {
					try {
						bookingVsPaymentDAO.save(bookingVsPaymentEntity);
						return response.getBody();
					} catch (Exception e) {
						e.printStackTrace();
						exceptions.put(genericErrorCode, new Exception(genericErrorMessage));
						throw new FormExceptions(exceptions);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			exceptions.put(cashfreeCreateOrderErrorCode, new Exception(cashfreeCreateOrderErrorMessage));
			throw new FormExceptions(exceptions);
		}

		logger.debug("getPaymentLink -- End");

		return null;
	}

	/*
	 * This method has to be called from a service which initiate refund passing
	 * referenceid of the successful transaction
	 */

	public RefundModel initiateRefund(BookingEntity be, BookingVsPaymentEntity bookingVsPaymentEntity,
			String refundAmount, String refundNote) throws FormExceptions {
		if (logger.isDebugEnabled()) {
			logger.debug("initiateRefund -- Start");
		}

		Map<String, Exception> exceptions = new LinkedHashMap<>();

		// generate payment link
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("appId", appId);
		map.add("secretKey", secretKey);
		map.add("referenceId", bookingVsPaymentEntity.getReferenceId());
		map.add("refundAmount", refundAmount); // method which can return calculated
		map.add("refundNote", refundNote);

		ResponseEntity<RefundModel> response;
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		try {
			response = restTemplate.exchange(initiateRefundUrl, HttpMethod.POST, request, RefundModel.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				if (response.getBody().getStatus().equalsIgnoreCase(FlightConstant.CASHFREE_ERROR)) {
					exceptions.put(cashfreeReundOrderErrorCode, new Exception(cashfreeReundOrderErrorMessage));
					throw new FormExceptions(exceptions);
				} else if (response.getBody().getStatus().equalsIgnoreCase(FlightConstant.CASHFREE_OK)) {
					try { 
						//bookingVsPaymentDAO.save(bookingVsPaymentEntity);

						// save refund details into db

						return response.getBody();
					} catch (Exception e) {
						e.printStackTrace();
						exceptions.put(cashfreeReundOrderErrorCode, new Exception(cashfreeReundOrderErrorMessage));
						throw new FormExceptions(exceptions);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			exceptions.put(cashfreeReundOrderErrorCode, new Exception(cashfreeReundOrderErrorMessage));
			throw new FormExceptions(exceptions);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("initiateRefund -- End");
		}

		return null;
	}

}
