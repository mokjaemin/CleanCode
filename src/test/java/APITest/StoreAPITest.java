package APITest;

import Controller.StoreController;
import DAO.Impl.StoreDAOImpl;
import DAO.StoreDAO;
import DataBase.*;
import Service.Impl.StoreServiceImpl;
import Service.StoreService;

public class StoreAPITest {


    // Store API Init
    private final StoreDB storeDB = new StoreDB();
    private final StoreFoodDB storeFoodDB = new StoreFoodDB();
    private final StoreRestDaysDB storeRestDaysDB = new StoreRestDaysDB();
    private final StoreTableDB storeTableDB = new StoreTableDB();
    private final StoreTimeDB storeTimeDB = new StoreTimeDB();
    private final StoreDAO storeDAO = new StoreDAOImpl(storeDB, storeFoodDB, storeRestDaysDB, storeTableDB, storeTimeDB);
    private final StoreService storeService = new StoreServiceImpl(storeDAO);
    private final StoreController storeController = new StoreController(storeService);



    // Test Main
    public static void main(String[] args){

    }

}
