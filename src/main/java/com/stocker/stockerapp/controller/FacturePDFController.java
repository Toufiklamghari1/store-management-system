package com.stocker.stockerapp.controller;

import java.io.IOException;

import javax.validation.Valid;

import com.stocker.stockerapp.service.CreateFacturePdf;
import com.stocker.stockerapp.utils.AchatFactureRequest;
import com.stocker.stockerapp.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pdf")
public class FacturePDFController {

	private static final Logger logger = LoggerFactory.getLogger(FacturePDFController.class);

	@Autowired
	CreateFacturePdf createFacturePdf;

	@PutMapping(value = "/createFactureAchat", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AchatFactureRequest> createFactureAchat(@Valid @RequestBody AchatFactureRequest achatsFactureRequest, BindingResult bindingResult ) throws IOException {
		if(bindingResult.hasErrors()) {
			logger.error("Error in createFacture() : ", bindingResult.getAllErrors());
			return null;
		}else {
			logger.info("createFacture In progress ... ");
			createFacturePdf.createPDF(achatsFactureRequest, Constants.ACHAT_TITLE);
			return null;
		}

	}

	@PutMapping(value = "/createFactureVente", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AchatFactureRequest> createFactureVente(@Valid @RequestBody AchatFactureRequest achatsFactureRequest, BindingResult bindingResult ) throws IOException {
		if(bindingResult.hasErrors()) {
			logger.error("Error in createFacture() : ", bindingResult.getAllErrors());
			return null;
		}else {
			logger.info("createFacture In progress ... ");
			createFacturePdf.createPDF(achatsFactureRequest,Constants.VENTE_TITLE);
			return null;
		}

	}

}