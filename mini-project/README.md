# Mini Car Park Nearest Lookup Service

## Approach
\- Layered architecture: Controller \-> Service \-> Repository (Spring Data JPA) \-> PostGIS.
\- Coordinates stored as `geometry(Point, 4326)` enabling spatial indexes (GiST).
\- Input validation (latitude \[-90..90], longitude \[-180..180]) with `@ControllerAdvice` for uniform 400 responses.
\- Nearest search uses PostGIS `ST_DistanceSphere` ordering with index support instead of in\-memory filtering.
\- DTOs decouple API from persistence. Tests cover 400 error cases and 200 success path.
\- Data pipeline (optional): source feed \-> SVY21 to WGS84 conversion \-> persistence.

## Trade\-offs (PostGIS vs Manual Haversine)
\- Performance: PostGIS leverages spatial indexes (GiST / SP\-GiST) avoiding full table scans; manual Haversine requires computing distance for every row.
\- Accuracy: PostGIS functions handle ellipsoidal models and edge cases; manual formulas risk precision or incorrect implementations.
\- Maintainability: Declarative SQL with `ORDER BY ST_DistanceSphere(...) LIMIT n` clearer than custom Java loops.
\- Extensibility: Adding polygons, bounding boxes, clustering, or future analytics is simpler with built\-in spatial operators.
\- Scaling: Database pushes computation close to data; reduces JVM memory and CPU footprint.

## Setup Instructions
1. Clone repo.
2. Run `docker-compose up --build`.
3. Access API at `http://localhost:8080`.

## Configuration
\- Environment overrides: `SPRING_DATASOURCE_URL`, `POSTGRES_PASSWORD`, etc.
\- Default spatial SRID: 4326 (WGS84).

## API Usage
### Nearest Car Parks
Request:
```bash
curl -s "http://localhost:8080/car-parks?latitude=1.37429&longitude=103.896&page=1&per_page=3"
