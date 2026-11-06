# Pocket

Pocket is a statically and strongly typed programming language. There are four
basic types:

- `Int`: integer
- `Float`: floating-point number
- `Str`: string
- `Bool`: boolean

All type names in Pocket should use CamelCase. To declare and define a variable,
use the `val` (immutable) or `var` (mutable) keyword:

```bash
# The type of `foo` is inferred as `Int`.
val foo = 5

# The default value of `bar` is `false`.
var Bool bar

# In Pocket, strings must be enclosed in single quotes.
val sentence = 'Hello world!'
```

Arrays can be created using the `array` keyword.

```bash
# The type of `numbers` is inferred as `Array<Int>`.
# Here, `val` only means that the reference `numbers` is immutable.
# The elements of the array are still mutable.
val numbers = array[3, 4, 5]

# An array can contain values of different types.
val Array<Any> words = array['bar', true, 0.5]

# The length of an array is fixed.
val first = numbers[0]
numbers[1] = 8
val length = numbers.length
```

In Pocket, functions are first-class citizens. They can be stored in variables:

```bash
val add = { Int x, Int y: Int => x + y }
```

Here, `Int x` and `Int y` are typed parameters, `:` separates the parameter list
from the return type, and `=>` separates the return type from the return
expression. Generics are also supported:

```bash
val add = <T is Addable> { T x, T y: T => x + y }
```

Here, `<T is Addable>` declares a generic type `T` that is `Addable` (`is` is a
keyword that we will discuss later). A function can be invoked as follows:

```bash
val sum = add(3, 5)
```

If a function does not return anything, its return type is `Void`. If a function
does not take any arguments, the `=>` can be omitted. Such a function is called
a "block":

```bash
val printHelloWorld = { print('Hello world!') }
```

If a block function returns nothing (return type is `Void`), then it is
specifically called a "void block".

---

In Pocket, every structure enclosed in braces `{}` is a function. The syntax for
a conditional statement is:

```bash
val a = 5
val b = 7
if a > b then { print(a) } else { print(b) }
```

Here, the expression between `if` and `then` must return a `Bool`. The `then`
branch must be a block, `break` (a keyword that will be discussed later), or an
expression that returns a block. The same applies to the `else` branch.
Therefore, the following code is valid:

```bash
val a = 5
val b = 7
val printA = { print(a) }
val printB = { print(b) }
if a > b then printA else printB
```

In Pocket, the `loop` keyword is used to repeatedly execute the block that
follows it:

```bash
var count = 1
loop {
    print(count)
    count += 1
    if count > 100 then break
}
```

The `break` keyword ends the current function. If that function is being
executed directly by `loop`, it also terminates the loop. An ordinary function
call does not propagate `break` to its caller. In contrast, `return` only ends
the current function, so a loop executing it continues with the next iteration.

The `lift` keyword calls a block. If the block exits with `break`, execution
behaves as though `break` occurred at the `lift` site. Otherwise, execution
continues normally. This lets helpers such as `while` support `break`:

```bash
# `while` is a built-in helper function.
type VoidBlock = Fn<[], Void>
val while = { Fn<[], Bool> condition, VoidBlock block =>
    loop {
        if !condition() then break

        # Propagate a break from the body to this loop.
        lift block
    }
}

# Usage of the `while` function.
var count = 1
while ({ count < 100 }, {
    print(count)
    count += 1
})

# If the last supplied argument is a function literal, it can be moved
# outside the parentheses, regardless of its parameters or return type.
while ({ count < 100 }) {
    print(count)
    count += 1
}
```

Draft question: should `if` implicitly lift its selected block, so that a
`break` inside a braced branch propagates to the surrounding function?

---

In Pocket, a struct is an object, and it can be declared using `struct`:

```bash
# Define a struct.
val User = struct [
    Str name
    Int age
    Bool isActive
]

# Create an object.
val user = User[ name = 'James Chen', age = 27, isActive = true ]
print(user.age)  # Access attributes.
user.isActive = false  # Update attributes.
```

Note that `User` has a `Struct` type, which is created and maintained behind the
scenes. Pocket supports reflection:

```bash
print(User.name)    # 'User'
print(User.attributes.getKeys())   # '['name', 'age', 'isActive']'
```

A struct can contain functions:

```bash
val User = struct [
    Str name
    Int age
    Bool isActive = true

    # `static` attributes are not copied for each object.
    # `final` attributes cannot be updated after initialization.
    # The concrete type of `create` can be inferred by the compiler.
    static final Fn create = { Str name, Int age =>
        User[ name = name, age = age]
    }

    # As syntactic sugar, `def` is equivalent to `static final Fn`.
    # The type of `deactivate` is `Fn<[User], Void>`.
    # The `;` at the end of the function indicates that the function returns
    # nothing; in other words, it has no return expression.
    def deactivate = { User user => user.isActive = false; }
]
```

A struct value can be used as a type. A type can be an identifier, and the
compiler checks that the identifier has type `Struct`.

If an attribute is marked as `final`, it cannot be updated after initialization.
For example:

