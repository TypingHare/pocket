function $loop(fn) {
    while (true) {
        if (fn() === true) break
    }
}

function println(x) {
    console.log(x);
}