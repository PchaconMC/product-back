# Backend dev technical test
We want to offer a new feature to our customers showing similar products to the one they are currently seeing. To do this we agreed with our front-end applications to create a new REST API operation that will provide them the product detail of the similar products for a given one. [Here](./similarProducts.yaml) is the contract we agreed.

We already have an endpoint that provides the product Ids similar for a given one. We also have another endpoint that returns the product detail by product Id. [Here](./existingApis.yaml) is the documentation of the existing APIs.

**Create a Spring boot application that exposes the agreed REST API on port 5000.**

![Diagram](./assets/diagram.jpg "Diagram")

Note that _Test_ and _Mocks_ components are given, you must only implement _yourApp_.

## Testing and Self-evaluation
You can run the same test we will put through your application. You just need to have docker installed.

First of all, you may need to enable file sharing for the `shared` folder on your docker dashboard -> settings -> resources -> file sharing.

Then you can start the mocks and other needed infrastructure with the following command.
```
docker-compose up -d simulado influxdb grafana
```
Check that mocks are working with a sample request to [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

To execute the test run:
```
docker-compose run --rm k6 run scripts/test.js
```
Browse [http://localhost:3000/d/Le2Ku9NMk/k6-performance-test](http://localhost:3000/d/Le2Ku9NMk/k6-performance-test) to view the results.

## Evaluation
The following topics will be considered:
- Code clarity and maintainability
- Performance
- Resilience

## Solución

1.	Estructura del proyecto: se define la estructura de proyecto como un proyecto por módulos Maven




- **product-project**: proyecto completo que agrupa una estructura por módulos 
- **business-domain**: modulo tipo pom.xml que agrupa los microservicios, este módulo contiene la configuración que es común a todos  los microservicios.

- **product**: proyecto tipo jar el cual implementa el microservicio para la solución de los requerimientos solicitados.
- **specification**: modulo tipo pom.xml que agrupa la especificación de las apis para el proyecto.
- **specification-product**: proyecto ticpo jar que implementa el enfoque api first para el microservicio producto. 


2. Ejecución de la prueba para la solución del requerimiento



- **Primero debemos instalar y generar el endpoint (API-First)**: 
ubicarnos en el proyecto product-project/specification/specification-product/ y ejecutar el comando

	./mvnw install
- **Ejecutamos el servicio para así verificar el funcionamiento**:  nos ubicamos en el proyecto project/business-domain/ product/ y ejecutar el comando

	java -jar product-0.0.1-SNAPSHOT.jar
- **Para ejecutar la prueba de funcionamiento**: ubicarse en el directorio raíz del proyecto producto-project y ejecutar el comando

	docker-compose run --rm k6 run scripts/test.js

Los resultados se presentan en la siguiente gráfica:


