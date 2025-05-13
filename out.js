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
const $global = {};
$global['$_samples_std'] = { export: {} };
function $_samples_std() {
const identity = function (x) {
return x;
};
$global['$_samples_std']['export']['identity'] = identity
const range = function *(start, end) {yield* $buildGenerator(function () {
return start;
}, identity, function (v) {
return (v + 1);
}, function (v) {
return (v < end);
})
};
$global['$_samples_std']['export']['range'] = range

return 0;
}

$_samples_std();
$global['$_samples_iteration'] = { export: {} };
function $_samples_iteration() {
const { range } = $global['$_samples_std']['export'];
(function(x) { return each(function (num) {
return println(num);
}, x) })(range(1, 10));
return 0;
}
;
const $exitCode = $_samples_iteration();
process.exit($exitCode);