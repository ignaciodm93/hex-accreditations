accreditations-service/
├── src/main/java/com/challenge/ms/hex_accreditations/
│   ├── adapter/
│   │   ├── in/
│   │   │   ├── model/			# SaveAccreditationRequest
│   │   │   └── web/			# AccreditationController
│   │   ├── out/
│   │   │   ├── model/			
│   │   │   │	├── persistence/ 	# MongoAccreditationEntity
│   │   │   │	└── cache/       	# RedisTemplateConfig
│	│	│	├── cache/redis			#	
│	│	│	└── persistence/mongodb	# AccreditationMongoMapper, MongoAccreditationRepository, MongoAccreditationRepositoryAdapter
│	│	│ 
│   ├── application/
│   │   ├── domain/
│   │   │   ├── model/    # Accreditation, SellingPoint
│   │   │   └── service/  # GetAccreditationInteractor, SaveAccreditationInteractor
│   │   └── port/
│   │   │   ├── in/       # GetAccreditationUseCase, SaveAccreditationUseCase 
│   │   │   └── out/      # AccreditationRepositoryPort, SellingPointCachePort
│   └── HexApplication
└── src/main/resources/
└── src/test/java/
└── pom.xml