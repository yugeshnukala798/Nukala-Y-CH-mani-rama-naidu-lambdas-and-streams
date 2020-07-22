package com.epam.lambdas_and_streams;

import java.util.*;

public class ListAverage {
	public double avg(List<Integer> list)
	{
		return list.stream().mapToInt(number -> number.intValue()).average().getAsDouble();
	}
}
