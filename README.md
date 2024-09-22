## A practice project to learn & differenciate between Specification & crieteria builder with regular JPA offered qaueries. 
- There are some api (mentioned below) implemented using both JPA offered queries and by using SPEC & CB. 
- A service class `ProductService` includes methods declared for different types of product retrieval. 
- There are two implementations utilizing above mentioned two strategies.
- `SPEC & CB` worked for all of the declared data retrievals but JPA offered methods failed in some of the cases.

## API Overview
- GET /products/specification/{id}: Retrieve a product by its ID using specification strategy.
- GET /products/traditional/title/{title}: Fetch products by title using the traditional method.
- GET /products/specification/tags/{tagName}: Get products associated with a specific tag.
- GET /products/traditional/variants/price?maxPrice=500: Fetch products whose variant prices are below a specified value.
- GET /products/specification/{id}: Retrieve product details by ID
- GET /products/specification/tags/{tagName}: Search for products based on a specific tag
- GET /products/traditional/variants/price?maxPrice=500: Filter products by variant prices below a specified threshold
- GET /products/specification/variants/quantity?minQuantity=10: Query products based on the minimum quantity of available variants:
- GET /products/specification/tagAndVariantPriceBetween?tagName=electronics&minPrice=100&maxPrice=500: Search for products by combining attributes such as tag names with variant pricing within given limits:

And more...