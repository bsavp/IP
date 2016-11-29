package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
	private static CarService instance;

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	private List<Car> CarList = new ArrayList<>();

	public CarService() {
		//carList.add(new Car( "honda", "pink" 2000 dfasdfadf"));
		CarList.add(new Car("Honda", "Gray", "13 000$", "whatever"));
		CarList.add(new Car("Mini", "Blue", "14 000$", "unknown"));
		CarList.add(new Car("BMW", "Black", "15 000$", "engine200"));
		CarList.add(new Car("Audi", "Green", "16 000$", "no engine"));
		CarList.add(new Car("Fiat", "Red", "17 000$", "a guinea pig"));

	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(CarList);
	}

	public void addCar(Car Car) {
		CarList.add(Car);
	}

	public PagedResponse getCarsInPagesFiltered(int page, int perPage, String withName) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = CarList.stream().filter((u) -> u.getName().equals(withName) || withName == null)
				.skip(previousEntries).limit(perPage).collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) CarList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);

		return response;
	}

	public List<String> getAllDistinctCarNames() {
		return CarList.stream()
				.map((u) -> u.getName())
				.distinct()
				.collect(Collectors.toList());
	}
}
