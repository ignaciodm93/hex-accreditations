accreditations-service/
├── src/main/java/com/challenge/ms/hex_accreditations/
│   ├── adapter/
│   │   ├── in/
│   │   │   ├── model/
│   │   │   └── web/      # Controlador
│   │   ├── out/
│   │   │   ├── model/
│   │   │   ├── persistence/ # Adaptadores para MongoDB
│   │   │   └── cache/       # Adaptadores para Redis
│   ├── application/
│   │   ├── domain/
│   │   │   ├── model/    # Accreditation (entidad del dominio)
│   │   │   └── service/  # implementaciones de negocio, SaveAccreditationInteractor (casos de uso)
│   │   └── port/
│   │   │   ├── in/       # casos de uso
│   │   │   └── out/      # puertos
│   └── ...
└── src/main/resources/
└── src/test/java/
└── pom.xml