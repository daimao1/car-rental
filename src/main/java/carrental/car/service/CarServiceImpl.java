package carrental.car.service;

import carrental.car.model.Car;
import carrental.car.repository.CarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public Car getCarById(Long id) {
        Car carId = carRepository.findOne(id);
        return carId;
    }

    @Override
    public Car addCar(Car car) {
        carRepository.save(car);
        return car;
    }

    @Override
    public Car updateCar(Car car) {
        Car foundCar = carRepository.findOne(car.getId());
        if (foundCar == null) {
            throw new NoResultException("Cannot update Car. Object not found.");
        }
        carRepository.save(car);
        return car;
    }

    @Override
    public void deleteCar(Long id) {
        Car foundCar = carRepository.findOne(id);
        if (foundCar == null) {
            throw new NoResultException("Cannot delete Car. Object not found.");
        }
        carRepository.delete(id);
    }

}
