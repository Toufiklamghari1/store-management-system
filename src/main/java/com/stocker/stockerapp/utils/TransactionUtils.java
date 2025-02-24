package com.stocker.stockerapp.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import com.stocker.stockerapp.dto.CategorieDTO;
import com.stocker.stockerapp.entities.Categorie;
import org.modelmapper.ModelMapper;


public class TransactionUtils {

	public static CategorieDTO mapCategorieToDTO(Categorie categorie) throws Exception {
		try {
			   ModelMapper modelMapper = new ModelMapper();
			    return modelMapper.map(categorie, CategorieDTO.class);
		}catch (Exception e) {
			throw new Exception();
		}

	}

	public static String preparReferenceAchats(Date date) {
		Random random = new Random();
		String formattedDate =date.toString().replaceAll("-", "");
		String reference = "ACHAT"+formattedDate+""+random.nextInt(90);
		return reference;
	}

	public static String preparReferenceVentes(Date date) {
		Random random = new Random();
		String formattedDate =date.toString().replaceAll("-", "");
		String reference = "VENTE"+formattedDate+""+random.nextInt(90);
		return reference;
	}



	public static String preparReferenceProduit(Date date) {
		Random random = new Random();
		String formattedDate = formatDate(date,"yyyyMMdd");
		String reference = "PROD"+formattedDate+""+random.nextInt(90);
		return reference;
	}

	public static String preparReferenceFacture(Date date) {
		Random random = new Random();
		String formattedDate = formatDate(date,"yyyyMMdd");
		String reference = "FT"+formattedDate+""+random.nextInt(90);
		return reference;
	}

	public static String formatDate(Date date,String pattern) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		String formattedDate = localDate.format(formatter);
		return formattedDate;

	}


}