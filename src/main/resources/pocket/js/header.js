function $loop(fn) {
    while (true) {
        if (fn() === true) break
    }
}

function* $buildGenerator(initializer, toYield, next, isAlive) {
    let value = initializer()
    while (true) {
        if (isAlive(value)) {
            yield toYield(value)
            value = next(value)
        } else {
            return
        }
    }
}

function println(x) {
    console.log(x);
}

function each(fn, iterator) {
    for (const e of iterator) fn(e)
}