package com.example.zalando.logbook.services;

import com.assertj.example.api.Car;
import com.assertj.example.api.data.CarDetailsTestData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestService {

  @GetMapping(
      value = "/randomCars",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<Car> getSomeCars() {
    return List.of(
        CarDetailsTestData.lexus("A"),
        CarDetailsTestData.subaru("B"),
        CarDetailsTestData.toyota("C"));
  }

  @GetMapping(
      value = "/excludedCar",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Car getExcludedCar() {
    return CarDetailsTestData.lexus("E");
  }

  @GetMapping(
      value = "/exception",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Car getExampleException() {
    throw new IllegalStateException("Exception while retrieving the car", new IllegalArgumentException("some cause"));
  }
}
