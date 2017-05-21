package carrental.car.service;

import carrental.car.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car getCarById(Long id);

    Car addCar(Car car);

    Car updateCar(Car car);

    void deleteCar(Long id);

}