```bash
val Foo = struct [
    final Str bar
]

val foo = Foo[ bar = 'bar' ]
foo.bar = 'bar2'    # Not allowed; causes a compile-time error.
```

If an attribute is marked as `static`, only one copy of it exists for the entire
program. By combining `final` and `static`, we can define methods, as mentioned
earlier, as well as constants:

```bash
val Math = struct [
    static final PI = 3.1415926
]
```

```bash
# An attribute can be either private or public (the default).
# A private attribute can only be accessed by internal methods (i.e., final
# function attributes). Note that non-final public function attributes can be
# modified externally, so allowing them to access private attributes would be
# unsafe.
val Student = struct [
    Int ID
    private Int GPA

    def getGPA = { Student student => student.GPA };
]
```

---

In Pocket, every file is considered as a function. If it only contains a value:

```bash
# value.pk
3
```

Then it is considered a `{ 3 }`: a block returning 3. Pocket can execute it; it
will print the return value of the function unless its return type is `Void`:

```bash
$ pocket value.pk
3
```

A file function can take zero or one parameter. If it takes one, that parameter
contains the filename followed by the command-line arguments:

```bash
# greet.pk
args =>
print('Hello, ' + args[1] + '!')
# args[0] is `greet.pk`
```

Here, the type of `args` is `Array<Str>`, which is inferred by the compiler.

```bash
$ pocket greet.pk world
Hello, world!
```

---

A void block can export values:

```bash
val Math = {
    export val PI = 3.1415926
    export val max = <T is Comparable> { T x, T y => if x > y then { x } else { y } }
}

val [PI, max] = import Math
print(max(5, 3))    # '5'
```

The `import` keyword calls `Math`, collects its exported bindings, and caches
the resulting object. All exported bindings are immutable, and subsequent
imports of the same module reuse the cached object without calling the function
again. Ordinary calls to `Math()` execute the function without collecting
exports or initializing the import cache.

`import Math` returns an object like this:

```bash
[
    Float PI = 3.1415926
    Fn max = <T is Comparable> { T x, T y => if x > y then { x } else { y } }
]
```

And `val [PI, max] = import Math` is destructuring. If `import` is followed by a
string, Pocket will call the file (recall that a Pocket file is a function)
instead:

```bash
# common/util.pk
export val greet = { Str name => print('Hello, ' + name + '!') }
```

```bash
# main.pk
# Here, the extension `.pk` will be appended by the compiler
val [greet] = import 'common/util'
greet('world')
```

---

Pocket supports piping with `->`.

```bash
val greet = { Str name => print('Hello, ' + name + '!') }

# Normal invocation
greet('James')

# Piping invocation
'James' -> greet
```

The left-hand side of `->` is a value, and the right-hand side is a function
receiving exactly one argument. The two invocations are equivalent: `value -> fn`
is syntactic sugar for `fn(value)`. Pipes chain from left to right.

Pocket also supports partial application. Supplying fewer arguments than a
function requires binds those arguments from left to right and produces a
function accepting the remaining parameters.

If the last supplied argument is a function literal, it can be written outside
the parentheses, even in a partial call. If no arguments remain inside the
parentheses, they can be omitted. The following example combines these rules:

```bash
# `each` is a built-in function defined as below.
val each = <T> { Fn<[T], Void> fn, Array<T> array =>
    var idx = 0
    loop {
        if idx >= array.length then break
        fn(array[idx])
        idx += 1
    }
}

# The type of `fruits` is inferred to be `Array<Str>`.
val fruits = array[ 'banana', 'apple', 'orange' ]
# Here, the type of `fruit` can be inferred to be `Str`.
fruits -> each { fruit => print('I ate ' + fruit) }
```

Here, `each { fruit => print('I ate ' + fruit) }` means
`each({ fruit => print('I ate ' + fruit) })`. This partial call supplies the
callback and produces a function accepting an `Array<T>`. The pipe passes
`fruits` to that function, allowing `T` and the type of `fruit` to be inferred
as `Str`. The complete invocation is equivalent to:

```bash
each({ Str fruit => print('I ate ' + fruit) }, fruits)
```

```bash
# `map` is a built-in function defined as below.
val map = <T, R> { Fn<[T], R> fn, Array<T> array: Array<R> =>
    val length = array.length
    # Here, `array(length)[]` creates an array of length `length` filling with
    # default values of `R` (0 for Int, 0.0 for Float, false for Bool, '' for
    # Str, null for objects).
    val Array<R> res = array(length)[]
    var idx = 0
    loop {
        if idx >= length then break
        res[idx] = fn(array[idx])
        idx += 1
    }
    res
}

val numbers = array[ 2, 5, 8 ]
numbers -> map { n => Math.pow(n, 2) } -> each { n => print(n) }

# Took inspiration from Kotlin, I want to add the following feature if possible:
# If an anonymous function only has one parameter, then the parameter list and
# `=>` can be omitted, and `$` is used to represent the first argument.
numbers -> map { Math.pow($, 2) } -> each { print($) }
```
