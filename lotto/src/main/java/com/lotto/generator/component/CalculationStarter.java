/**
 * 
 */
package com.lotto.generator.component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.lotto.generator.exception.DuplicateNumberException;
import com.lotto.generator.exception.UnmatchedSizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author astraservice
 *
 */
@Component
public class CalculationStarter {
	private static final Logger log = LoggerFactory.getLogger(CalculationStarter.class);

	@Autowired
	ResourceManager resourceManager;
	String SEPARATOR = " ";

	/**
	 * 
	 */
	public CalculationStarter() {
		// TODO Auto-generated constructor stub
	}

	public void startCalculation() throws IOException {
		if (resourceManager.numbers().size() != resourceManager.loadCovering().size()) {
			throw  new UnmatchedSizeException("different size from numbers - coverage",resourceManager.numbers().size(),resourceManager.loadCovering().size());
		}

		if (!areAllUnique(resourceManager.numbers())) {
			throw  new DuplicateNumberException("Duplicate item Exception",
					Integer.parseInt(findDuplicateBySetAdd(resourceManager.numbers()).stream().findFirst().orElse("")));
		}

		List<String> numbers = resourceManager.numbers();
		for (List<String> items : resourceManager.loadCovering()) {
			StringBuilder result = new StringBuilder();
			for (String index : items) {
				result.append(sortAscending(numbers).collect(Collectors.toList()).get(Integer.parseInt(index) - 1)).append(SEPARATOR);
			}
			log.info(result.toString());
		}
	}

	public <T> boolean areAllUnique(List<T> list){
		Set<T> set = new HashSet<>();
		return list.stream().allMatch(set::add);
	}

	public <T> Set<T> findDuplicateBySetAdd(List<T> list) {
		Set<T> items = new HashSet<>();
		return list.stream()
				.filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
				.collect(Collectors.toSet());

	}

	public Stream<String> sortAscending(List<String>list) {
		Comparator comparator;
		comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1).compareTo(Integer.valueOf( o2));
			}
		};
		return list.stream().sorted(comparator::compare);
	}

}
