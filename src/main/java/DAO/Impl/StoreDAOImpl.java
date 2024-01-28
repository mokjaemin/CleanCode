package DAO.Impl;

import DAO.StoreDAO;
import DataBase.*;

public class StoreDAOImpl implements StoreDAO {

    private final StoreDB storeDB;
    private final StoreFoodDB storeFoodDB;
    private final StoreRestDaysDB storeRestDaysDB;
    private final StoreTableDB storeTableDB;
    private final StoreTimeDB storeTimeDB;

    public StoreDAOImpl(StoreDB storeDB, StoreFoodDB storeFoodDB, StoreRestDaysDB storeRestDaysDB, StoreTableDB storeTableDB, StoreTimeDB storeTimeDB){
        this.storeDB = storeDB;
        this.storeFoodDB = storeFoodDB;
        this.storeRestDaysDB = storeRestDaysDB;
        this.storeTableDB = storeTableDB;
        this.storeTimeDB = storeTimeDB;
    }
}
