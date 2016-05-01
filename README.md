# pbt-java6

I have become a big fan of property based testing (PBT) and the associated frameworks that are available.  However 
Java 6 has very limited support for property based testing primarily because:

- It does not have lambdas - this makes combining generators and creating code blocks a little cumbersome,
- It does not have collection classes - so performing operations over lists is typically done using loops rather than using nifty functional constructs like map, fold (or reduce) and filter.

Over the past couple of months I have had a need to create PB tests on projects where the developers associated with
the project are not comfortable to adopt a new language such as Scala for the purposes of testing.  So I knocked 
together the following library whilst performing the String Calculator Kata hoping to see what would pop out.  Much to
my surprise most of the effort went into creating the boilerplate code necessary to support PBT in Java 6 rather than
the tests themselves.

So this is the output of that Kata - I have moved the Kata into the test package and the boilerplate code and the
testing library into the main package.

# The Concept

The scope of a traditional unit test is centered around cherry picking data to validate a specific scenario.  This works
 well to validate that the code under test is behaving as it is expected to.  The issue with this style of testing is that
 you only test scenarios that you can think of.  The philosophy behind PBT is to confirm that the invariant between a 
 component's input and output data is valid for a set of input data.
   
# An Example

The structure of a PBT is to describe the inputs to the test using one or more generators and then to validate that, 
 given the input the results are as expected.
 
Using the [String Calculator](http://osherove.com/tdd-kata-1/) as a backdrop let's look at a number of scenarios.

## Given an integer should return its value

```java
	import za.co.no9.pbt.Generator;
	import za.co.no9.pbt.IntegerGenerator;
	import static za.co.no9.pbt.Gen.forAll;

    @Test
    public void given_an_integer_should_return_its_value() {
    	Generator<Integer> integers = IntegerGenerator.from(-2000, 2000);
    	
		forAll(integers, new Consumer<Integer>() {
			public void accept(Integer n) throws Exception {
				assertEquals(n, add(n.toString()));
			}
		});
    }
```

Notes:

* This library is used within a normal jUnit test - there is no need to include any other framework or exotic parent 
classes.
* The variable `integers` is a generator that, when the method `next` is invoked on it, will return an `Integer` in the
range -2000 and 2000.
* The `forAll` construct accepts one or more generators and a function.  `forAll` then executes the function `za.co.no9.pbt.Gen.ITERATIONS`
 number of times by invoking this function with values that are supplied by call `next` on each of the generators.  In
 code the `forAll` method is implemented as
 
 ```java
     public static <T> void forAll(Generator<T> gen1, Consumer<T> consumer) {
         for (int i = 0; i < ITERATIONS; i += 1) {
             consumer.accept(gen1.next());
         }
     }
 ```
* All of Java's native data types have supported generators - `BooleanGenerator`, `ByteGenerator`, `CharacterGenerator`, 
`DoubleGenerator`, `FloatGenerator`, `IntegerGenerator`, `LongGenerator` and `ShortGenerator`.


## Given a list of integers should return the sum

```java
	import za.co.no9.pbt.Generator;
	import za.co.no9.pbt.IntegerGenerator;
	import static za.co.no9.pbt.Gen.forAll;

    @Test
    public void given_a_list_of_integers_should_return_its_value() {
    	Generator<List<Integer>> listOfIntegers = IntegerGenerator.from(-2000, 2000).nonEmptyList();
    	
		forAll(listOfIntegers, new Consumer<List<Integer>>() {
			public void accept(List<Integer> ns) throws Exception {
				assertEquals(sum(ns), add(mkString(ns, ",")));
			}
		});
    }
```

Notes:

* The methods `sum` and `mkString` are helper functions.
* Each generator has a set of methods that can be applied to return a generator collection.  In the example above the
 variable `listOfIntegers` is a generator that is assembled by calling `nonEmptyList` on the `integers` collection from the 
 previous example.  In the same way it is possible to create a Set from a generator.
* A complete set of tests for the kata can be found in the `kata` test package.


# Library Dependency

```xml
	<dependency>
		<groupId>za.co.no9</groupId>
		<artifactId>pbt-java6</artifactId>
		<version>1.0</version>
	</dependency>
```

# Generators

A number of generators are included within this library are listed below.  The code to support these generators is simple.
I would encourage anyone wishing to use this library to take a look at this code - once you have seen this code you'll 
realise that creating a generator from scratch is dead easy. 

| Name | Purpose |
|------|---------|
| AsStringGenerator | Is constructed with a generator and, when `next` is invoked, will invoke `toString` on the result.  This generator is useful for creating string representations of collections - for example a list of characters generator as a means to create strings. |
| BooleanGenerator | Returns a `true` or `false` whenever `next` is invoked. |
| ByteGenerator | Returns a byte value whenever `next` is invoked. |
| CharacterGenerator | Returns a character value whenever `next` is invoked. |
| ConstantGenerator | Returns a constant value whenever `next` is invoked.  The constant that is returned is past to the generator when it is constructed. |
| DoubleGenerator | Returns a double value whenever `next` is invoked. |
| FilterGenerator | Accepts a generator and a predict in the constructor. Whenever `next` is invoked it'll return a value created by the embedded generator that satisfies the constraint imposed by the predicate. |
| FloatGenerator | Returns a float value whenever `next` is invoked. |
| IntegerGenerator | Returns an integer value whenever `next` is invoked. |
| ListOfGenerator | Returns a list of values where the values have been generated from the passed generator. |
| LongGenerator | Returns a long value whenever `next` is invoked. |
| MapGenerator | Returns a map where the keys and values have been generated from two passed generators. |
| NonEmptyListOfGenerator | Returns a non-empty list of values where the values have been generated from the passed generator. |
| NonEmptySetOfGenerator | Returns a non-empty set of values where the values have been generated from the passed generator.|
| OneOfGenerator | Returns a value from a collection of values passed into this generator's constructor. |
| SetOfGenerator | Returns a set of values where the values have been generated from the passed generator. |
| ShortGenerator | Returns a short value whenever `next` is invoked. |