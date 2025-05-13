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
const $global = {};
$global['$_samples_list'] = { export: {} };
function $_samples_list() {
const list = [1,2,3];
(function(x) { return each(println, x) })(list);
return 0;
}

const $exitCode = $_samples_list();
process.exit($exitCode);