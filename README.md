# pbt-java6

I have become a big fan of property based testing (PBT) and the associated frameworks that are available.  However 
Java 6 has very limited support for property based testing primarily because:

- It does not have lambdas - this makes combining generators and creating code blocks a little cumbersome,
- It does not have collection classes - so performing operations over lists is typically done using loops rather than using nifty functional constructs like map, fold (or reduce) and filter.

Over the past couple of months I have had a need to create PB tests on projects where the developers associated with
the project are not comfortable to adopt a new language such as Scala for the purposes of testing.  So I knocked 
together the following library whilst performing the String Calculator Kata hoping to see what would pop out.  Much to
my suprise most of the effort went into creating the boilerplate code necessary to support PBT in Java 6 rather than
the tests themselves.

So this is the output of that Kata - I have moved the Kata into the test package and the boilerplate code and the
testing library into the main package.

Enjoy - the code really is simple.
