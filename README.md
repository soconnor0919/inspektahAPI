# CSCI 205 Final Project
## Team 02, Spring 2023
### Scrum Roles (Rotating):
- Sean O'Connor: Scrum Master
- Alec Sanders: Project Owner
- Geoffrey Gaines: Team Member
- Aidan Finkler: Team Member
### Project Summary
We created a program which connects to the Walmart API and allows the user to search their site for items.
Our Program provides a GUI with which the user can access the Walmart API and search for items.
The user can then sort the items by price, rating, or best seller. We originally planned to use the Ebay API, as well as Amazon,
but we were unable to access them. Most retail APIs, as it turns out, are difficult to access and use for free.



### Sprint Dates
1. Sprint 1: 11/2 - 11/9

--> by the end of sprint one, we plan on having an output that returns the cheapest ten products of given website to the console based on user's search input/request


2. Sprint 2: 11/9 - 11/16

Console-driven program completed early in the week, team plans on doing R&D over break

3. Sprint 3: 11/16 - 11/27

The team completed Lab11. We logged 9 total hours in AIE code among the members.

4. Sprint 4: 11/27 - 12/4

Complete project deliverables and video

### Package Structure
Directories:

WalmartAPI - Contains the customer key and private key needed to access the Walmart API

WalmartSearchView - GUI for the application

gui - 

    Classes: ItemCard: holds JSON info about item retrieved from Walmart API

logic - Contains MVC Programs for GUi

    Classes:

    HeaderGenerator - Formats info received from walmart API

    WalmartSearchController - Perform the search or throw an exception

    WalmartSearchModel - Specify the JSON format for the retrieved items, add items to the list

model -

    Classes:

    Item - Fields, getters, setters for the item

    RatingStars - Creates a star rating for the item

    SortType - Specify a customer sorting type (price, best seller, etc.)
    
resources - CSS Stylesheet, graphics images, Walmart API folder





### 3rd Party Libraries
- JavaFX: Version 22-ea+16. Can be found [here](https://mvnrepository.com/artifact/org.openjfx/javafx)
- Apache Commons Codec: Version 1.16.0. Can be found [here](https://mvnrepository.com/artifact/commons-codec/commons-codec)
- JSON: Version 20231013. Can be found [here](https://mvnrepository.com/artifact/org.json/json)
- JUnit Jupiter API: Version 5.9.1. Can be found [here](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- OkHttp3: Version 4.12.0. Can be found [here](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)

### Video Presentation
// TODO: Complete video presentation, place link.

Our video presentation can be found [here](https://drive.google.com).

--> slidesgo.com (?)
