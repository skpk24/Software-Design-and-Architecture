### Factory Method
-------------

&#10024; **Intent**

*Factory Method* is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.     

&#128577; **Problem statement**

Imagine that you’re creating a logistics management application. The first version of your app can only handle transportation by trucks, so the bulk of your code lives inside the `Truck` class.


After a while, your app becomes pretty popular. Each day you receive dozens of requests from sea transportation companies to incorporate sea logistics into the app.


Great news, right? But how about the code? At present, most of your code is coupled to the `Truck` class. Adding `Ships` into the app would require making changes to the entire codebase. Moreover, if later you decide to add another type of transportation to the app, you will probably need to make all of these changes again.

As a result, you will end up with pretty nasty code, riddled with conditionals that switch the app’s behavior depending on the class of transportation objects.



&#128578; **Solution**

The Factory Method pattern suggests that you replace direct object construction calls (using the `new` operator) with calls to a special factory method. Don’t worry: the objects are still created via the `new` operator, but it’s being called from within the factory method. Objects returned by a factory method are often referred to as “products.”

At first glance, this change may look pointless: we just moved the constructor call from one part of the program to another. However, consider this: now you can override the factory method in a subclass and change the class of products being created by the method.

There’s a slight limitation though: subclasses may return different types of products only if these products have a common base class or interface. Also, the factory method in the base class should have its return type declared as this interface.

For example, both `Truck` and `Ship` classes should implement the `Transport` interface, which declares a method called `deliver`. Each class implements this method differently: trucks deliver cargo by land, ships deliver cargo by sea. The factory method in the `RoadLogistics` class returns truck objects, whereas the factory method in the `SeaLogistics` class returns ships.

The code that uses the factory method (often called the client code) doesn’t see a difference between the actual products returned by various subclasses. The client treats all the products as abstract `Transport`. The client knows that all transport objects are supposed to have the `deliver` method, but exactly how it works isn’t important to the client.

&#128736; **Applicability**

&#128519; **Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should work with.**

&#9758;The Factory Method separates product construction code from the code that actually uses the product. Therefore it’s easier to extend the product construction code independently from the rest of the code.

For example, to add a new product type to the app, you’ll only need to create a new creator subclass and override the factory method in it.

&#128519; **Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal components.**

&#9758; Inheritance is probably the easiest way to extend the default behavior of a library or framework. But how would the framework recognize that your subclass should be used instead of a standard component?

The solution is to reduce the code that constructs components across the framework into a single factory method and let anyone override this method in addition to extending the component itself.

Let’s see how that would work. Imagine that you write an app using an open source UI framework. Your app should have round buttons, but the framework only provides square ones. You extend the standard `Button` class with a glorious `RoundButton` subclass. But now you need to tell the main `UIFramework` class to use the new button subclass instead of a default one.

To achieve this, you create a subclass `UIWithRoundButtons` from a base framework class and override its `createButton` method. While this method returns `Button` objects in the base class, you make your subclass return `RoundButton` objects. Now use the `UIWithRoundButtons` class instead of `UIFramework`. And that’s about it!


&#128519; **Use the Factory Method when you want to save system resources by reusing existing objects instead of rebuilding them each time.**

&#9758; You often experience this need when dealing with large, resource-intensive objects such as database connections, file systems, and network resources.

Let’s think about what has to be done to reuse an existing object:

1. First, you need to create some storage to keep track of all of the created objects.

2. When someone requests an object, the program should look for a free object inside that pool.

3. … and then return it to the client code.

4. If there are no free objects, the program should create a new one (and add it to the pool).

That’s a lot of code! And it must all be put into a single place so that you don’t pollute the program with duplicate code.

Probably the most obvious and convenient place where this code could be placed is the constructor of the class whose objects we’re trying to reuse. However, a constructor must always return new objects by definition. It can’t return existing instances.

Therefore, you need to have a regular method capable of creating new objects as well as reusing existing ones. That sounds very much like a factory method.

&#128221; **How To Implement**

1. Make all products follow the same interface. This interface should declare methods that make sense in every product.

2. Add an empty factory method inside the creator class. The return type of the method should match the common product interface.

3. In the creator’s code find all references to product constructors. One by one, replace them with calls to the factory method, while extracting the product creation code into the factory method.

You might need to add a temporary parameter to the factory method to control the type of returned product.

At this point, the code of the factory method may look pretty ugly. It may have a large `switch` operator that picks which product class to instantiate. But don’t worry, we’ll fix it soon enough.

4. Now, create a set of creator subclasses for each type of product listed in the factory method. Override the factory method in the subclasses and extract the appropriate bits of construction code from the base method.

5. If there are too many product types and it doesn’t make sense to create subclasses for all of them, you can reuse the control parameter from the base class in subclasses.

For instance, imagine that you have the following hierarchy of classes: the base `Mail` class with a couple of subclasses: `AirMail` and `GroundMail`; the `Transport` classes are `Plane`, `Truck` and `Train`. While the `AirMail` class only uses `Plane` objects, `GroundMail` may work with both `Truck` and `Train` objects. You can create a new subclass (say `TrainMail`) to handle both cases, but there’s another option. The client code can pass an argument to the factory method of the `GroundMail` class to control which product it wants to receive.


6. If, after all of the extractions, the base factory method has become empty, you can make it abstract. If there’s something left, you can make it a default behavior of the method.

&#9878; **Pros and Cons**

&#10004; Pros | &#10008; Cons
--------------|--------------
&#10004; You avoid tight coupling between the creator and the concrete products. | &#10008; The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.
&#10004; Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support. | .
&#10004; Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code. | .
 
 
 **&#8644; Relationship with other Patterns**
 
- Many designs start by using Factory Method (less complicated and more customizable via subclasses) and evolve toward [Abstract Factories](./Design-Patterns/Abstract-Factories/abstract_factories.md), [Builders](./Design-Patterns/Builders/builders.md) or [Prototypes](./Design-Patterns/Prototypes/prototypes.md) (more flexible, but more complicated).


- [Abstract Factories](./Design-Patterns/Abstract-Factories/abstract_factories.md) classes are often based on a set of Factory Methods, but you can also use [Prototype](./Design-Patterns/Prototypes/prototypes.md) to compose the methods on these classes.


- You can use Factory Method along with [Iterator](./Design-Patterns/Iterator/iterator.md) to let collection subclasses return different types of iterators that are compatible with the collections.
      
      
- [Prototype](./Design-Patterns/Prototypes/prototypes.md) isn’t based on inheritance, so it doesn’t have its drawbacks. On the other hand, Prototype requires a complicated initialization of the cloned object. Factory Method is based on inheritance but doesn’t require an initialization step.

- Factory Method is a specialization of [Template Method](./Design-Patterns/Template/template.md). At the same time, a Factory Method may serve as a step in a large Template Method.
