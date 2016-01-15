package bz.pock.service.impl;

import bz.pock.model.Sensor;
import bz.pock.persistence.SensorDao;
import bz.pock.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorDao sensorDao;

    @Override
    public Optional<Sensor> getSensor(Long id) {
        return sensorDao.findById(id);
    }
}
