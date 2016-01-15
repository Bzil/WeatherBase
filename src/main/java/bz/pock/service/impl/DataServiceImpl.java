package bz.pock.service.impl;

import bz.pock.model.Data;
import bz.pock.persistence.DataDao;
import bz.pock.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public Optional<Data> getData(Long id) {
        return dataDao.findById(id);
    }

    @Override
    public Data save(Data data) {
        return dataDao.save(data);
    }
}
