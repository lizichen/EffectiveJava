## Topics
- Interface & `Comparator` & `Comparable`
    + `Comparable` class must ``implements`` the **java.lang.Comparable** interface.
    + A `Comparable` class compares the class itself with other class.
    + A `Comparable` class must override the **compareTo** function.  
    + `Comparator` is a class that compares two objects.
- Java Generics
    + Type Inference https://docs.oracle.com/javase/tutorial/extra/generics/subtype.html
- `HashMap`, `Hashtable`, `HashSet`
    + `Hashtable` is synchronized.
    + `Hashtable` does not allow `null` key or value.
- `Lambda`  Functional Programming in Java 8
    + Higher Order Functions - function that receive function(s) as argument(s) and can return function(s).
- Tree
    + Inorder, pre-order, post-order.
    + Stack, Queue, Morris Traversal
    + Recursion, Iteration
    + Level, Leaf, Root, Path
- `final`
    + `final` variable: the value cannot be changed once initialized.
    + `final` function: the function cannot be `overriden` by a subclass.
    + `final` class: the class cannot be subclass-ed.
- `finally` is used with `try/catch` block.
    + Even when an exception is thrown. the `finally` block will be executed.
    + ```java
    try {
    ...
    } catch(Exception ex) {
    ...
    } finally {
    ...
    }
    ```
- `finalize()` is the method called by Java's automatic garbage collector before destroying the object. Overriding `finalize()` method can customize the behavoir during garbage collection.
    + ```java
    protected void finalize() throws Throwable {
        /* do something i.e., close the open files, release resources, etc. */
    }
    ```
- `overload` vs. `override`
    + `overload` is when two functions have the **same** name but **different** types or numbers of arguments.
        ```java
        public double computeArea(Circle c){
            ...
        }

        public double computeArea(Square s){
            ...
        }
        ```
    + `override`: same function name in different class in different hierachy.
- Notable ASCII values for `Character`:

    | ASCII | char | ASCII | char |
    |-------|------|-------|------|
    | 48    | '0'  | 65    | 'A'  |
    | 57    | '9'  | 90    | 'Z'  |
    |       |      | 97    | 'a'  |
    |       |      | 122   | 'z'  |
- Notable Logic Gate Operations:
    + **XOR**: `A^B`
    + **NAND**: Java does not have **NAND** logic operator but can be rewritten as `!(a && b)` or `!a || !b`.
- Class access control modifier: `private, protected, public`

    | Modifier        | Class | Package | Subclass | World |
    |-----------------|-------|---------|----------|-------|
    | public          | Y     | Y       | Y        | Y     |
    | protected       | Y     | Y       | Y        | N     |
    | **no modifier** | Y     | Y       | N        | N     |
    | private         | Y     | N       | N        | N     |
- **Object Reflection**: is a feature in Java which provides a way to get reflective information about Java classes and objects, and perform operations such as:
    + Getting information about the methods and fields present inside the class at runtime.
    + Creating a new instance of a class.
    + Getting and setting the object fields directly by getting field reference, regardless of what the access modifier is.

<!-- TODO: The following topics needs some expansion. -->
- RegEx
- `abstract` and `interface`
