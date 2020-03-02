### Builder
-------------

&#10024; **Intent**

**Builder** is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
     
&#128577; **Problem statement**

Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects. Such initialization code is usually buried inside a monstrous constructor with lots of parameters. Or even worse: scattered all over the client code.

For example, let’s think about how to create a `House` object. To build a simple house, you need to construct four walls and a floor, install a door, fit a pair of windows, and build a roof. But what if you want a bigger, brighter house, with a backyard and other goodies (like a heating system, plumbing, and electrical wiring)?

The simplest solution is to extend the base `House` class and create a set of subclasses to cover all combinations of the parameters. But eventually you’ll end up with a considerable number of subclasses. Any new parameter, such as the porch style, will require growing this hierarchy even more.

There’s another approach that doesn’t involve breeding subclasses. You can create a giant constructor right in the base `House` class with all possible parameters that control the house object. While this approach indeed eliminates the need for subclasses, it creates another problem.

In most cases most of the parameters will be unused, making the constructor calls pretty ugly. For instance, only a fraction of houses have swimming pools, so the parameters related to swimming pools will be useless nine times out of ten.


&#128578; **Solution**

The **Builder pattern** suggests that you extract the object construction code out of its own class and move it to separate objects called *builders*.


The pattern organizes object construction into a set of steps (buildWalls, buildDoor, etc.). To create an object, you execute a series of these steps on a builder object. The important part is that you don’t need to call all of the steps. You can call only those steps that are necessary for producing a particular configuration of an object.


Some of the construction steps might require different implementation when you need to build various representations of the product. For example, walls of a cabin may be built of wood, but the castle walls must be built with stone.


In this case, you can create several different builder classes that implement the same set of building steps, but in a different manner. Then you can use these builders in the construction process (i.e., an ordered set of calls to the building steps) to produce different kinds of objects.

For example, imagine a builder that builds everything from wood and glass, a second one that builds everything with stone and iron and a third one that uses gold and diamonds. By calling the same set of steps, you get a regular house from the first builder, a small castle from the second and a palace from the third. However, this would only work if the client code that calls the building steps is able to interact with builders using a common interface.



&#128736; **Applicability**

&#128519; **Use the Builder pattern to get rid of a “telescopic constructor”.**

&#9758; Say you have a constructor with ten optional parameters. Calling such a beast is very inconvenient; therefore, you overload the constructor and create several shorter versions with fewer parameters. These constructors still refer to the main one, passing some default values into any omitted parameters.

The Builder pattern lets you build objects step by step, using only those steps that you really need. After implementing the pattern, you don’t have to cram dozens of parameters into your constructors anymore.

&#128519; **Use the Builder pattern when you want your code to be able to create different representations of some product (for example, stone and wooden houses).**

&#9758; The Builder pattern can be applied when construction of various representations of the product involves similar steps that differ only in the details.

The base builder interface defines all possible construction steps, and concrete builders implement these steps to construct particular representations of the product. Meanwhile, the director class guides the order of construction.

&#128519; **Use the Builder to construct Composite trees or other complex objects.**

&#9758; The Builder pattern lets you construct products step-by-step. You could defer execution of some steps without breaking the final product. You can even call steps recursively, which comes in handy when you need to build an object tree.

A builder doesn’t expose the unfinished product while running construction steps. This prevents the client code from fetching an incomplete result.


&#128221; **How To Implement**

1. Make sure that you can clearly define the common construction steps for building all available product representations. Otherwise, you won’t be able to proceed with implementing the pattern.


2. Declare these steps in the base builder interface.

3. Create a concrete builder class for each of the product representations and implement their construction steps.

Don’t forget about implementing a method for fetching the result of the construction. The reason why this method can’t be declared inside the builder interface is that various builders may construct products that don’t have a common interface. Therefore, you don’t know what would be the return type for such a method. However, if you’re dealing with products from a single hierarchy, the fetching method can be safely added to the base interface.

4. Think about creating a director class. It may encapsulate various ways to construct a product using the same builder object.

5. The client code creates both the builder and the director objects. Before construction starts, the client must pass a builder object to the director. Usually, the client does this only once, via parameters of the director’s constructor. The director uses the builder object in all further construction. There’s an alternative approach, where the builder is passed directly to the construction method of the director.

6. The construction result can be obtained directly from the director only if all products follow the same interface. Otherwise, the client should fetch the result from the builder.

&#9878; **Pros and Cons**

&#10004; Pros | &#10008; Cons
--------------|--------------
&#10004; You can construct objects step-by-step, defer construction steps or run steps recursively. | &#10008; The overall complexity of the code increases since the pattern requires creating multiple new classes.
&#10004; You can reuse the same construction code when building various representations of products. | .
&#10004; You can reuse the same construction code when building various representations of products. | .
&#10004;  Single Responsibility Principle. You can isolate complex construction code from the business logic of the product. | .
 
 
 **&#8644; Relationship with other Patterns**
 
- Many designs start by using [Facade](./Design-Patterns/Facade/facade.md) Method (less complicated and more customizable via subclasses) and evolve toward [Abstract Factory](./Design-Patterns/Abstract-Factory/abstract_factory.md), [Prototypes](./Design-Patterns/Prototypes/prototypes.md), or [Builders](./Design-Patterns/Builders/builders.md) (more flexible, but more complicated).
 
- **Builder** focuses on constructing complex objects step by step. [Abstract Factory](./Design-Patterns/Abstract-Factory/abstract_factory.md) specializes in creating families of related objects. *Abstract Factory* returns the product immediately, whereas *Builder* lets you run some additional construction steps before fetching the product.

- You can use Builder when creating complex [Composite](./Design-Patterns/Composite/composite.md) trees because you can program its construction steps to work recursively.

- You can combine **Builder** with [Bridge](./Design-Patterns/Bridge/bridge.md): the director class plays the role of the abstraction, while different builders act as implementations.
 
- [Abstract Factories](./Design-Patterns/Abstract-Factories/abstract_factories.md), [Builders](./Design-Patterns/Builders/builders.md) and [Prototypes](./Design-Patterns/Prototypes/prototypes.md) can all be implemented as Singletons.
