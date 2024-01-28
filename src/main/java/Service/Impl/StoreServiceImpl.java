package Service.Impl;

import DAO.StoreDAO;
import Service.StoreService;

public class StoreServiceImpl implements StoreService {

    private final StoreDAO storeDAO;

    public StoreServiceImpl(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
    }
}
