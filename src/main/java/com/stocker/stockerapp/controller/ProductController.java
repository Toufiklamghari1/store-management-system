package com.stocker.stockerapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.stocker.stockerapp.dto.CategorieDTO;
import com.stocker.stockerapp.dto.ProduitDTO;
import com.stocker.stockerapp.entities.Produit;
import com.stocker.stockerapp.service.ProductService;
import com.stocker.stockerapp.utils.TransactionUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produits")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
    private ProductService productService;

    private ModelMapper modelMapper;

    public ProductController(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@GetMapping("/getAllProduct")
    @ResponseBody
    public List<ProduitDTO> getAllProducts() {
		logger.info("Start : getAllProducts ()");
		List<Produit> products = productService.getAllProduit();
	    List<ProduitDTO> productDtos = products.stream()
	        .map(prod -> {
	        	ProduitDTO productDto = modelMapper.map(prod, ProduitDTO.class);
	            CategorieDTO categoryDto;
				try {
					categoryDto = TransactionUtils.mapCategorieToDTO(prod.getCategorie());
					 productDto.setCategorie(categoryDto);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	logger.info(" getAllProducts : find categories ...");

	            return productDto;
	        })
	        .collect(Collectors.toList());
		logger.info("Start : getAllProducts ()");
	    return productDtos;
    }
}