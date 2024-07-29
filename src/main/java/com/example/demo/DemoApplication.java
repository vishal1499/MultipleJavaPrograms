package com.example.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//separateOddAndEvenNumbers();
		//removeDuplicateElementsFromList();
		//digitFrequencyInNumber();
		//charFrequencyInAString();
		//frequencyOfEachElementInArray();
		//sortListInReverseOrder();
		//sortListOfEmployeeByDepartment();
		//joinListOfStringWithPrefixSuffixAndDelimiter();
		//printMultipleOfFromTheList();
		//findMaxAndMinInAList();
		//mergeTwoUnsortedArraysIntoSingleSortedArray();
		//findAnagram();
		//threeMaxAndMinNumberFromAList();
		//sumOfAllDigitOfANumber();
		//secondLargestNumberInAnIntegerArray();
		//sortListOfStringInIncreasingOrderOfLength();
		//commonElementBetweenTwoArrays();
		//sumAndAvgOfAllElementsOfArray();
		//reverseEachWordOfAString();
		//sumOfFirstTenNaturalNumbers();
		//reverseAnIntegerArray();
		//findStringWhichStartWithNumber();
		//palindrom();
		//findDuplicateElementOfAnArray();
		//lastElementOfAnArray();
		//ageOfAPersonInYears();
		fibonacciSeries();

	}

	private static void fibonacciSeries() {
		Stream.iterate(new  int[] {0,1}, f -> new int[] {f[1], f[0]+f[1]}).limit(10).map(f -> f[0]).forEach(i -> System.out.println(i+" "));


	}

	private static void ageOfAPersonInYears() {
		LocalDate birthdate = LocalDate.of(1980,07, 23);
		LocalDate todaydate = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthdate,todaydate));
	}

	private static void lastElementOfAnArray() {
		String[] strArr = {"6uddi","badi","6uddi","8ueen","bhai", "hai"};
		System.out.println(Arrays.stream(strArr).skip(strArr.length-1).findFirst().get());
	}

	private static void findDuplicateElementOfAnArray() {
		String[] strArr = {"6uddi","badi","6uddi","8ueen","hai", "hai"};
		Set<String> set = new HashSet<>();
		System.out.println(Arrays.stream(strArr).filter(str -> !set.add(str)).collect(Collectors.toSet()));
	}

	private static void palindrom() {
		String str = "abcdcba";

		if(IntStream.range(0, str.length()).noneMatch(i -> str.charAt(i) != str.charAt(str.length() -i-1))){
			System.out.println("a plaindrom");
		}else{
			System.out.println("not a plaindrom");
		}
	}

	private static void findStringWhichStartWithNumber() {
		List<String> list = Arrays.asList("6uddi","badi","drama","8ueen","hai");
		list.stream().filter(str -> Character.isDigit(str.charAt(0))).collect(Collectors.toList()).forEach(System.out::println);
	}

	private static void reverseAnIntegerArray() {
		int[] array = {2,1,66,3,78,34};
		int[] array1;
		printArray(array);
		array1 = IntStream.rangeClosed(1, array.length).map(i -> array[array.length-i]).toArray();
		printArray(array1);
	}

	private static void printArray(int[] arr1) {
		System.out.print("{");
		for (int i = 0; i< arr1.length; i++) {
		  System.out.print(arr1[i]);
		  if(i < arr1.length-1){
			  System.out.print(",");
		  }
		}
		System.out.print("}\n");
	}

	private static void sumOfFirstTenNaturalNumbers() {

		System.out.println(IntStream.range(1,10).sum());
	}

	private static void reverseEachWordOfAString() {
		String str = "My name is vishal";
		str = Arrays.stream(str.split(" ")).map(a -> new StringBuffer(a).reverse()).collect(Collectors.joining(" "));
		System.out.println(str);
	}

	private static void sumAndAvgOfAllElementsOfArray() {
		int[] arr1 = {2,1,66,3,78,34};
		int[] arr2 = {22,1,6,3,50,34};

		//1st way
		System.out.println(Arrays.stream(arr1).sum());
		System.out.println(Arrays.stream(arr1).average());

		//2nd way
		Arrays.stream((Integer[])getIntegerList(arr1).toArray()).mapToInt(Integer::intValue).sum();
	}

	private static void commonElementBetweenTwoArrays() {
		int[] arr1 = {2,1,66,3,78,34};
		int[] arr2 = {22,1,6,3,50,34};

		getIntegerList(arr1).stream().filter(getIntegerList(arr2)::contains).forEach(System.out::println);
	}

	private static List<Integer> getIntegerList(int[] arr) {
		return Arrays.stream(arr).boxed().toList();
	}

	private static void sortListOfStringInIncreasingOrderOfLength() {
		List<String> list = Arrays.asList("chewbaacaajedi","wookipedia","mandlorians","starwars");

		//1st way
		list.stream().sorted((a,b) -> { if(a.length() < b.length()) return 1; else return -1; }).forEach(System.out::println);

		//2nd way
		list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
	}

	private static void secondLargestNumberInAnIntegerArray() {
		List<Integer> list = Arrays.asList(34,2,56,11,23);
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
	}

	private static void sumOfAllDigitOfANumber() {
		int num = 837456;
		System.out.println(Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer::parseInt)).intValue());
	}

	private static void threeMaxAndMinNumberFromAList() {
		Data.oddEvenListOfInt.stream().sorted(Comparator.naturalOrder()).limit(3).forEach(System.out::println);
		Data.oddEvenListOfInt.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}

	private static void findAnagram() {
		String s1 = "triangle";
		String s2 = "integral";
		s1 = Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s1.equals(s2)){
			System.out.println("It's an Anagram");
		}
	}

	private static void mergeTwoUnsortedArraysIntoSingleSortedArray() {
		int[] arr = IntStream.concat(Data.oddEvenListOfInt.stream().mapToInt(Integer::intValue),
				Data.duplicateListOfInt.stream().mapToInt(Integer::intValue)).distinct().sorted().toArray();
		Arrays.stream(arr).forEach(System.out::println);

	}

	private static void findMaxAndMinInAList() {
		//1st way
		System.out.println(Data.oddEvenListOfInt.stream().sorted(Comparator.naturalOrder()).findFirst());
		System.out.println(Data.oddEvenListOfInt.stream().sorted(Comparator.reverseOrder()).findFirst());

		//2nd way
		System.out.println(Data.oddEvenListOfInt.stream().max(Comparator.naturalOrder()));
		System.out.println((Data.oddEvenListOfInt.stream().min(Comparator.naturalOrder())));
	}

	private static void printMultipleOfFromTheList() {
		System.out.println(Data.oddEvenListOfInt.stream().filter(a -> a%5 == 0).collect(Collectors.toList()));
	}

	private static void joinListOfStringWithPrefixSuffixAndDelimiter() {
		System.out.println(Data.listOfString.stream().collect(Collectors.joining(":")));
	}

	private static void sortListOfEmployeeByDepartment() {
		List<Employee> listOfEmp = new ArrayList<>();
		listOfEmp.add(Employee.builder().age(60).name("Mike").Department("IT").build());
		listOfEmp.add(Employee.builder().age(50).name("Blake").Department("Finance").build());
		listOfEmp.add(Employee.builder().age(40).name("Amber").Department("HR").build());
		listOfEmp.add(Employee.builder().age(45).name("Hick").Department("Sales").build());
		listOfEmp.add(Employee.builder().age(20).name("Amber").Department("Ecommerce").build());

		System.out.println(listOfEmp.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList()));
		System.out.println(listOfEmp.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).collect(Collectors.toList()));
		Map<String, List<Employee>> listByDepartment = listOfEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(listByDepartment);
	}

	private static void sortListInReverseOrder() {
		List<String> list = Data.listOfString.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(list);

		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		list.sort(Comparator.naturalOrder());
		System.out.println(list);
	}

	private static void frequencyOfEachElementInArray() {
		Map<String, Long> map = Arrays.stream(Data.strArrayFrequency).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
	}

	private static void separateOddAndEvenNumbers() {
		Map<Boolean, List<Integer>> map = Data.oddEvenListOfInt.stream().
				collect(Collectors.partitioningBy(a -> a%2==0));
		System.out.println(map);
	}

	private static void removeDuplicateElementsFromList(){
		System.out.println(Data.duplicateListOfInt.stream().distinct().collect(Collectors.toList()));
	}

	private static void digitFrequencyInNumber(){
		Map<Integer, Long> map = Data.duplicateListOfInt.stream().
				collect(Collectors.groupingBy(t->t,Collectors.counting()));
		System.out.println(map);
	}

	private static void charFrequencyInAString(){
  		Map<Object, Long> map = Data.strCharFrequency.chars().mapToObj(c -> (char)c).
				collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);

		map = Arrays.stream(Data.strFrequency.split(" ")).
				collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
	}
	@lombok.Data
	static class Data{
		static List<Integer> oddEvenListOfInt = Arrays.asList(3,2,1,4,8,6,7,5,9,10);
		static List<Integer> duplicateListOfInt = Arrays.asList(1,3,3,2,3,2,9,11,5,6,7,8,8,8,4,10);
		static String strCharFrequency = "Miiikee";
		static String strFrequency = "Miiikee duck duck chuck tuck tuck";
		static String[] strArrayFrequency = {"Miiikee","duck", "Miiikee"};
		static List<String> listOfString = Arrays.asList("miiikee","duck", "chuck", "aba");

	}
}
@Data
@Builder
class Employee{
	String name;
	int age;
	String Department;
}
