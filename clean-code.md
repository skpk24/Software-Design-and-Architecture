# Clean Code

## Code smells : Code smell is any characteristic in the source code of a program that possibly indicates a deeper problem.

That doesn't means a bug, code smells are usually not a bugs, they are not technically incorrect or don't ruin the programefrom functioning. Instead they indicate weaknesses in design that may slowdown the development or increase the risk of bugs or failures in the future. 

Bad code smells can be an indicator of factors that contribute to technical debt. 

## Comments
Are comments necessary?

* Why?

* What?

* Comments are for people not for machines

Think about refactoring the code so that comments are not needed

## Long Method

Try avoiding longer methods. Short methods are easier to read and understand for a developer who looks at the code

* Ideal lines of code - 20

* Methods with 5 lines of code, indicate that you are breaking up the code too much, making it harder to understand


## Too Many Parameters

Avoid to many parameters in the method signature.

* Ideal number of parameters (as per checkstyle static code analyzer) - 7

* Keeping it less than 5 makes it easy to read and understand


## Type Embedded in Name

Avoid embedding types to the variable names.

Bad Examples  | Good Examples
------------- | -------------
List<Student> listOfStudents; | List<Student> students;
Map<Student> mapOfStudents; | Map<Student> students;
String sStudent; | String student;
int iAmount; | int amount;
  
  
## Inconsistent Names

Many developers have trouble with naming the methods or variables with an efficient name.

### Examples

* Use lower case for packages

* Use camel case of variables and method names

* Avoid using ‘_’

* Avoid name starting with number

## Dead Code

Unused code? Or commented code? Delete is before you push to repository.

## Temporary Fields

Avoid using too many temporary fields in the code. If your class has too many temporary fields - time to refactor the code.

## Refused Bequest

A derived class does not honor the contract of the base class.

Example - Liskov’s Substitution Principle

