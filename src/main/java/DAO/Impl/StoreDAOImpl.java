package DAO.Impl;

import DAO.StoreDAO;
import DataBase.Impl.*;

public class StoreDAOImpl implements StoreDAO {

    private final StoreDBImpl storeDB;
    private final StoreFoodDBImpl storeFoodDB;
    private final StoreRestDaysDBImpl storeRestDaysDB;
    private final StoreTableDBImpl storeTableDB;
    private final StoreTimeDBImpl storeTimeDB;

    public StoreDAOImpl(StoreDBImpl storeDB, StoreFoodDBImpl storeFoodDB, StoreRestDaysDBImpl storeRestDaysDB, StoreTableDBImpl storeTableDB, StoreTimeDBImpl storeTimeDB){
        this.storeDB = storeDB;
        this.storeFoodDB = storeFoodDB;
        this.storeRestDaysDB = storeRestDaysDB;
        this.storeTableDB = storeTableDB;
        this.storeTimeDB = storeTimeDB;
    }
}
