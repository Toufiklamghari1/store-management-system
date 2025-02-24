package com.stocker.stockerapp.service;

import com.stocker.stockerapp.utils.AchatFactureRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CreateFacturePdf {

	public void createPDF(AchatFactureRequest achatsFactureRequest, String type) throws IOException;

}