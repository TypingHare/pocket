function $loop(fn) {
    while (true) {
        if (fn() === true) break
    }
}

function* $buildGenerator(initializer, isAlive, toYield, next, ) {
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

function println(...elements) {
    console.log(elements.map(e => String(e)).join(" "));
}

function each(fn, iterable) {
    if (typeof iterable[Symbol.iterator] === 'function') {
        for (const e of iterable) fn(e)
    } else if (typeof iterable === 'object') {
        for (const [key, value] of Object.entries(iterable)) {
            fn(key, value)
        }
    }
}