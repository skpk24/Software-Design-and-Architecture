### Abstract Factory
--------------------

&#10024; **Intent**

**Abstract Factory** is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
     
&#128577; **Problem statement**

Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:

1. A family of related products, say: `Chair` + `Sofa` + `CoffeeTable`.


2. Several variants of this family. For example, products `Chair` + `Sofa` + `CoffeeTable` are available in these variants: `Modern`, `Victorian`, `ArtDeco`.

You need a way to create individual furniture objects so that they match other objects of the same family. Customers get quite mad when they receive non-matching furniture.


Also, you don’t want to change existing code when adding new products or families of products to the program. Furniture vendors update their catalogs very often, and you wouldn’t want to change the core code each time it happens.


&#128578; **Solution**

The first thing the **Abstract Factory** pattern suggests is to explicitly declare interfaces for each distinct product of the product family (e.g., chair, sofa or coffee table). Then you can make all variants of products follow those interfaces. For example, all chair variants can implement the `Chair` interface; all coffee table variants can implement the `CoffeeTable` interface, and so on.


The next move is to declare the *Abstract Factory*—an interface with a list of creation methods for all products that are part of the product family (for example, `createChair`, `createSofa` and `createCoffeeTable`). These methods must return **abstract** product types represented by the interfaces we extracted previously: `Chair`, `Sofa`, `CoffeeTable` and so on.


Now, how about the product variants? For each variant of a product family, we create a separate factory class based on the `AbstractFactory` interface. A factory is a class that returns products of a particular kind. For example, the `ModernFurnitureFactory` can only create `ModernChair`, `ModernSofa` and `ModernCoffeeTable` objects.


The client code has to work with both factories and products via their respective abstract interfaces. This lets you change the type of a factory that you pass to the client code, as well as the product variant that the client code receives, without breaking the actual client code.


Say the client wants a factory to produce a chair. The client doesn’t have to be aware of the factory’s class, nor does it matter what kind of chair it gets. Whether it’s a Modern model or a Victorian-style chair, the client must treat all chairs in the same manner, using the abstract `Chair` interface. With this approach, the only thing that the client knows about the chair is that it implements the `sitOn` method in some way. Also, whichever variant of the chair is returned, it’ll always match the type of sofa or coffee table produced by the same factory object.


There’s one more thing left to clarify: if the client is only exposed to the abstract interfaces, what creates the actual factory objects? Usually, the application creates a concrete factory object at the initialization stage. Just before that, the app must select the factory type depending on the configuration or the environment settings.


&#128736; **Applicability**

&#128519; **Use the Abstract Factory when your code needs to work with various families of related products, but you don’t want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.**

&#9758; The Abstract Factory provides you with an interface for creating objects from each class of the product family. As long as your code creates objects via this interface, you don’t have to worry about creating the wrong variant of a product which doesn’t match the products already created by your app.

* Consider implementing the Abstract Factory when you have a class with a set of **[Factory Methods](.Design-Patterns/Factory/factory.md)** that blur its primary responsibility.

* In a well-designed program each class is responsible only for one thing. When a class deals with multiple product types, it may be worth extracting its factory methods into a stand-alone factory class or a full-blown Abstract Factory implementation.


&#128221; **How To Implement**

1. Map out a matrix of distinct product types versus variants of these products.

2. Declare abstract product interfaces for all product types. Then make all concrete product classes implement these interfaces.

3. Declare the abstract factory interface with a set of creation methods for all abstract products.

4. Implement a set of concrete factory classes, one for each product variant.

5. Create factory initialization code somewhere in the app. It should instantiate one of the concrete factory classes, depending on the application configuration or the current environment. Pass this factory object to all classes that construct products.

6. Scan through the code and find all direct calls to product constructors. Replace them with calls to the appropriate creation method on the factory object.

&#9878; **Pros and Cons**

&#10004; Pros | &#10008; Cons
--------------|--------------
&#10004; You can be sure that the products you’re getting from a factory are compatible with each other. | &#10008; The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.
&#10004; You avoid tight coupling between concrete products and client code. | .
&#10004; *Single Responsibility Principle.* You can extract the product creation code into one place, making the code easier to support. | .
&#10004;  *Open/Closed Principle.* You can introduce new variants of products without breaking existing client code. | .
 
 
 **&#8644; Relationship with other Patterns**
 
- Many designs start by using [Facade](./Design-Patterns/Facade/facade.md) Method (less complicated and more customizable via subclasses) and evolve toward [Abstract Factory](./Design-Patterns/Abstract-Factories/abstract_factories.md), [Prototypes](./Design-Patterns/Prototypes/prototypes.md), or [Builders](./Design-Patterns/Builders/builders.md) (more flexible, but more complicated).
 
- **Builder** focuses on constructing complex objects step by step. [Abstract Factory](./Design-Patterns/Abstract-Factory/abstract_factory.md) specializes in creating families of related objects. *Abstract Factory* returns the product immediately, whereas *Builder* lets you run some additional construction steps before fetching the product.

- [Abstract Factory](./Design-Patterns/Abstract-Factories/abstract_factories.md) classes are often based on a set of [Factory Methods](./Design-Patterns/Factory/factory.md), but you can also use [Prototype](./Design-Patterns/Prototype/prototype.md) to compose the methods on these classes.

- [Abstract Factory](./Design-Patterns/Abstract-Factories/abstract_factories.md) can serve as an alternative to [Facade](./Design-Patterns/Facade/facade.md) when you only want to hide the way the subsystem objects are created from the client code.
 
- You can use [Abstract Factory](./Design-Patterns/Abstract-Factories/abstract_factories.md) along with [Bridge](./Design-Patterns/Bridge/bridge.md). This pairing is useful when some abstractions defined by [Bridge](./Design-Patterns/Bridge/bridge.md) can only work with specific implementations. In this case, **Abstract Factory** can encapsulate these relations and hide the complexity from the client code.
