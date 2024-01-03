# Log Ingestor System

The Log Ingestor System is a Java Spring Boot application designed to efficiently handle vast volumes of log data and offer a simple interface for querying this data using full-text search or specific field filters.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [Ingesting Logs](#ingesting-logs)
    - [Querying Logs](#querying-logs)
- [API Endpoints](#api-endpoints)
- [Sample Queries](#sample-queries)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL Database](https://dev.mysql.com/downloads/)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/AswinVishnuA/log-ingestor.git
    ```

2. Navigate to the project directory:

    ```bash
    cd logingestor
    ```

3. Build the project:

    ```bash
    mvn clean install
    ```
3. Set username and password in application.properties file:

    ```bash
    spring.datasource.username=username
    spring.datasource.password=password
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

## Usage

### Ingesting Logs

To ingest logs, send a POST request to `http://localhost:3000/logs` with log data in the specified format.

Sample Log Data Format:

```json
{
    "level": "error",
    "message": "Failed to connect to DB",
    "resourceId": "server-1234",
    "timestamp": "2023-09-15T08:00:00Z",
    "traceId": "abc-xyz-123",
    "spanId": "span-456",
    "commit": "5e5342f",
    "metadata": {
    "parentResourceId": "server-0987"
    }
}
```

# Querying Logs

The Log Manager system provides several API endpoints for querying logs based on various criteria.

## API Endpoints

- **GET /logs**: Query logs with optional parameters.

### Query Parameters

The `/logs` endpoint supports the following query parameters for filtering logs:

- **level**: Filter logs by log level.
    - Example: `GET /logs?level=error`

- **message**: Filter logs by log message (supports partial matching).
    - Example: `GET /logs?message=Failed%20to%20connect`

- **resourceId**: Filter logs by resource ID.
    - Example: `GET /logs?resourceId=server-1234`

- **startTime** and **endTime**: Filter logs within a timestamp range.
    - Example: `GET logs?startDate=2023-09-12&endDate=2023-09-16`

### Sample Queries

#### Find all logs with the level set to "error"

```bash
GET /logs?level=error
```
#### Search for logs with the message containing the term "Failed to connect"

```bash
GET /logs?message=Failed%20to%20connect
```

#### Retrieve all logs related to resourceId "server-1234"

```bash
GET /logs?resourceId=server-1234
```

#### Filter logs between the timestamp "2023-09-10T00:00:00Z" and "2023-09-15T23:59:59Z"

```bash
GET /logs?searchStartDate=2023-09-12&searchEndDate=2023-09-16
```

## Contributing

Contributions are welcome!

## License

This project is licensed under the [MIT License](LICENSE).