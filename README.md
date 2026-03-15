# Pocket

```Python
# Use a function to represent a class.
# This function contains three named parameters (also known as fields).
Car := { _,
    *make: str,
    *name: str,
    *price: i32,
    =>
}

# Create a partially fulfilled function to represent an instance.
car := Car(make="Toyota", name="Rav4", price=39_000)

# Get an argument from a partially fulfilled function.
price := car::price. # 39_000

# Define a function having two named parameters (`make` and `name`) to
# mimic a method for Car.
displayName := { *make: str, *name: str =>
   "{make} {name}" -> Stdout 
}

# Fulfill a function with a partially fulfilled function.
# A function is automatically called after completely fulfilled.
displayName(&car)  # unpack `car` to fulfill `displayName`

# However, it is possible that the `car` instance doesn't have enough
# fields to fulfill `displayName`, in which case a function is
# returned.

# Because `displayName` returns `nil` if fulfilled, and a partially
# fulfilled function not, we can do this to check if it is run
# successuflly.
if displayName(&car) {
    "displayName is not fulfilled" -> Stderr
}

# What if we want to display the name if `make` is not fulfilled in the
# object? We first define the following function.
displayNameWithoutMake := { *name: str => name -> Stdout }

# Then, we call it like this:
displayNameWithoutMake(&displayName(&car))

# When the inner `displayName` is fulfilled, it is called and returns
# None, and thus `displayNameWithoutMake` will not be fulfilled.
# Otherwise, `displayName` is unpacked and `displayNameWithoutMake` can
# be fulfilled.
# We can simplify it with chain (syntactic sugar):
&car -> &displayName -> displayNameWithoutMake
```