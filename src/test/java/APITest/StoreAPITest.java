package APITest;

import Controller.StoreController;
import DAO.Impl.StoreDAOImpl;
import DAO.StoreDAO;
import DataBase.Impl.*;
import Service.Impl.StoreServiceImpl;
import Service.StoreService;

public class StoreAPITest {


    // Store API Init
    private final StoreDBImpl storeDB = new StoreDBImpl();
    private final StoreFoodDBImpl storeFoodDB = new StoreFoodDBImpl();
    private final StoreRestDaysDBImpl storeRestDaysDB = new StoreRestDaysDBImpl();
    private final StoreTableDBImpl storeTableDB = new StoreTableDBImpl();
    private final StoreTimeDBImpl storeTimeDB = new StoreTimeDBImpl();
    private final StoreDAO storeDAO = new StoreDAOImpl(storeDB, storeFoodDB, storeRestDaysDB, storeTableDB, storeTimeDB);
    private final StoreService storeService = new StoreServiceImpl(storeDAO);
    private final StoreController storeController = new StoreController(storeService);



    // Test Main
    public static void main(String[] args){

    }

}
