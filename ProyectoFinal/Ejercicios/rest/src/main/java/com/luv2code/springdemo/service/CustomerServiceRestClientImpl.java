package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.model.Huesped;

@Service
public class CustomerServiceRestClientImpl implements HuespedService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Huesped> getHuespedes() {
		
		logger.info("***OBTENER LISTA DE HUESPEDES DESDE EL SERVICE REST HUESPED");
		logger.info("in getHuespedes(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Huesped>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Huesped>>() {});

		// get the list of huespedes from response
		List<Huesped> huespedes = responseEntity.getBody();

		logger.info("in getHuespedes(): huespedes" + huespedes);
		
		return huespedes;
	}

	@Override
	public Huesped getHuesped(int theId) {
		logger.info("***OBTENER UN HUESPED DESDE EL SERVICE REST HUESPED");

		logger.info("in getHuesped(): Calling REST API " + crmRestUrl);

		// make REST call
		Huesped theHuesped = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Huesped.class);

		logger.info("in saveHuesped(): theHuesped=" + theHuesped);
		
		return theHuesped;
	}

	@Override
	public void saveHuesped(Huesped theHuesped) {

		logger.info("in saveHuesped(): Calling REST API " + crmRestUrl);
		
		int huespedId = theHuesped.getId();

		// make REST call
		if (huespedId == 0) {
			// add employee
			logger.info("***SALVAR UN HUESPED DESDE EL SERVICE REST HUESPED");

			restTemplate.postForEntity(crmRestUrl, theHuesped, String.class);			
		
		} else {
			// update huesped
			logger.info("***ACTUALIZAR UN HUESPED DESDE EL SERVICE REST HUESPED");

			restTemplate.put(crmRestUrl, theHuesped);
		}

		logger.info("in saveHuesped(): success");	
	}

	@Override
	public void deleteHuesped(int theId) {
		logger.info("***BORRAR UN HUESPED DESDE EL SERVICE REST HUESPED");

		logger.info("in deleteHuesped(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteHuesped(): deleted huesped theId=" + theId);
	}

}
