# Store Management System

A comprehensive retail management solution handling product inventory, sales transactions, purchase orders, and credit tracking.

## Key Features

    - **Inventory Management**
      - Product categorization system
      - Stock level tracking
      - Purchase/Sale transaction recording
      - Client/Supplier management

    - **Financial Tracking**
      - Credit management system
      - Sales/Purchase invoice generation
      - Transaction history tracking

    - **Security**
      - JWT-based authentication
      - Role-based access control
      - CORS configuration
      - Password encryption

    - **Reporting**
      - PDF invoice generation (iText)
      - Financial transaction records
      - Product movement tracking

## Technology Stack
    - **Backend**
      - Java 17
      - Spring Boot 2.5.5
      - Spring Security
      - Spring Data JPA
      - iText 7.x (PDF generation)
      - MySQL Database

    - **Frontend**
      - Angular
      - Angular Material
      - RxJS
      - TypeScript

    - **Tools**
      - Maven
      - JWT Authentication

## System Architecture

    store-management-system/
    ├── .mvn/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── stocker/
    │   │   │           └── stockerapp/
    │   │   │               ├── controller/
    │   │   │               │   ├── AuthController.java
    │   │   │               │   ├── CategorieController.java
    │   │   │               │   ├── FacturePDFController.java
    │   │   │               │   ├── LoginController.java
    │   │   │               │   ├── ProductController.java
    │   │   │               │   ├── TransactionController.java
    │   │   │               │   └── UserController.java
    │   │   │               ├── dto/
    │   │   │               │   ├── AchatsDTO.java
    │   │   │               │   ├── CategorieDTO.java
    │   │   │               │   ├── ClientDTO.java
    │   │   │               │   ├── CreditDTO.java
    │   │   │               │   ├── FournisseurDTO.java
    │   │   │               │   ├── LigneAchatDTO.java
    │   │   │               │   ├── LigneVenteDTO.java
    │   │   │               │   └── ProduitDTO.java
    │   │   │               ├── entities/
    │   │   │               │   ├── Achat.java
    │   │   │               │   ├── Achats.java
    │   │   │               │   ├── Categorie.java
    │   │   │               │   ├── Client.java
    │   │   │               │   ├── Credit.java
    │   │   │               │   ├── Fournisseur.java
    │   │   │               │   ├── LigneAchat.java
    │   │   │               │   ├── LigneVente.java
    │   │   │               │   ├── Produit.java
    │   │   │               │   ├── Role.java
    │   │   │               │   ├── User.java
    │   │   │               │   └── Ventes.java
    │   │   │               ├── jwt/
    │   │   │               │   ├── JwtAuthenticationResponse.java
    │   │   │               │   └── JwtTokenProvider.java
    │   │   │               ├── repo/
    │   │   │               │   ├── AchatRepository.java
    │   │   │               │   ├── AchatsRepository.java
    │   │   │               │   ├── CategorieRepository.java
    │   │   │               │   ├── ClientRepository.java
    │   │   │               │   ├── CreditRepository.java
    │   │   │               │   ├── FournisseurRepository.java
    │   │   │               │   ├── LigneAchatRepository.java
    │   │   │               │   ├── LigneVenteRepository.java
    │   │   │               │   ├── ProductRepository.java
    │   │   │               │   ├── RoleRepository.java
    │   │   │               │   ├── UserRepository.java
    │   │   │               │   └── VentesRepository.java
    │   │   │               ├── security/
    │   │   │               │   ├── CorsFilter.java
    │   │   │               │   └── WebConfig.java
    │   │   │               ├── service/
    │   │   │               │   ├── CategorieService.java
    │   │   │               │   ├── CategorieServiceImpl.java
    │   │   │               │   ├── CreateFacturePdf.java
    │   │   │               │   ├── CreateFacturePdfImp.java
    │   │   │               │   ├── ProductService.java
    │   │   │               │   ├── ProductServiceImpl.java
    │   │   │               │   ├── TransactionService.java
    │   │   │               │   ├── TransactionServiceImpl.java
    │   │   │               │   ├── UserDetailsServiceImpl.java
    │   │   │               │   ├── UserService.java
    │   │   │               │   └── UserServiceImpl.java
    │   │   │               ├── utils/
    │   │   │               │   ├── AchatFactureRequest.java
    │   │   │               │   ├── ChartProduitDate.java
    │   │   │               │   ├── Constants.java
    │   │   │               │   ├── LoginRequest.java
    │   │   │               │   └── TransactionUtils.java
    │   │   │               └── StockerappApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── stocker/
    │                   └── stockerapp/
    │                       └── StockerappApplicationTests.java
    ├── .gitattributes
    ├── .gitignore
    ├── README.md
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml
