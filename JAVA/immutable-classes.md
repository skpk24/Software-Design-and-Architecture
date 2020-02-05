# Here is the list of immutable classes in Java

* java.lang.String

* 

* The wrapper classes for the primitive types: java.lang.Integer, java.lang.Byte, java.lang.Character, java.lang.Short, java.lang.Boolean, java.lang.Long, java.lang.Double, java.lang.Float

* java.lang.StackTraceElement (used in building exception stacktraces)

* Most enum classes are immutable, but this in fact depends on the concrete case. (Don't implement mutable enums, this will screw you up somewhen.) I think that at least all enum classes in the standard API are in fact immutable.

* java.math.BigInteger and java.math.BigDecimal (at least objects of those classes themselves, subclasses could introduce mutability, though this is not a good idea)

* java.io.File. Note that this represents an object external to the VM (a file on the local system), which may or may not exist, and has some methods modifying and querying the state of this external object. But the File object itself stays immutable. (All other classes in java.io are mutable.)

* java.awt.Font - representing a font for drawing text on the screen (there may be some mutable subclasses, but this would certainly not be useful)

* java.awt.BasicStroke - a helper object for drawing lines on graphic contexts
