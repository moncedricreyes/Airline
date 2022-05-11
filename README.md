<div id="top"></div>


<!-- GETTING STARTED -->
## Getting Started

* Airline Project will run on default port of tomcat PORT 8080.
* Import file to POSTMAN for reference
   - Flight.postman_collection.json
* Open Sequence Diagram 
   - sequence diagram.png

### Installation & Run The Project 

1. Clone the repo
   ```sh
   git clone https://github.com/moncedricreyes/Airline.git
   ```
2. Install eclipse on your computer.

3. Import this airline project in eclipse.

4. Update the Project.
   ```sh
   Right Click to the project > Maven > Update project > wait to finish
   ```
5. Build the Project.
   ```sh
   Right Cick to the project > Run As > 4 Maven Build > Type 'clean install' > wait to finish
   ```
6. Run the project.
   ```sh
   Right Click to the project > Run As > Java Application > choose 'AirlineApplication' 
   ```
7. Test the project.
   ```sh
   Right Click to the project > Run As > 2 JUnit Test
   ```

## API List


1. GET /flights
  ```sh
  Get All Flight
   ```
2. GET /flight/{airlineCode}
  ```sh
  Get All Flight by given airline code
   ```
3. POST /flight
  ```sh
  Add new flight
  EX. JSON BODY:
  {
    "flightNumber": "QF500",
    "departurePort": "MEL",
    "arrivalPort": "SYD",
    "departureTime": "2020-06-10T10:25:23Z",
    "arrivalTime": "2020-06-10T10:25:23Z"
  } 
   ```

