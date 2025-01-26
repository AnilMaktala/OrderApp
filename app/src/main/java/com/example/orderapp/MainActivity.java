package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.DataStoreQuerySnapshot;
import com.amplifyframework.datastore.events.NetworkStatusEvent;
import com.amplifyframework.datastore.generated.model.AccountRepresentative;
import com.amplifyframework.datastore.generated.model.Address;
import com.amplifyframework.datastore.generated.model.Blog;
import com.amplifyframework.datastore.generated.model.Customer;
import com.amplifyframework.datastore.generated.model.Employee;
import com.amplifyframework.datastore.generated.model.Inventory;
import com.amplifyframework.datastore.generated.model.Order;
import com.amplifyframework.datastore.generated.model.Product;
import com.amplifyframework.datastore.generated.model.Warehouse;
import com.amplifyframework.hub.HubChannel;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.StreamSupport;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private static final String logger="OrderApp";
    private Button mButton;
    private Button mButton1;
    private Button mButtonDisplayOrder;
    private Button mButtonClear;
    private Button mButtonTotalOrder;
    private int orderNumber=1;
    private int totalOrders=0;
    private Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button_send);
        mButton.setOnClickListener(this);
        mButton1 = findViewById(R.id.button_order);
        mButton1.setOnClickListener(this);
        mButtonDisplayOrder=findViewById(R.id.button_displayOrder);
        mButtonDisplayOrder.setOnClickListener(this);
        mButtonClear=findViewById(R.id.button_clearDataStore);
        mButtonClear.setOnClickListener(this);
        mButtonTotalOrder=findViewById(R.id.button_totalOrders);
        mButtonTotalOrder.setOnClickListener(this);

        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("OrderApp", "Initialized Amplify");
          //  startDataStore();
            observeOrder();
            setupTimer();
            networkStatus();
            observeBlog();
            saveBlog();

        } catch (AmplifyException error) {
            Log.e("OrderApp", "Could not initialize Amplify", error);
        }
    }

    private void networkStatus(){
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                // network available
                Log.i(logger,"network avaiable");
            }

            @Override
            public void onLost(Network network) {
                // network unavailable
                Log.i(logger,"network lost");
            }
        };

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } else {
            NetworkRequest request = new NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build();
            connectivityManager.registerNetworkCallback(request, networkCallback);
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.button_send:
                addRecords();
                Log.i("OrderApp","Recrods Button clicked");
                break;
            case R.id.button_order:
                createOrders();
                Log.i("OrderApp","Order Button clicked");
                break;
            case R.id.button_displayOrder:
                deleteBlog();
                Log.i("OrderApp","DisplayOrders Button clicked");
                break;
            case R.id.button_clearDataStore:
                clearDataStore();
                Log.i(logger,"Clear Datastore clicked");
            case R.id.button_totalOrders:
                totalOrdersCount();
                Log.i(logger,"Total orders clicked");
        }
    }

    private void setupTimer(){

        Timer timer = new Timer ();
        TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run () {
                ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo nInfo = cm.getActiveNetworkInfo();
                boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
              Log.i(logger,"timer Network connected "+ connected);
            }
        };

