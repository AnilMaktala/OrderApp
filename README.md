# OrderApp: Android Application for Order Management

OrderApp is an Android application designed for efficient order management, leveraging AWS Amplify for backend services and data synchronization.

This application provides a robust platform for managing customer orders, integrating with AWS AppSync for real-time data operations and AWS DynamoDB for data persistence. It offers features such as order creation, customer management, and real-time synchronization across devices.

## Repository Structure

```
.
├── amplify/
│   ├── backend/
│   │   ├── api/
│   │   │   └── orderapp/
│   │   ├── backend-config.json
│   │   └── tags.json
│   ├── cli.json
│   └── team-provider-info.json
├── app/
│   ├── build.gradle
│   └── src/
│       ├── androidTest/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── graphql/
│       │   └── java/
│       │       └── com/
│       │           ├── amplifyframework/
│       │           │   └── datastore/
│       │           │       └── generated/
│       │           │           └── model/
│       │           └── example/
│       │               └── orderapp/
│       │                   └── MainActivity.java
│       └── test/
├── build.gradle
└── gradlew.bat
```

### Key Files:
- `app/src/main/java/com/example/orderapp/MainActivity.java`: Main entry point of the Android application
- `app/build.gradle`: Application-level build configuration
- `build.gradle`: Project-level build configuration
- `amplify/backend/api/orderapp/schema.graphql`: GraphQL schema for the API
- `amplify/team-provider-info.json`: Amplify environment configurations

## Usage Instructions

### Installation

1. Ensure you have the following prerequisites:
   - Android Studio 4.0+
   - JDK 8+
   - AWS Account
   - Amplify CLI (npm install -g @aws-amplify/cli)

2. Clone the repository:
   ```
   git clone <repository-url>
   cd OrderApp
   ```

3. Initialize Amplify in the project:
   ```
   amplify init
   ```

4. Push the backend to AWS:
   ```
   amplify push
   ```

5. Open the project in Android Studio and sync Gradle files.

### Getting Started

1. Run the application on an emulator or physical device.
2. The `MainActivity` will initialize Amplify and set up the necessary plugins.
3. Use the UI to create orders, manage customers, and observe real-time data synchronization.

### Configuration Options

- Modify `amplify/backend/api/orderapp/schema.graphql` to adjust the data model.
- Update `app/build.gradle` to change dependencies or Android configuration.

### Common Use Cases

1. Creating an Order:
   ```java
   Order order = Order.builder()
       .customerId(customer.getId())
       .accountRepresentativeId(representative.getId())
       .productId(product.getId())
       .status("PENDING")
       .amount(100)
       .date("2023-05-20")
       .build();
   
   Amplify.DataStore.save(order,
       success -> Log.i("OrderApp", "Saved order"),
       error -> Log.e("OrderApp", "Error saving order", error)
   );
   ```

2. Querying Orders:
   ```java
   Amplify.DataStore.query(Order.class,
       orders -> {
           while (orders.hasNext()) {
               Order order = orders.next();
               Log.i("OrderApp", "Order: " + order);
           }
       },
       error -> Log.e("OrderApp", "Error querying orders", error)
   );
   ```

### Testing & Quality

Run unit tests:
```
./gradlew test
```

Run instrumented tests:
```
./gradlew connectedAndroidTest
```

### Troubleshooting

1. Issue: Amplify initialization fails
   - Error message: "Failed to initialize Amplify"
   - Diagnostic process:
     1. Check if `awsconfiguration.json` is present in `app/src/main/res/raw/`
     2. Verify AWS credentials are correctly set up
   - Solution: Run `amplify codegen models` to regenerate the configuration file

2. Issue: Data synchronization not working
   - Error message: "DataStore synchronization failed"
   - Diagnostic process:
     1. Check internet connectivity
     2. Verify API key in `amplify/backend/api/orderapp/cli-inputs.json`
   - Solution: Ensure the API key is valid and not expired

### Debugging

To enable verbose logging:
```java
Amplify.DataStore.configure(
    DataStoreConfiguration.builder()
        .logger(LogLevel.VERBOSE)
        .build());
```

Log files are located at: `/data/data/com.example.orderapp/files/amplify/logs/`

## Data Flow

The OrderApp follows a typical flow for data operations:

1. User interacts with the Android UI to create or query orders.
2. The app uses Amplify DataStore to perform local CRUD operations.
3. DataStore automatically syncs changes with the cloud backend (AWS AppSync).
4. AppSync processes the operations and updates the DynamoDB tables.
5. Any changes in the cloud are synchronized back to the device in real-time.

```
[User] <-> [Android UI] <-> [Amplify DataStore] <-> [AWS AppSync] <-> [DynamoDB]
```

Note: Ensure proper network connectivity for real-time synchronization.

## Infrastructure

The OrderApp uses the following AWS resources:

- AppSync:
  - API Name: orderapp
  - Authentication: API Key (expires after 365 days)
  - Conflict Resolution: AUTOMERGE strategy

- DynamoDB:
  - Billing Mode: PAY_PER_REQUEST
  - Server-Side Encryption: Disabled

- IAM:
  - Auth Role: amplify-orderapp-dev-211908-authRole
  - Unauth Role: amplify-orderapp-dev-211908-unauthRole

- S3:
  - Deployment Bucket: amplify-orderapp-dev-211908-deployment

- CloudFormation:
  - Stack Name: amplify-orderapp-dev-211908

Note: The infrastructure is managed by Amplify and can be updated using Amplify CLI commands.