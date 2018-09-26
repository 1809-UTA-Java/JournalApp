# Java
Java is an object-oriented programming language and a platform developed 
by Sun Microsystems (eaten by Oracle). It uses the WORA principle (Write Once, Run Anywhere),
meaning a Java application can be executed on any platform with a JVM (Java Virtual Machine). It's a
flexible and popular language for many years, allowing developers to write large client-server
web applications, desktop and mobile applicatiions, and framworks and libraries.

## Features
**Platform independence**: The compiler converts source code into bytecode,
then the JVM executes that bytecode. While each operating system has their own JVM implementation,
so every JVM can execute bytecode regardless of origin of said code.

**Clear, verbose syntax** Java has C-like syntax like C++ and C#,
many syntax elements of the language are readable and widely used in programming.The Java API
(Application Programming Interface) is also written using verbose, descriptive naming conventions
making it simple to parse large code bases.

**Muli-paradigm** While Java is object-oriented, it supports multiple paradigms such as
imperative, generic, concurrent, and functional.

**Garbage collection** The JVM performs automatic memory deallocation of unused objects at runtime. 
Programs are written without the need for complex memory management.

**Multihreading** Java supports multithreading at both language and the stardard library levels.
It allows concurrent and parallel execution of several parts of a Java program.

**Object-Oriened Programming** Although Java accomadates several paradigms, OOP is the foundation
for most applications. In OOP, a program is organized into objects encapsulating related fields
(representing its *state*) and methods (usually to control that state or perfrom related functions)
When defining objects, Java reserves the keyword *class* (not to be confused with the *.class* file
extension) which serves as their blueprint. An object in Java represents an instance in memory of a
class, and also every class implicitly inherits from the *Object* superclass which provides useful
convenience methods such as *equals()* and *toSTring()*. Java popularized several 'Pillars' of OOP
design theory. While the numbers vary between OOP languages, Java focuses on four:

*Abstraction* -By simplifying objects to a set of useful features, we hide irrelevant details,
reduce complexity, and increase efficiency.
Abstraction is important at all levels of software and computer engineering, but essential to
designing useful objects. Complicated real-world objects are reduced to simple representations.

*Encapsulation* - Objects should group together related variables and functions and be in 
complete control over them. So the state of an object should only change, if ever, through 
the object itself. Also known as data hiding, because the object has sole responsibility for
its fields, and no outside object or function should interfere.

*Inheritence* - Code reuse is an important principle of programming
(DRY - Don't Repeat Yourself), and new classes can reuse code from existing ones. This 
establishes a superclass-subclass (or parent-child) relationship where the derived classes inherit
(and sometimes change) fields and methods from its parent.

*Polymorphism* - With inheritence, an object of a derived class can be referenced as instances of its
parent class. This provides flexibily when invoking inherited methods with varying implementations
in derived classes.