// schedule the task to run starting now and then every minute...
        timer.schedule (hourlyTask, 0l, 1000*60*1);
    }
    private void startDataStore(){
        Amplify.DataStore.start(
                ()->{Log.i(logger,"Data Store started");
                    displayOrders();
                    },
                onError->Log.i(logger, "Error starting Datastore",onError)
        );
    }

    private void addRecords(){
        for(int i=3001;i<=4000;i++) {
            createWarehouse( i);
            createProduct(i);
            createInventory(i);
            createEmployee(i);
            createCustomer(i);
            createAddress(i);
            createAccountRepresentative(i);
        }
    }

    private void createEmployee(int i){
        Employee employee=Employee.builder()
                .name("Employee"+i)
                .startDate("2022-01-2022")
                .phoneNumber("123-456-7890")
                .warehouseId("WareHouse"+i)
                .jobTitle("Helper")
                .newHire("no")
                .id(""+i)
                .build();

        Amplify.DataStore.save(employee,
                saved-> Log.i("OrderApp","Employee saved"),
                failure-> Log.e("OrderApp","Employee save failed",failure)
                );

    }

    private void createProduct(int i){

        Product product=Product.builder()
                .name("Product"+i)
                .id("P"+i)
                .build();

        Amplify.DataStore.save(product,
                saved->Log.i("OrderApp","Product saved"),
                failure-> Log.e("OrderApp","Product save failed",failure)
                );


    }

    private void createWarehouse(int i){
        Warehouse warehouse=Warehouse.builder()
                .id("WareHouse"+i)
                .build();

        Amplify.DataStore.save(warehouse,
                saved->Log.i("OrderApp","warehouse saved"),
                failure-> Log.e("OrderApp","warehouse save failed",failure)
        );
    }

    private void createInventory(int i){
        Inventory inventory=Inventory.builder()
                .productId("P"+i)
                .warehouseId("WareHouse"+i)
                .inventoryAmount(100)
                .build();
        Amplify.DataStore.save(inventory,
                saved->Log.i("OrderApp","inventory saved"),
                failure-> Log.e("OrderApp","inventory save failed",failure)
        );
    }

    private void createCustomer(int i){
        Customer customer=Customer.builder()
                .name("Customer "+i)
                .accountRepresentativeId("AR"+i)
                .phoneNumber("123-456-7890")
                .id("c"+i)
                .build();
        Amplify.DataStore.save(customer,
                saved->Log.i("OrderApp","customer saved"),
                failure-> Log.e("OrderApp","customer save failed",failure)
        );

    }

    private void createAddress(int i){
        Address address=Address.builder()
                .address("123 Street")
                .city("city")
                .state("State")
                .customerId("c"+i)
                .build();
        Amplify.DataStore.save(address,
                saved->Log.i("OrderApp","address saved"),
                failure-> Log.e("OrderApp","address save failed",failure)
        );
    }

    private void createAccountRepresentative(int i){
        AccountRepresentative accountRepresentative= AccountRepresentative.builder()
                .id("AR"+i)
                .salesPeriod("2022")
                .build();
        Amplify.DataStore.save(accountRepresentative,
                saved->Log.i("OrderApp","accountRepresentative saved"),
                failure-> Log.e("OrderApp","accountRepresentative save failed",failure)
        );
    }

    private void createOrder(int i){

        Blog blog=Blog.builder()
                .name("blog1")
                .awsTimeValue(new Temporal.Time(String.valueOf("21:37:56.955359000")))
                .id(""+i)
                .build();
        Amplify.DataStore.save(blog,
                saved->Log.i("OrderApp","Blog saved"),
                failure-> Log.e("OrderApp","Blog save failed",failure)
        );


        Amplify.DataStore.query(Blog.class,
                matches -> {
                    while (matches.hasNext()) {
                        Blog blog1 = matches.next();
                        Log.i("OrderApp","Blog time"+blog1.getAwsTimeValue());
                    }
                },
                failure -> Log.e("OrderApp", "Query failed.", failure)
        );
       /* Order order= Order.builder()
                .customerId("c1")
                .accountRepresentativeId("AR1")
                .productId("P1")
                .status("InProcess")
                .amount(10)
                .awsTimeValue(new Temporal.Time(String.valueOf(new Date())))
                .date(String.valueOf(new Date()))
                .id(""+i)
                .build();
        Amplify.DataStore.save(order,
                saved->Log.i("OrderApp","Order saved"),
                failure-> Log.e("OrderApp","Order save failed",failure)
        );*/

    }

    private void createOrders(){
        for(int i=35011;i<=35013;i++){
            createOrder(i);
        }
        Amplify.DataStore.query(Todo.class, Where.matches(Todo.NAME.eq("Finish quarterly taxes")),
                matches -> {
                    if (matches.hasNext()) {
                        Todo todo = matches.next();
                        Todo updatedTodo = todo.copyOfBuilder()
                                .name("File quarterly taxes")
                                .build();
                        Amplify.DataStore.save(updatedTodo,
                                updated -> Log.i("Tutorial", "Updated item: " + updatedTodo.getName()),
                                failure -> Log.e("Tutorial", "Update failed.", failure)
                        );
                    }
                },
                failure -> Log.e("Tutorial", "Query failed.", failure)
        );
    }

    private void displayOrders(){
        totalOrders=0;
        Amplify.API.query
        Amplify.DataStore.query(Blog.class,
                Where.sorted(Blog.NAME.ascending()),
                matches -> {
                    while (matches.hasNext()) {
                        Log.i("OrderApp",matches.next().getId());

                    }
                },
                failure -> Log.e("OrderApp", "Query failed.", failure)
        );


       /* Amplify.DataStore.query(Order.class,
                Where.sorted(Order.DATE.ascending()),
                matches -> {
                    while (matches.hasNext()) {
                        Log.i("OrderApp",matches.next().getId());
                        totalOrders=totalOrders+1;
                    }
                },
                failure -> Log.e("OrderApp", "Query failed.", failure)
        );*/
    }

    private void deleteBlog(){
        Amplify.DataStore.query(Blog.class, Where.matches(Blog.NAME.eq("new blog 6")),
                matches -> {
                    if (matches.hasNext()) {
                        Blog deleteBlog = matches.next();
                        Amplify.DataStore.delete(deleteBlog,
                                deleted -> Log.i("OrderApp", "Deleted Blog."),
                                failure -> Log.e("OrderApp", "Delete failed.", failure)
                        );
                    }
                },
                failure -> Log.e("OrderApp", "Query failed.", failure)
        );
        /*Amplify.DataStore.stop(
                () -> Amplify.DataStore.start(
                        () -> Log.i(logger, "DataStore started"),
                        error -> Log.e(logger, "Error starting DataStore: ", error)
                ),
                error -> Log.e(logger, "Error stopping DataStore: ", error)
        );
        Log.i("OrderApp","Total Orders->"+totalOrders);*/

    }

    private void clearDataStore(){
        Amplify.DataStore.clear(
                () -> { Log.i(logger,"Start time-->"+new Date());
                Amplify.DataStore.start(
                        () -> {
                            Log.i(logger, "DataStore started");
                            Log.i(logger,"End time-->"+new Date());
                        },
                        error -> Log.e(logger, "Error starting DataStore: ", error)
                );},
                error -> Log.e(logger, "Error clearing DataStore: ", error)
        );

    }

    public void observeOrder() {


        Amplify.Hub.subscribe(
                HubChannel.DATASTORE,
                hubEvent -> DataStoreChannelEventName.NETWORK_STATUS.toString().equals(hubEvent.getName()),
                hubEvent -> {
                    NetworkStatusEvent event = (NetworkStatusEvent) hubEvent.getData();
                    Log.i(logger, "User has a network connection: " + event.getActive());
                }
        );
        Consumer<DataStoreQuerySnapshot<Order>> onQuerySnapshot = value ->{
            System.out.println("value: " + value.getItems());
            if (value.getItems().size() > 0) {
                order = value.getItems().get(0);
            }
        };
        Consumer<Cancelable> observationStarted = value ->{
            Log.d(logger, "success on cancelable");
        };
        Consumer<DataStoreException> onObservationError = value ->{
            Log.d(logger, "error on snapshot$value");
        };
        Action onObservationComplete = () ->{
            Log.d(logger, "complete");
        };

        ObserveQueryOptions options = new ObserveQueryOptions();

        Amplify.DataStore.<Order>observeQuery(
                Order.class,
                options,
                observationStarted,
                onQuerySnapshot,
                onObservationError,
                onObservationComplete
        );



      /*  Amplify.DataStore.observe(Blog.class,
                cancelable -> Log.i("OrderApp", "Blog Observation began."),
                postChanged -> {

                    Blog blog = postChanged.item();
                    Log.i("OrderApp", "Blog: " + blog);
                },
                failure -> Log.e("OrderApp", "Observation failed.", failure),
                () -> Log.i("OrderApp", "Observation complete.")
        );*/
    }

    private long totalOrdersCount(){
         long totalOrders=0;
        Amplify.DataStore.query(Blog.class,Where.matchesAll(),
                matches -> {
                    int count=0;
                    while(matches.hasNext()){
                        matches.next();
                        count++;};
                    Log.i(logger,"Query count"+count);
                    //totalOrders= new Long(count);

                },
                failure -> Log.e("OrderApp", "Query failed.", failure)
        );

        return totalOrders;
    }



    private Blog blog;
    public void observeBlog() {
        Consumer<DataStoreQuerySnapshot<Blog>> onQuerySnapshot = value ->{
            System.out.println("value: " + value.getItems());
            if (value.getItems().size() > 0) {
                blog = value.getItems().get(0);
                Log.i(logger,"Observe total count"+value.getItems().size());
            }
        };
        Consumer<Cancelable> observationStarted = value ->{
            Log.d(logger, "success on cancelable");
        };
        Consumer<DataStoreException> onObservationError = value ->{
            Log.d(logger, "error on snapshot$value");
        };
        Action onObservationComplete = () ->{
            Log.d(logger, "complete");
        };

        ObserveQueryOptions options = new ObserveQueryOptions();

        Amplify.DataStore.<Blog>observeQuery(
                Blog.class,
                options,
                observationStarted,
                onQuerySnapshot,
                onObservationError,
                onObservationComplete
        );
    }

    public void saveBlog() {
        // called from UI event, for example:
        Amplify.DataStore.save(
                Blog.builder()
                        .name("new blog 7")
                        .build(),
                updated -> Log.i(logger, "updated blog"),
                failure -> Log.e(logger, "update failed", failure)
        );
    }
}